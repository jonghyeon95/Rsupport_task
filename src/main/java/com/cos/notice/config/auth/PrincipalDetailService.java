package com.cos.notice.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.notice.model.Member;
import com.cos.notice.repository.MemberRepsitory;

@Service // Bean등록
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	MemberRepsitory memberRepsitory;
	
	@Override
	public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
		Member principal = memberRepsitory.findById(member_id).orElseThrow(() -> {
			return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + member_id);
		});
		return new PrincipalDetail(principal);	//시큐리티 세션에 유저정보 저장
	}

	
	
	
//	@Autowired
//	private MemberRepository userRepository;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User principal = userRepository.findByUsername(username).orElseThrow(() -> {
//			return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
//		});
//		return new PrincipalDetail(principal);	//시큐리티 세션에 유저정보 저장
//	}

}
