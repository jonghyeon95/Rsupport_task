package com.cos.notice.service;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.notice.config.auth.PrincipalDetail;
import com.cos.notice.model.Member;
import com.cos.notice.model.Notice;
import com.cos.notice.repository.NoticeRepository;

//스프링이 컴포넌트 스캔을 통해 Bean에 등록해줌. IoC를 해줌
@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Transactional
	public void 글쓰기(Notice notice, Member member) {
		
		if(false == validationCheck(notice))
		{
			throw new IllegalStateException("글 등록 실패: 빈 값이 있습니다.");
		}
		
		notice.setMember(member);
		noticeRepository.save(notice);
	}
	
	@Transactional(readOnly=true)
	public Page<Notice> 글목록(Pageable pageable){
		return noticeRepository.findAll(pageable);
	}
	
	@Transactional(readOnly=true)
	public List<Notice> 글목록1(){
		return noticeRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Notice 글상세보기(int id) {
		return noticeRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기 실패: ID를 찾을 수 없습니다.");
		});
	}
	
	@Transactional
	public void 글삭제하기(int id, PrincipalDetail principal) {
				Notice notice = noticeRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 삭제 실패: 해당글을 찾을 수 없습니다.");
		});
				
		if(!notice.getMember().getId().equals(principal.getUsername()))
		{
			throw new IllegalStateException("글 삭제 실패: 삭제 권한이 없습니다.");
		}

		noticeRepository.deleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, Notice requsetNotice, PrincipalDetail principal) {
		
		if(false == validationCheck(requsetNotice))
		{
			throw new IllegalStateException("글 수정 실패: 빈 값이 있습니다.");
		}
		
		Notice notice = noticeRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 수정 실패: 해당글을 찾을 수 없습니다.");
		});
		
		if(!notice.getMember().getId().equals(principal.getUsername()))
		{
			throw new IllegalStateException("글 수정 실패: 수정 권한이 없습니다.");
		}
		
		notice.setTitle(requsetNotice.getTitle());
		notice.setContent(requsetNotice.getContent());
		notice.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
	}
	
	private boolean validationCheck(Notice notice)
	{
		if (notice.getContent().length() == 0 ||  notice.getTitle().length() == 0)
			return false;
		
		return true;
	}
}
