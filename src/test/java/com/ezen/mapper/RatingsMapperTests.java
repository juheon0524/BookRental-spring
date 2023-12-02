package com.ezen.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.Criterial;
import com.ezen.domain.RatingsVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RatingsMapperTests {

	@Autowired
	private RatingsMapper ratingsmapper;
	
	@Test
	public void testInsert() {
		RatingsVO ratings = RatingsVO.builder()
				.isbn("9791192300818")
				.memberid("user3")
				.writedate("2023-11-27")
				.content("읽어 보니 너무 유익한 책입니다.3")
				.score(3)
				.build();
		ratingsmapper.insertRatings(ratings);
		log.info("RatingsVO >> " + ratings);
	}
	
	@Test
	public void testRead() {
		RatingsVO ratings = ratingsmapper.read("39f82305-8e81-11ee-a01b-88a4c2a59dba");
		log.info("Read ratings >> " + ratings);
	}
	
	@Test
	public void testUpdate() {
		RatingsVO ratings = ratingsmapper.read("39f82305-8e81-11ee-a01b-88a4c2a59dba");
		ratings.setContent("100자평 수정입니다.");
		ratings.setScore(4);
		int result = ratingsmapper.updateRatings(ratings);
		log.info("RatingsVO >> " + result + " >> " + ratings);
	}
	
	@Test
	public void testDelete() {
		int result = ratingsmapper.deleteRatings("39f82305-8e81-11ee-a01b-88a4c2a59dba");
		log.info("Delete result >> " + result);
	}
	
	@Test
	public void testGetListWithPaging() {
		
//		Criterial cri = new Criterial();
//		cri.setPageNum(1);
//		cri.setAmount(4);
		String isbn = "9791163143376";
		
		List<RatingsVO> list = ratingsmapper.getListWithPaging(new Criterial(1,4), isbn);
		list.forEach(ratings -> log.info(ratings));
	}
	
	@Test
	public void testGetCount() {
		int result = ratingsmapper.getCountByIsbn("9791164136452");
		log.info("getCount result >> " + result);
	}

}