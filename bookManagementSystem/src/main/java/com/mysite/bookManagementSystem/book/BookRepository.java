package com.mysite.bookManagementSystem.book;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByNationAndGenre(String nation, String genre, Sort sort);
	List<Book> findByNationLike(String nation);
	List<Book> findByGenreLike(String genre);
}
