package com.ezen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.domain.BookVO;
import com.ezen.domain.Criterial;
import com.ezen.mapper.BookMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;
	
	@Override
	public List<BookVO> getListWithPaging(Criterial cri) {
		log.info("getListWithPaging  >> " + cri );
		return bookMapper.getListWithPaging(cri);
	}
	
	@Override
	public List<BookVO> getListWithPagingByPdate(Criterial cri) {
		log.info("getListWithPagingByPdate  >> " + cri );
		return bookMapper.getListWithPagingByPdate(cri);
	}
	
	@Override
	public List<BookVO> getListWithPagingByRentalCnt(Criterial cri) {
		log.info("getListWithPagingByRentalCnt  >> " + cri );
		return bookMapper.getListWithPagingByRentalCnt(cri);
	}

	@Override
	public BookVO get(String isbn) {
		log.info("getBookVO >> " + isbn);
		return bookMapper.read(isbn);
	}

	@Override
	public void register(BookVO book) {
		log.info("register Book >> " + book);
		bookMapper.insertBook(book);
	}

	@Override
	public boolean modify(BookVO book) {
		log.info("modify Book >> " + book);
		return bookMapper.updateBook(book) == 1 ? true : false;
	}

	@Override
	public boolean remove(String isbn) {
		log.info("delete Book >> " + isbn);
		return bookMapper.delete(isbn) == 1 ? true :false;
	}

	@Override
	public int getTotalBookCount(Criterial cri) {
		log.info("Get total bookCount >> " );
		return bookMapper.getTotalBookCount(cri);
	}

}
