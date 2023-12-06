package com.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.domain.BoardVO;
import com.ezen.domain.Criteria;
import com.ezen.domain.PageDTO;
import com.ezen.service.BoardService;


import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list");
		model.addAttribute("list", service.getListWithPaging(cri));
		int total = service.getTotalCount();
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	@GetMapping({"/get", "/modify"})
	public void get(int boardid, Model model, Criteria cri) {
		log.info("/get or modify");
		model.addAttribute("cri", cri);
		model.addAttribute("board", service.get(boardid));
	}
	
	@GetMapping("/register")
	public String boardWrite() {
	  return "board/register";
	}
	
	@PostMapping("/write")
	public String boardRegister(BoardVO vo, RedirectAttributes rttr) {
		service.listRegister(vo);
		return "redirect:/board/list";
	}
	
}
