package com.azld.resource.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.azld.resource.dao.BookDao;
import com.azld.resource.model.Book;
import com.azld.resource.service.BookService;

@Component("bookService")
public class BookServiceImpl implements BookService 
{	
	private BookDao bookdao;
		
	
	public BookDao getBookdao() {
		return bookdao;
	}
	
	@Resource
	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	@Override
	public Book GetBookWithID(int id) {
		// TODO Auto-generated method stub
		return this.bookdao.GetBookWithID(id);
	}

	@Override
	public List<Book> loadBooks() {
		// TODO Auto-generated method stub
		return this.bookdao.GetBooks();
	}

	@Override
	public boolean AddBook(Book book) {
		// TODO Auto-generated method stub
		this.bookdao.add(book);
		return true;
	}

	@Override
	public boolean isExistBookWithName(String name)
	{
		// TODO Auto-generated method stub
		return this.bookdao.isexistBookWithName(name);
	}

}
