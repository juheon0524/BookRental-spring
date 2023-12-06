package com.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.domain.Criterial;
import com.ezen.domain.PageDTO;
import com.ezen.service.BookService;
import com.ezen.service.RatingsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/book/*")
@Log4j
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	private final RatingsService ratingsService;
	
	
	@GetMapping("/bookMain")
	public void bookMain(Criterial cri, Model model) {
		
		// mainpage에서는 인기도서 및 신간도서를 각 5권씩만 조회
		cri.setPageNum(1);
		cri.setAmount(5);
		
		log.info("bookMain >> " + cri);
		model.addAttribute("bookPopularList", bookService.getListWithPagingByRentalCnt(cri));
		model.addAttribute("bookRecentList", bookService.getListWithPagingByPdate(cri));
		
	}
	
	@GetMapping("/bookSearchList")
	public void bookSearchList(Criterial cri, Model model) {
		
		log.info("bookSearchList >> " + cri);

		model.addAttribute("bookSearchList", bookService.getListWithPaging(cri));
		cri.setType("TCA");
		model.addAttribute("pageMaker", new PageDTO(cri, bookService.getTotalBookCount(cri)));
		
	}
	
	@GetMapping("/bookPopularList")
	public void bookPopularList(Criterial cri, Model model) {
		
		log.info("bookPopularList >> " + cri);

		model.addAttribute("bookPopularList", bookService.getListWithPagingByRentalCnt(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bookService.getTotalBookCount(cri)));
		
	}
	
	@GetMapping("/bookRecentList")
	public void bookRecentList(Criterial cri, Model model) {
		
		
		log.info("bookRecentList >> " + cri);

		model.addAttribute("bookRecentList", bookService.getListWithPagingByPdate(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bookService.getTotalBookCount(cri)));
		
	}

	@GetMapping("/bookDetail")
	public void bookDetail(String isbn, @ModelAttribute("cri")Criterial cri, Model model) {
		
		log.info("bookDetailView >> " + isbn + " : " + cri);

		model.addAttribute("bookVO", bookService.get(isbn));
//		model.addAttribute("ratingsList", ratingsService.getListPage(cri, isbn));
		
	}
}
