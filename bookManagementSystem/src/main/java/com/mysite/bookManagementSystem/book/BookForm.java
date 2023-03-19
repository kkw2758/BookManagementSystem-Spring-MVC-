package com.mysite.bookManagementSystem.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {
	@NotEmpty(message="제목은 필수항목입니다.")
	@Size(max=200)
	private String title;
	
	@NotEmpty(message="카테고리는 필수항목입니다.")
	@Size(max=200)
	private String category;
	
	@NotEmpty(message="국가는 필수항목입니다.")
	@Size(max=50)
	private String nation;
	
	@NotEmpty(message="장르는 필수항목입니다.")
	@Size(max=50)
	private String genre;
	
	private Integer price;
}

