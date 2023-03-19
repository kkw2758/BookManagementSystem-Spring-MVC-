package com.mysite.bookManagementSystem.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/book")
@RequiredArgsConstructor
@Controller
public class BookController {

	private final BookService bookService;

	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Book book = this.bookService.getBook(id);
		model.addAttribute("book", book);
		return "book_detail";
	}

	@GetMapping("/modify/{id}")
	public String bookModify(BookForm bookForm, @PathVariable("id") Integer id) {
		Book book = this.bookService.getBook(id);
		bookForm.setTitle(book.getTitle());
		bookForm.setCategory(book.getCategory());
		bookForm.setNation(book.getNation());
		bookForm.setGenre(book.getGenre());
		bookForm.setPrice(book.getPrice());
		return "book_form";
	}
	
	@PostMapping("/modify/{id}")
	public String bookModify(@Valid BookForm bookForm, @PathVariable("id") Integer id, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "book_form";
		}
		Book book = bookService.getBook(id);
		bookService.modify(book, bookForm.getTitle(), bookForm.getCategory(), bookForm.getNation(), bookForm.getGenre(),
				bookForm.getPrice());
		return String.format("redirect:/book/detail/%s", id);
		}
	
	@GetMapping("/create")
	public String bookCreate(BookForm bookForm) {
		return "book_form";
	}

	@PostMapping("/create")
	public String bookCreate(@Valid BookForm bookForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "book_form";
		}
		this.bookService.create(bookForm.getTitle(), bookForm.getCategory(), bookForm.getNation(), bookForm.getGenre(),
				bookForm.getPrice());
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String answerDelete(@PathVariable("id") Integer id) {
		Book book= this.bookService.getBook(id);
		this.bookService.delete(book);
		return "redirect:/";
	}
}
