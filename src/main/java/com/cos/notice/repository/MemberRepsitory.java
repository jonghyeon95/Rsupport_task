package com.cos.notice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.notice.model.Member;

public interface MemberRepsitory extends JpaRepository<Member, String>{

}
