package com.ezen.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.domain.BoardVO;
import com.ezen.domain.Criteria;
import com.ezen.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper mapper;
	

	//공지사항 등록
	public boolean listRegister(BoardVO vo) {
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        vo.setCreatedate(currentDate);
    	
		return mapper.listRegister(vo);
	}	
		
	//페이징
	public List<BoardVO> getListWithPaging(Criteria cri){
	
		return mapper.getListWithPaging(cri);
	}
	
	//총 게시글 수
	public int getTotalCount() {
		return mapper.getTotalCount();
	}
	//게시글조회
	public BoardVO get(int boardid) {
		return mapper.get(boardid);
	}
	
}
