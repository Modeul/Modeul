package com.modeul.web.entity;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StuffVO {
	private MultipartFile[] fileList;
	private String title;
	private String place;
	private int numPeople;
	private String url;
	private LocalDateTime deadline;
	private String price;
	private String content;
	private int categoryId;
}
