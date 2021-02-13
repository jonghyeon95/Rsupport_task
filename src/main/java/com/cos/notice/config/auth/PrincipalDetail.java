package com.cos.notice.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.notice.model.Member;

import lombok.Data;
import lombok.Getter;

//스프링시큐리티가 로그인 요청가로채서 로그인 진행 후 UserDetails 타입의 오브젝트를
//스프링시큐리티의 고유 세션저장소에 저장을 해줌
@Getter
public class PrincipalDetail implements UserDetails{
	
	private Member member;	//콜포지션
	
	public PrincipalDetail(Member member) {
		this.member = member;
	}
	
	@Override
	public String getPassword() {
		return member.getMember_pw();
	}

	@Override
	public String getUsername() {
		return member.getMember_id();
	}

	//계정 만료되지 않았는지 리턴 true:만료안됨
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정 잠겨있는지 리턴	true : 안잠김
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호 만료 리턴 		true : 만료안됨
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정 활성화 되어있는지	true : 계정활성화
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	//계정 권한 리턴 (권한이 여러개 있을 수 있어서 루프돌아야하는데 우리는 한개만)
	

	
}
