package com.cos.notice.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.notice.dto.ResponseDto;
import com.cos.notice.model.Member;
import com.cos.notice.service.MemberService;

@RestController
public class MemberApiController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private AuthenticationManager authenticationManger;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody Member member) {
		System.out.println("UserApi save 호출 ");
		memberService.회원가입(member);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@PutMapping("/member")
	public ResponseDto<Integer> update(@RequestBody Member member) {
		System.out.println("member:" + member);
		memberService.회원수정(member);

		// 세션등록
		Authentication authentication = authenticationManger
				.authenticate(new UsernamePasswordAuthenticationToken(member.getMember_id(), member.getMember_pw()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
