package com.cos.notice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.notice.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
//	@Modifying
//	@Query("SELECT * FROM notice ORDER BY notice_num DESC")
//	List<Notice> findByAllDesc();

}
