package com.azld.resource.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.azld.resource.dao.BookDao;
import com.azld.resource.model.Book;

@Component("bookDao")
public class BookDaoImpl implements BookDao {

	private HibernateTemplate hibernateTemplate; 
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(Book aBook) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(aBook);
	}

	@Override
	public boolean isexistBookWithName(String sname)
	{
		List<Book> listbooks = this.hibernateTemplate.find("from book where name='" +sname+ "'" );
		if (listbooks != null) 
		{
			if (listbooks.size() > 0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Book GetBookWithID(int bid)
	{
		Book abook = (Book)this.hibernateTemplate.load(Book.class, bid);
		return abook;
	}

	@Override
	public List<Book> GetBooks() 
	{
		// TODO Auto-generated method stub
		List<Book> listbooks = this.hibernateTemplate.find("from book");
		return listbooks;
	}

}
