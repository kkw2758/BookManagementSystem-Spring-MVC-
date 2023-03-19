package com.mysite.bookManagementSystem.main;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.bookManagementSystem.book.Book;
import com.mysite.bookManagementSystem.book.BookService;

import lombok.RequiredArgsConstructor;

// 생성자 의존성 주입
@RequiredArgsConstructor
@Controller
public class MainController {
	private final BookService bookService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Book> bookList = this.bookService.getList();
		model.addAttribute("bookList", bookList);
		return "main_page";
	}
}
