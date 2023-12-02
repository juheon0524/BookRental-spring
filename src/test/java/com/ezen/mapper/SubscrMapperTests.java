package com.ezen.mapper;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.Criterial;
import com.ezen.domain.SubscrVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SubscrMapperTests {
	
	@Autowired
	private SubscrMapper subscrmapper;

	@Test
	public void testGetTotalCount() {
		int result = subscrmapper.getTotalCount();
		log.info("getTotalCount >> " + result);
	}
	
	@Test
	public void testGetListWithPaging() {
		subscrmapper.getListWithPaging(new Criterial(2,10)).forEach(list -> log.info(list));
	}

	@Test
	public void testRead() {
		log.info(subscrmapper.read("8cad0222-8e92-11ee-a01b-88a4c2a59dba"));
	}
	
	@Test
	public void testInsert() {
		SubscrVO subscr = SubscrVO.builder()
				.subscrname("6개월 구독권 - 기부자")
				.price(500)
				.salefromdate("2023-12-01")
				.saletodate("9999-12-31")
				.subscrperiod(180)
				.memberid("admin2")
				.registereddate("2023-11-29")
				.allowedbookcnt(25)
				.purpose("A")
				.build();
		subscrmapper.insertSubscr(subscr);
		log.info("Subscr insert >> " + subscr);
	}
	
	@Test
	public void testUpdate() {
		SubscrVO subscr = SubscrVO.builder()
				.subscrid("437eb67c-8e9e-11ee-a01b-88a4c2a59dba")
				.subscrname("6개월 구독권 - 기부자")
				.price(100)
				.salefromdate("2023-12-01")
				.saletodate("9999-12-31")
				.subscrperiod(180)
				.memberid("admin2")
				.registereddate("2023-11-29")
				.allowedbookcnt(35)
				.purpose("A")
				.build();
		subscrmapper.updateSubscr(subscr);
		log.info("Subscr update >> " + subscr);
	}
	
	@Test
	public void testDelete() {
		int result = subscrmapper.deleteSubscr("437eb67c-8e9e-11ee-a01b-88a4c2a59dba");
		log.info("Delete result >> " + result);
	}
}
