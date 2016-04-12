package com.azld.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.azld.resource.model.Book;
import com.azld.resource.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.media.jai.opimage.AddCollectionCRIF;

@Component("bookaction")
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book> 
{
	private Book book = new Book();
	private BookService bookservice;
	
	
	@Override
	public String execute() throws Exception 
	{
		System.out.println(book.getName());
		Book abook = new Book();
		abook.setName(book.getName());
		
		if (bookservice.isExistBookWithName(abook.getName())) 
		{
			return "fail";
		}
		bookservice.AddBook(abook);
		return "success";
	}
	
	public String add()
	{
		System.out.println("bookaction method add");
		return "success";
	}
	
	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return book;
	}

	public BookService getBookservice() {
		return bookservice;
	}

	@Resource
	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

	
	
}
