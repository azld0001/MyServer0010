package com.azld.resource.dao;

import java.util.List;

import com.azld.resource.model.Book;

public interface BookDao {
	public void add(Book abook);
	public boolean isexistBookWithName(String sname);
	public Book GetBookWithID(int bid);
	public List<Book> GetBooks();
}
