
package com.modeul.web.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stuff {
	private int id;
	private String title;
	private String place;
	private Date regDate;
	private int numPeople;
	private String url;
	private LocalDateTime deadline;
	private String price;
	private String content;
	private int memberId;
	private long catecoryId;
}