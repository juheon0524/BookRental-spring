package com.ezen.service;

import java.util.List;

import com.ezen.domain.BookVO;
import com.ezen.domain.Criterial;

public interface BookService {
	
	public List<BookVO> getListWithPaging(Criterial cri);
	public List<BookVO> getListWithPagingByPdate(Criterial cri);
	public List<BookVO> getListWithPagingByRentalCnt(Criterial cri);
	public BookVO get(String isbn);
	public void register(BookVO book);
	public boolean modify(BookVO book);
	public boolean remove(String isbn);
	public int getTotalBookCount(Criterial cri);

}
