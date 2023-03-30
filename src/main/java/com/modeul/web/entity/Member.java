package com.modeul.web.entity;

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
	private String nicname;
	private Date regDate;
	private Integer level;
	

}
