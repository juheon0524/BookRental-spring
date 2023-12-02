package com.ezen.mapper;

import java.util.List;

import com.ezen.domain.BookVO;
import com.ezen.domain.Criterial;

public interface BookMapper {
	
	public BookVO read(String isbn);
	public int insertBook(BookVO book);
	public int delete(String isbn);
	public int updateBook(BookVO book);
	
//	public List<BookVO> getList();
	public List<BookVO> getListWithPaging(Criterial cri);
	public List<BookVO> getListWithPagingByPdate(Criterial cri);
	public List<BookVO> getListWithPagingByRentalCnt(Criterial cri);
	
	public int getTotalBookCount(Criterial cri);

}
