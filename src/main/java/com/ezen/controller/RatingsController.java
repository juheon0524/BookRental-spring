package com.ezen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.domain.Criterial;
import com.ezen.domain.RatingsPageDTO;
import com.ezen.domain.RatingsVO;
import com.ezen.service.RatingsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequiredArgsConstructor
@RequestMapping(value = "/ratings")
public class RatingsController {
	
	private final RatingsService ratingsService;
	
//	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String> create(@RequestBody RatingsVO vo) {
		log.info("RatingsVO >> " + vo);
		
		int insertCount = ratingsService.register(vo);
		return insertCount == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value ="/pages/{isbn}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<RatingsPageDTO> getList(@PathVariable("isbn") String isbn, 
													@PathVariable("page") int page){
		
		log.info("getList.........isbn >> " + isbn + "  page >> " + page);
		Criterial cri = new Criterial(page, 10);
		return new ResponseEntity<RatingsPageDTO>(ratingsService.getListPage(cri, isbn), HttpStatus.OK);
	}
	
	@GetMapping(value ="/{ratingsid}", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<RatingsVO> get(@PathVariable("ratingsid") String ratingsid){
		
		log.info("get >>> " + ratingsid);
		return new ResponseEntity<RatingsVO>(ratingsService.get(ratingsid), HttpStatus.OK);
	}
	
//	@PreAuthorize("principal.username == #vo.memberid")
	@DeleteMapping(value = "/{ratingsid}")
	public ResponseEntity<String> remove(@PathVariable("ratingsid") String ratingsid, @RequestBody RatingsVO vo){
		log.info("delete >>> " + ratingsid);
		
		return ratingsService.remove(ratingsid) == 1 ? 
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@PreAuthorize("principal.username == #vo.memberid")
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
				value = "/{ratingsid}", consumes = "application/json")
	public ResponseEntity<String> modify(@RequestBody RatingsVO vo, @PathVariable("ratingsid") String ratingsid){
		
		log.info("modify >> " + ratingsid);
		log.info("RatingsVO >> " + vo);
		
		vo.setRatingsid(ratingsid);
		return ratingsService.modify(vo) == 1 ?
				new ResponseEntity<String>("success", HttpStatus.OK):
				new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
