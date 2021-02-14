package com.cos.notice.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.notice.config.auth.PrincipalDetail;
import com.cos.notice.dto.ResponseDto;
import com.cos.notice.model.Notice;
import com.cos.notice.service.NoticeService;

@RestController
public class NoticeApiController {
	
	@Autowired
	private NoticeService noticeService;	

	@PostMapping("/api/notice")
	public ResponseDto<Integer> save(@RequestBody Notice notice, @AuthenticationPrincipal PrincipalDetail principal)
	{
		noticeService.글등록(notice, principal.getMember());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/api/notice/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id, @AuthenticationPrincipal PrincipalDetail principal)
	{
		noticeService.글삭제하기(id, principal);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/api/notice/{id}")
	public ResponseDto<Integer> undate(@PathVariable int id, @RequestBody Notice notice, @AuthenticationPrincipal PrincipalDetail principal)
	{
		noticeService.글수정하기(id, notice, principal);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}

