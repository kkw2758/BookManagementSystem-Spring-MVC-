package com.mysite.bookManagementSystem.main;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("keyword", "Home");
		return "page/main_page";
	}

	@GetMapping(value = "/list")
	public String detail(Model model, @RequestParam("nation") String nation, @RequestParam("genre") String genre) {
		List<Book> bookList = this.bookService.getBookByNationAndGenre(nation, genre);
		model.addAttribute("bookList", bookList);
		model.addAttribute("keyword", nation + "/" + genre);
		System.out.println( nation + "/" + genre);
//		System.out.println(bookList.get(0).getTitle());
		return "page/main_page";
	}
}
