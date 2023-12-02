package com.ezen.mapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.BookVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookCrawlingLoad {
	
	@Autowired
	private BookMapper bookmapper;
	
	@Test
	public void crawlBooks() throws IOException {

		int pages = 20;
//		int pages = 1;
		int i = 1;
		
		for (i=1; i <= pages ; i ++) {
			
			String listUrl = "https://www.aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0&page=" + i + "&cnt=1000&SortOrder=1" ;
			Document docList = Jsoup.connect(listUrl).get(); //인기도서 목록 페이지
			Elements bookBoxes = docList.select("div.ss_book_box"); 
			
			for (Element bookBox : bookBoxes) {
	            if (bookBox.hasAttr("itemId")) {
	                String bookCode = bookBox.attr("itemId");
	                
	                // 특정 bookCode 값에 따라 실행 여부 결정
	                if (shouldSkipBook(bookCode)) {
	                    System.out.println("Skipping book with code: " + bookCode);
	                    continue;
	                }
	                
	                System.out.println("bookCode: " + bookCode);
	                
	                String detailUrl = "https://www.aladin.co.kr/shop/wproduct.aspx?ItemId="+ bookCode ;
	                Document docDetail = Jsoup.connect(detailUrl).get(); //인기상세정보 페이지
	                
	                BookVO book = BookVO.builder()
	        				.isbn(getMetaContent(docDetail, "books:isbn"))
	        				.title(getMetaContent(docDetail, "og:title"))
	        				.genrecode("100")
	        				.genrecrawled(getScriptDataValue(docDetail, "item_category"))
	        				.author(getMetaContent(docDetail, "og:author"))
	        				.publisher(getScriptDataValue(docDetail, "item_brand"))
	        				.publisheddate(getMetaContent2(docDetail, "datePublished"))
	        				.totbookcnt(10)
	        				.rentedbookcnt(0)
	        				.curbookcnt(10)
	        				.price(Integer.parseInt(getMetaContent(docDetail, "og:price")))
	        				.cumrentalcnt(0)
	        				.registereddate("2023-11-28")
	        				.memberid("admin1")
	        				.bookimgurl(getMetaContent(docDetail, "og:image"))
	        				.bookcontent(getMetaContent(docDetail, "og:description"))
	        				.build();
//	                System.out.println("BookVO: " + book);
	        		bookmapper.insertBook(book);
//	                String isbn = getMetaContent(docDetail, "books:isbn");
//	                System.out.println("ISBN: " + isbn);
//	                
//	                String title = getMetaContent(docDetail, "og:title");
//	                System.out.println("Title: " + title);
//	                
//	                String imageUrl = getMetaContent(docDetail, "og:image");
//	                System.out.println("Image URL: " + imageUrl);
//	                
//	                String price = getMetaContent(docDetail, "og:price");
//	                System.out.println("Price: " + price);
//	                
//	                String author = getMetaContent(docDetail, "og:author");
//	                System.out.println("Author: " + author);
//	                
//	                String content = getMetaContent(docDetail, "og:description");
//	                System.out.println("Content: " + content);
//
//	                String publishedDate = getMetaContent2(docDetail, "datePublished");
//	                System.out.println("Published: " + publishedDate);
//	                
//	                String publisher = getScriptDataValue(docDetail, "item_brand");
//	                System.out.println("Item Brand: " + publisher);
//
//	                String category = getScriptDataValue(docDetail, "item_category");
//	                System.out.println("Category: " + category);
	                
	            } else {
	                System.out.println("해당 요소에 itemId 속성이 없습니다.");
	            }
	        }
		}
		
	}
	
    // 메타 태그의 content 정보를 가져오는 메서드
    private static String getMetaContent(Document doc, String property) {
        Elements metaTags = doc.select("meta[property=" + property + "]");
//        Elements metaTags = doc.select("<meta property=" + property + " ");
        for (Element metaTag : metaTags) {
            return metaTag.attr("content");
        }
        return null;
    }
    
    // 메타 태그의 content 정보를 가져오는 메서드
    private static String getMetaContent2(Document doc, String itemprop) {
        Elements metaTags = doc.select("meta[itemprop=" + itemprop + "]");
        for (Element metaTag : metaTags) {
            return metaTag.attr("content");
        }
        return null;
    }
    
    // script 태그에서 특정 데이터 값을 가져오는 메서드
    private static String getScriptDataValue(Document doc, String variableName) {
        Elements scriptElements = doc.select("script");
        for (Element script : scriptElements) {
            String scriptContent = script.html();
            if (scriptContent.contains("\"" + variableName + "\":")) {
                int startIndex = scriptContent.indexOf("\"" + variableName + "\":") + variableName.length() + 4;
                int endIndex = scriptContent.indexOf(",", startIndex);
                return scriptContent.substring(startIndex, endIndex).replace("\"", "").trim();
            }
        }
        return null; // 해당하는 변수가 없을 경우
    }
    
    private static boolean shouldSkipBook(String bookCode) {
        // 특정 bookCode 값에 따라 실행 여부 결정
        List<String> skipBookCodes = Arrays.asList("328477993", "329279155", "328604048", "328287849", "328604018",
                "323087432", "329207140", "325361951", "329329071", "328288569", "328754635", "328288014", "327347420");

        return skipBookCodes.contains(bookCode);
    }
}
