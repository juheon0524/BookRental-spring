package com.ezen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.Criterial;
import com.ezen.domain.RentalListVO;
import com.ezen.mapper.RentalListMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RentalListServiceImplTest {

	@Autowired
	private RentalListService rentalListService;
	
	@Autowired
	private RentalListMapper rentalListMapper;
	
	@Test
	public void testGetList() {
		rentalListService.getList(new Criterial())
			.forEach(rent->log.info(rent));
	}
	
	@Test
	public void testRegister() {
		RentalListVO vo = RentalListVO
				.builder()
				.rentdate("2023-03-03")
				.plannedreturndate("2023-03-03")
				.isbn("9772384367000")
				.memberid("admin1")
				.subscrlistid("1a5aecc0-8ff5-11ee-b089-309c238259e1")
				.actualreturndate("2023-03-03")
				.deliverydate("2023-03-03")
				.deliveryinvno("servicetest3")
				.build();
		rentalListService.register(vo);
	}
	
	@Test
	public void testModify() {
		RentalListVO vo = RentalListVO
				.builder()
				.rentallistid("350f505f-901f-11ee-b089-309c238259e1")
				.rentdate("2023-04-04")
				.plannedreturndate("2023-04-04")
				.isbn("9772384367000")
				.memberid("admin1")
				.subscrlistid("1a5aecc0-8ff5-11ee-b089-309c238259e1")
				.actualreturndate("2023-04-04")
				.deliverydate("2023-04-04")
				.deliveryinvno("servicetest3수정")
				.build();
		rentalListService.modify(vo);
	}
	
	@Test
	public void testDelete() {
		boolean result = rentalListService.remove("350f505f-901f-11ee-b089-309c238259e1");
		log.info("result >> " + result);
	}
	
	@Test
	public void testCheckBook() {
		boolean result = rentalListService.checkBook("9772384367000");
		log.info("result >> " + result);
	}
	
	@Test
	public void testCheckSub() {
		boolean result = rentalListService.checkSub("admin2");
		log.info("result >> " + result);
	}
	
	
    @Test
    public void testGetTotal() {
        Criterial cri = new Criterial(); 

        int total = rentalListService.getTotal(cri);

        assertEquals(total, total);
        log.info("total >> " + total);
    }

    @Test
    public void testRead() {
        String rentallistid = "21d582b0-901f-11ee-b089-309c238259e1";

        RentalListVO rentalListVO = rentalListService.read(rentallistid);

        assertNotNull(rentalListVO);
        log.info("rentalListVO >> " + rentalListVO);
    }

}
