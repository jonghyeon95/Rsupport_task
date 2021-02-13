package com.cos.notice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.notice.model.Member;
import com.cos.notice.repository.MemberRepsitory;

@Service
public class MemberService {

	@Autowired
	private MemberRepsitory memberRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(Member member) {

		if (false == validationCheck(member)) {
			throw new IllegalStateException("회원 가입 실패: 빈 값이 있습니다.");			
		}
		String rawPassword = member.getMember_pw();
		String encPassword = encoder.encode(rawPassword);
		member.setMember_pw(encPassword);
		memberRepository.save(member);
	}
	
	@Transactional
	public void 회원수정(Member member) {

		Member persistance = memberRepository.findById(member.getMember_id()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 수정 실패: 해당회원을 찾을 수 없습니다.");
		});
		
		if(false == validationCheck(member)) {
			throw new IllegalStateException("회원 수정 실패: 빈 값이 있습니다.");
		}

		String rawPassword = member.getMember_pw(); 
		String encPassword = encoder.encode(rawPassword); 
		persistance.setMember_pw(encPassword);
		persistance.setMember_email(member.getMember_email());
		persistance.setMember_name(member.getMember_name());
	}
	
	private boolean validationCheck(Member member)
	{
		if (member.getMember_email().length() == 0 || member.getMember_id().length() == 0 || member.getMember_pw().length() == 0
				|| member.getMember_name().length() == 0) {
			return false;
		}
		
		return true;
	}
	
}
