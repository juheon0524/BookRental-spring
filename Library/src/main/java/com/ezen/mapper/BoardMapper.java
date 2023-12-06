package com.ezen.mapper;

import java.util.List;

import com.ezen.domain.Criteria;
import com.ezen.domain.BoardVO;



public interface BoardMapper {

	//페이징
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//공지사항등록
	public boolean listRegister(BoardVO vo);
	
	//총게시글
	public int getTotalCount();
	
	//게시글조회
	public BoardVO get(int boardid);
}
