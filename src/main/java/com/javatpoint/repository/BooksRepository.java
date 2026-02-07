package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Books;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books, Integer>
{
    List<Books> findByBookname(String bookname);
    List<Books> findByAuthorContainingIgnoreCase(String author);
}
