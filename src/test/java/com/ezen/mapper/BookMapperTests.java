package com.ezen.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.BookVO;
import com.ezen.domain.Criterial;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookMapperTests {

	@Autowired
	private BookMapper bookmapper;
	
	@Test
	public void testInsert() {
		
		BookVO book = BookVO.builder()
				.isbn("9791192300818")
				.title("마흔에 읽는 쇼펜하우어")
				.genrecode("100")
				.genrecrawled("인문학")
				.author("강용수 지음")
				.publisher("유노북스")
				.publisheddate("2023-09-07")
				.totbookcnt(10)
				.rentedbookcnt(0)
				.curbookcnt(10)
				.price(15300)
				.cumrentalcnt(1)
				.registereddate("2023-11-28")
				.memberid("admin1")
				.bookimgurl("https://image.aladin.co.kr/product/32361/59/cover500/k592935565_2.jpg")
				.bookcontent("인생의 의미를 끊임없이 고민한 철학자, 아르투어 쇼펜하우어의 깨달음과 철학적 사유 중 현시대 우리가 고통을 해소하고 마음의 위기를 극복하는 데 도움이 될 내용을 30가지로 정리했다.")
				.build();
		
		bookmapper.insertBook(book);
	}

	@Test
	public void testGetListwithPaging() {

		Criterial cri = new Criterial();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BookVO> list = bookmapper.getListWithPaging(cri);
		list.forEach(book -> log.info(book)); 
	}
	
	@Test
	public void testgetListWithPagingByPdate() {

		Criterial cri = new Criterial();
		cri.setPageNum(2);
		cri.setAmount(10);
		
		List<BookVO> list = bookmapper.getListWithPagingByPdate(cri);
		list.forEach(book -> log.info(book)); 
	}
	
	@Test
	public void getListWithPagingByRentalCnt() {

		Criterial cri = new Criterial();
		cri.setPageNum(1);
		cri.setAmount(10);
		
		List<BookVO> list = bookmapper.getListWithPagingByRentalCnt(cri);
		list.forEach(book -> log.info(book)); 
	}
	
	@Test
	public void testRead() {
		BookVO vo = bookmapper.read("9791160406504");
		log.info("vo >> " + vo);
	}
	
	@Test
	public void testUpdate() {
		BookVO vo = bookmapper.read("9791192300818");
		log.info("vo >> " + vo);
		vo.setCumrentalcnt(12);
		int result = bookmapper.updateBook(vo);
		log.info("vo >> " + result + " >> " + vo);
		
	}
	
	@Test
	public void testGetCount() {
		Criterial cri = new Criterial();
//		cri.setType("TCA");
//		cri.setKeyword("유시민");
		cri.setType("");
		cri.setKeyword("");
		log.info(bookmapper.getTotalBookCount(cri));
	}
	
	@Test
	public void testSearchPaging() {
		Criterial cri = new Criterial();
		cri.setPageNum(2);
		cri.setAmount(10);
		cri.setType("TCA");
		cri.setKeyword("2024");
		bookmapper.getListWithPaging(cri).forEach(list -> log.info(list));
	}
	
}
