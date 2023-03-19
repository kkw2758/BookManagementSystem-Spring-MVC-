package com.mysite.bookManagementSystem.book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.bookManagementSystem.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
	private final BookRepository bookRepository;

	public void delete(Book book) {
		this.bookRepository.delete(book);
	}
	public List<Book> getList() {
		return this.bookRepository.findAll();
	}

	public Book getBook(Integer id) {
		Optional<Book> book = this.bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}

	public void create(String title, String category, String nation, String genre, Integer price) {
		Book b = new Book();
		b.setTitle(title);
		b.setCategory(category);
		b.setNation(nation);
		b.setGenre(genre);
		b.setPrice(price);
		b.setInsertDate(LocalDateTime.now());
		this.bookRepository.save(b);
	}

	public void modify(Book book, String title, String category, String nation, String genre, Integer price) {
		book.setTitle(title);
		book.setCategory(category);
		book.setNation(nation);
		book.setGenre(genre);
		book.setPrice(price);
		book.setInsertDate(LocalDateTime.now());
		this.bookRepository.save(book);
	}
}
