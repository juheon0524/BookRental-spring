package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private final BoardMapper boardMapper;
	
	
	@Override
	public List<BoardVO> getList() {
		log.info("getlist ...........>>" );
		return boardMapper.getList();
	}

	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	} //?????????

	@Override
	public void register(BoardVO board) {
		log.info("register...........>>" + board);
		boardMapper.insertSelectKey(board);
		
	}

	@Override
	public boolean modify(BoardVO board) {
		
		return boardMapper.update(board) == 1 ? true : false;
		
	}

	@Override
	public boolean remove(Long bno) {
	
		return boardMapper.delete(bno) == 1 ? true : false;
	}

}