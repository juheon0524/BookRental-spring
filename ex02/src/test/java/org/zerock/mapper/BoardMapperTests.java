package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

//	@Setter(onMethod_ = @Autowired)
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		 List<BoardVO> list = mapper.getList();
//		 
//		 for(BoardVO vo  : list)
//			 log.info(vo);
		
		mapper.getList().forEach(a ->log.info(a));
		 
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = BoardVO.builder().
				title("�μ�Ʈ3")
				.content("�μ�Ʈ ����")
				.writer("����")
				.build();

		
		mapper.insert(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = BoardVO.builder().
				title("�μ�Ʈ5")
				.content("�μ�Ʈ ����3")
				.writer("���ڷ�")
				.build();

		
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1L);
		log.info("vo >>" + vo);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(12L);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = BoardVO.builder()
				.bno(13L)
				.title("���� ����")
				.content("���� ����")
				.writer("������")
				.build();
		
		int result = mapper.update(vo);
		log.info("result >> " + result);
	}
}