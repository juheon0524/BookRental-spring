package com.ezen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.domain.Criterial;
import com.ezen.domain.RatingsPageDTO;
import com.ezen.service.RatingsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequiredArgsConstructor
@RequestMapping(value = "/ratings")
public class RatingsController {
	
	private final RatingsService ratingsService;
	
	@GetMapping(value ="/pages/{isbn}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<RatingsPageDTO> getList(@PathVariable("isbn") String isbn,
			@PathVariable("page") int page){
		
		Criterial cri = new Criterial(page, 10);
		log.info("getList.........isbn >> " + isbn + "  page >> " + page);
		return new ResponseEntity<RatingsPageDTO>(ratingsService.getListPage(cri, isbn), HttpStatus.OK);
	}

}
