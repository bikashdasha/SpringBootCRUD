package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;

import javax.validation.Valid;

//mark class as Controller
@RestController
public class BooksController {
//autowire the BooksService class
	@Autowired
	BooksService booksService;

//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/book")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}

//creating a delete mapping that deletes a specified book
	@DeleteMapping("/book/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}

//creating post mapping that post the book detail in the database
	@PostMapping("/books")
	private int saveBook(@Valid @RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

//creating put mapping that updates the book detail 
	@PutMapping("/books")
	private Books update(@Valid @RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}
	@GetMapping("/book/search/{name}")
	private List<Books> searchBook(@PathVariable("name") String name){
		return booksService.searchByName(name);
	}

	@GetMapping("/books/search/{author}")
	public List<Books> searchBooks(@PathVariable String author){
		return booksService.searchByAuthor(author);
	}

	@GetMapping("/books/count")
	public long getBookCount() {
		return booksService.getTotalBooks();
	}

	@GetMapping("/books/exists/{id}")
	public boolean checkBookExists(@PathVariable int id) {
		return booksService.isBookExists(id);
	}
	//search by author
	@GetMapping("/books/count/author/{author}")
	public long countBooksByAuthor(@PathVariable String author) {
		return booksService.getBookCountByAuthor(author);
	}
	@GetMapping("/books/after/{year}")
	public List<Books> getBooksAfterYear(@PathVariable int year) {
		return booksService.getBooksAfterYear(year);
	}

	//get books by category
	@GetMapping("/books/category/{category}")
	public List<Books> getBooksByCategory(@PathVariable String category) {
		return booksService.getBooksByCategory(category);
	}

	@GetMapping("/books/pagination")
	public List<Books> getBooksPagination(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {

		Pageable pageable = PageRequest.of(page, size);
		return booksService.getBooksPagination(pageable);
	}

}
