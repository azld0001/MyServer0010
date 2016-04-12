package com.azld.resource.service;

import java.util.List;

import com.azld.resource.model.Book;

public interface BookService {

	public Book GetBookWithID(int id);
	public List<Book> loadBooks();
	public boolean AddBook(Book book);
	public boolean isExistBookWithName(String name);
	
}
