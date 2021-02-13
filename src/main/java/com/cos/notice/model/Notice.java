package com.cos.notice.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
 	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@CreationTimestamp
	private Timestamp updateDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private Member member;
	
}