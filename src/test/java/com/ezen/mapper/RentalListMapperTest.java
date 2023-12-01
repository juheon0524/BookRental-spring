package com.ezen.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.RentalListVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RentalListMapperTest {

	@Autowired
	private RentalListMapper rentalListMapper;
	
	@Test
	public void testGetList() {
//		 List<RentalListVO> list = rentalListMapper.getList();
//		 for(RentalListVO vo  : list)
//			 log.info(vo);
		
		rentalListMapper.getList().forEach(rental-> log.info(rental));
	
	}

}
