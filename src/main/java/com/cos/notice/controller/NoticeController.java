package com.cos.notice.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cos.notice.model.Notice;
import com.cos.notice.service.NoticeService;


@RestController
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping({"/",""})
	public Page<Notice> index(Model model, @PageableDefault(sort="notice_id" ,size = 5) Pageable pageable) {	
//		Page<Notice> usersPage = new PageImpl(noticeService.글목록1(), pageable, 6); 
//		return usersPage;
		return noticeService.글목록(pageable);
	}
	
//	@GetMapping({"/",""})
//	public String index(Model model, @PageableDefault(direction = Direction.DESC , size = 3) Pageable pageable) {	
//		model.addAttribute("notices", noticeService.글목록(pageable));
//		return "index";
//	}
	
	@GetMapping("notice/saveForm")
	public String saveForm() {
		return "notice/saveForm";
	}

	
	@GetMapping("notice/{id}")
	public String findById(@PathVariable int id, Model model)
	{
		Notice notice = noticeService.글상세보기(id);
		model.addAttribute("notice", notice);
		
		return "notice/detailForm";
	}
	
	@GetMapping("notice/{id}/updateForm")
	public String UpdateForm(@PathVariable int id, Model model)
	{
		Notice notice = noticeService.글상세보기(id);
		model.addAttribute("notice", notice);
		return "notice/updateForm";
	}
	
}


