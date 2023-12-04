package com.ezen.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" ,
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class RentalListControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
    @Test
    public void testList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rental/rentList")
                .param("pageNum", "1")
                .param("amount", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("rental/rentList"));
     // 리스트 페이지를 불러오는 테스트
    }

    @Test
    public void testRegisterForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rental/rentRegister"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("rental/rentRegister"));
     // 등록 폼을 불러오는 테스트
    }

    @Test
    public void testRegister() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/rental/rentRegister")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("rentalProperty1", "value1")  // 필요한 파라미터를 추가
                .param("rentalProperty2", "value2"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rental/rentList"));
        // 렌탈 등록을 테스트
    }
    
    @Test
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rental/rentGet")
                .param("rentallistid", "123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("rental/rentGet"));
        // 렌탈 상세 정보 페이지를 불러오는 테스트
    }

    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/rental/rentRemove")
                .param("rentallistid", "123"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rental/rentList?pageNum=1&amount=10"));
        // 렌탈 삭제를 테스트
    }

    @Test
    public void testModify() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/rental/rentModify")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("rentallistid", "123")
                .param("rentalProperty1", "modifiedValue1")  // 수정할 파라미터를 추가
                .param("rentalProperty2", "modifiedValue2"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rental/rentList?pageNum=1&amount=10"));
        // 렌탈 수정을 테스트
    }

	

}
