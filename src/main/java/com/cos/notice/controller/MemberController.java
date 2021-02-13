package com.cos.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/auth/joinForm")
	public String joinForm()
	{
		return "member/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm()
	{
		return "member/loginForm";
	}
	
	@GetMapping("/member/updateForm")
	public String UpdateForm()
	{
		return "member/updateForm";
	}
}


