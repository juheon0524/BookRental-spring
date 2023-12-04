package com.ezen.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.domain.Criterial;
import com.ezen.domain.PageDTO;
import com.ezen.domain.RentalListVO;
import com.ezen.service.RentalListService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/rental/*")
@Log4j
@RequiredArgsConstructor
public class RentalListController {

	private final RentalListService rentalListService;
	
	@GetMapping("/rentList")
    public void list(Criterial cri, Model model) {
        log.info("Rental List >> " + cri);

        model.addAttribute("list", rentalListService.getList(cri));
        model.addAttribute("pageMaker", new PageDTO(cri, rentalListService.getTotal(cri)));
    }

    @GetMapping("/rentRegister")
    @PreAuthorize("isAuthenticated()")
    public void register() {
    }

    @PostMapping("/rentRegister")
    @PreAuthorize("isAuthenticated()")
    public String register(RentalListVO rental, RedirectAttributes rttr) {
        log.info("Register Rental: " + rental);

        rentalListService.register(rental);
        rttr.addFlashAttribute("result", rental.getRentallistid());

        return "redirect:/rental/rentList";
    }

    @GetMapping({"/rentGet", "/rentModify"})
    public void get(@RequestParam("rentallistid") String rentallistid, @ModelAttribute("cri") Criterial cri, Model model) {
        log.info("/get or modify");

        model.addAttribute("rental", rentalListService.read(rentallistid));
    }

    @PreAuthorize("principal.username == #rental.memberid")
    @PostMapping("/rentRemove")
    public String remove(String rentallistid, @ModelAttribute("cri") Criterial cri, RedirectAttributes rttr) {
        log.info("Remove Rental: " + rentallistid);

        if (rentalListService.remove(rentallistid)) {
            rttr.addFlashAttribute("result", "success");
        }

        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());

        return "redirect:/rental/rentList";
    }

    @PreAuthorize("principal.username == #rental.memberid")
    @PostMapping("/rentModify")
    public String modify(RentalListVO rental, @ModelAttribute("cri") Criterial cri, RedirectAttributes rttr) {
        log.info("Modify Rental: " + rental);

        if (rentalListService.modify(rental)) {
            rttr.addFlashAttribute("result", "success");
        }

        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());

        return "redirect:/rental/rentList";
    }
}

