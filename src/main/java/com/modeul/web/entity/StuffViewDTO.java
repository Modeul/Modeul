package com.modeul.web.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StuffViewDTO extends StuffDTO {
	private String categoryName;

	public StuffViewDTO(String title, String place, int numPeople, String url, LocalDateTime deadline, String price,
			String content, int categoryId, String categoryName) {
		super(title, place, numPeople, url, deadline, price, content, categoryId);
		this.categoryName = categoryName;
	}
	
}
