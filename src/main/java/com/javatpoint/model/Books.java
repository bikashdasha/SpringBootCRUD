package com.javatpoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Books {
//Defining book id as primary key
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int bookid;

	@Column
	@NotBlank(message = "Book name is required")
	private String bookname;

	@Column
	@NotBlank(message = "Author is required")
	private String author;

	@Column
	@Positive(message = "Price must be positive")
	private int price;

	// ✅ newly added field
	@Column
	private int year;

	// ✅ newly added field
	@Column
	@NotBlank(message = "Category is required")
	private String category;

	// getters and setters

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}