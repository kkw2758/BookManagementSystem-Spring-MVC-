package com.mysite.bookManagementSystem;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.bookManagementSystem.book.Book;
import com.mysite.bookManagementSystem.book.BookRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class BookManagementSystemApplicationTests {
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	@Test
	void testJpa() {
		Book book1 = new Book();
		book1.setTitle("Test Title1");
		book1.setCategory("Test Category1");
		book1.setNation("Test Nation1");
		book1.setGenre("Test Genre1");
		book1.setPrice(0);
		book1.setInsertDate(LocalDateTime.now());
		this.bookRepository.save(book1);
		
		Book book2 = new Book();
		book2.setTitle("Test Title2");
		book2.setCategory("Test Category2");
		book2.setNation("Test Nation2");
		book2.setGenre("Test Genre2");
		book2.setPrice(0);
		book2.setInsertDate(LocalDateTime.now());
		this.bookRepository.save(book2);
	}

}
