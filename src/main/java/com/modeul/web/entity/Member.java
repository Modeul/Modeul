package com.modeul.web.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private Long id;
	private String uid;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String nickname;
	private Date regDate;
	private LocalDateTime level;
	
	public Member(String uid, String pwd, String name, String email, String nickname) {
		this.uid = uid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
	}
	
	
}
