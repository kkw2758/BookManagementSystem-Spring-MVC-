package com.mysite.bookManagementSystem.book;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String title;
	
	@Column(length = 200)
	private String category;
	
	@Column(length = 50)
	private String nation;
	
	@Column(length = 50)
	private String genre;
	
	private Integer price;
	
	private LocalDateTime insertDate;
}
