package com.ezen.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.Criterial;
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

		rentalListMapper.getList().forEach(rental -> log.info(rental));

	}

	@Test
	public void testInsert() {

		RentalListVO vo = RentalListVO
				.builder()
				.rentdate("2023-01-01") // 유효한 날짜 값으로 변경
				.plannedreturndate("2023-01-10") // 유효한 날짜 값으로 변경
				.isbn("9788934967477")
				.memberid("admin1")
				.subscrlistid("1a5aecc0-8ff5-11ee-b089-309c238259e1")
				.actualreturndate("2023-01-15") // 유효한 날짜 값으로 변경
				.deliverydate("2023-01-12") // 유효한 날짜 값으로 변경
				.deliveryinvno("test10").build();

		rentalListMapper.insert(vo);

	}

	@Test
	public void testRead() {
		String uuidAsString = "0df70858-901f-11ee-b089-309c238259e1";
		RentalListVO vo = rentalListMapper.read(uuidAsString);
		log.info("vo >>>>>>>>>>>>>>>>" + vo);
	}

	@Test
	public void testDelete() {
		String uuidAsString = "5d147664-8ff5-11ee-b089-309c238259e1";
		rentalListMapper.delete(uuidAsString);
	}

	@Test
	public void testUpdate() {
		String uuidAsString = "e88e73b0-8ffb-11ee-b089-309c238259e1";
		RentalListVO vo = RentalListVO
				.builder()
				.rentallistid(uuidAsString)
				.rentdate("2023-11-11") // 유효한 날짜 값으로 변경
				.plannedreturndate("2023-11-11") // 유효한 날짜 값으로 변경
				.isbn("9772384367000")
				.memberid("admin1")
				.subscrlistid("1a5aecc0-8ff5-11ee-b089-309c238259e1")
				.actualreturndate("2023-01-15") // 유효한 날짜 값으로 변경
				.deliverydate("2023-01-12") // 유효한 날짜 값으로 변경
				.deliveryinvno("update").build();

		int result = rentalListMapper.update(vo);
		log.info("result >> " + result);

	}
	
	
    @Test
    public void testCheckBook() {
        int result = rentalListMapper.checkBook("9772384367000");
        assertEquals(1, result);
//      assertEquals(0, result);
    }
    
    @Test
    public void testcheckSub() {
        int result = rentalListMapper.checkSub("admin1");
        assertEquals(1, result);
//      assertEquals(0, result);
    }
    
    @Test
    public void testgetTotal() {
    	Criterial criterial = new Criterial();
    	int total = rentalListMapper.getTotal(criterial);
    	int expectedTotal = 1;
        assertEquals(expectedTotal, total);
    }

}
