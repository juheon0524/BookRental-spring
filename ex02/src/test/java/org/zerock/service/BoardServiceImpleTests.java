package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImpleTests {
	
	@Autowired
	private BoardService boardService;  
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
				.title("���� �ۼ��ϴ±�")
				.content("���� �ۼ��ϴ³���")
				.writer("newbie")
				.build();
		
		boardService.register(board);
	}
	
	@Test
	public void testGetList() {
		boardService.getList()
			.forEach(board -> log.info(board));
	}
	
	@Test
	public void testGetByBno() {
		boardService.get(1L);
	}
	
	@Test
	public void testmodify() {
		BoardVO board = BoardVO.builder()
				.title("�ﱹ��")
				.content("����")
				.writer("���ڷ�")
				.bno(15L)
				.build();
		
		boolean result = boardService.modify(board);
		log.info(result);
	}
	
	@Test
	public void removetest() {
		
		boolean result = boardService.remove(15L);
		log.info(result);
	}
}