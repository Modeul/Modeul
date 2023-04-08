package com.modeul.web.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StuffView {
	private int id;
	private String title;
	private String place;
	private LocalDateTime regDate;
	private int numPeople;
	private String url;
	private LocalDateTime deadline;
	private String price;
	private String content;
	private int memberId;
	private int categoryId;
	private String categoryName;
}
