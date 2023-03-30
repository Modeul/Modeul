<<<<<<< HEAD
package com.modeul.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuffView extends Stuff {
	private String categoryName;
}
=======
package com.modeul.web.entity;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// 상속해서 Constructor를 만들기 위해서는 부모 Entity에서도 기본 생성자가 필요하다.

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StuffView extends Stuff {
	private Long memberId;
	private long categoryId;
	
	// 카테고리 이름이 필요하네..
	private String categoryName;
}
>>>>>>> branch 'dev2' of https://github.com/Modeul/Modeul.git
