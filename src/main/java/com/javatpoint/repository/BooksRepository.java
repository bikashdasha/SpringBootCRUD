package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Books;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BooksRepository extends PagingAndSortingRepository<Books, Integer>
{
    List<Books> findByBookname(String bookname);
    List<Books> findByAuthorContainingIgnoreCase(String author);
    long countByAuthorIgnoreCase(String author);
    List<Books> findByYearGreaterThan(int year);
    List<Books> findByCategory(String category);
}
