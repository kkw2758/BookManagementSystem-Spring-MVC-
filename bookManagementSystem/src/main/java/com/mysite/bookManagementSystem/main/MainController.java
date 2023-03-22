package com.mysite.bookManagementSystem.main;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.bookManagementSystem.book.Book;
import com.mysite.bookManagementSystem.book.BookService;

import io.micrometer.common.util.StringUtils;
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
	public String getList(Model model, @RequestParam("nation") String nation, @RequestParam("genre") String genre) {
		List<Book> bookList = this.bookService.getBookByNationAndGenre(nation, genre);
		model.addAttribute("bookList", bookList);
		model.addAttribute("keyword", nation + "/" + genre);
		return "page/main_page";
	}

	@ResponseBody
	@PostMapping(value = "/list")
	public List<Book> getFilteredList(@RequestParam(name = "nation", required = false) String nation, @RequestParam(name = "genre", required = false) String genre,
			@RequestParam("option") String option, @RequestParam("keyword") String keyword) {
		System.out.println("nation" + nation);
		System.out.println("genre" + genre);
		
		List<Book> bookList = Collections.emptyList();
		if (nation == null & genre == null) {
			System.out.println("널널널널");
			bookList = this.bookService.getList();
		} else {
			bookList = this.bookService.getBookByNationAndGenre(nation, genre);
		}
		// nation가 genre가 1차로 필터링된 booklist에서 쿼리로 받은 keyword 와 option을 이용해서 2차적으로 조회한

		List<Book> filteredBookList = Collections.emptyList();

		if (option.equals("title")) {
			filteredBookList = bookList.stream().filter(t -> t.getTitle().contains(keyword))
					.collect(Collectors.toList());
		} else if (option.equals("category")) {
			filteredBookList = bookList.stream().filter(t -> t.getCategory().contains(keyword))
					.collect(Collectors.toList());
		}
		return filteredBookList;
	}
}
