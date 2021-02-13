package com.cos.notice.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {

	@Id	//PK
	@Column(length = 30)
	private String id;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)	
	@JsonIgnoreProperties({"member"})
	@OrderBy("num desc")
	private List<Notice> notices;		
}
