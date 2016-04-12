package com.azld.user;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao
{
	@Resource
	private HibernateTemplate hibernate; 
//	private HibernateTemplate hibernate;
	
//	public HibernateTemplate getHibernate() {
//		return hibernate;
//	}
//
//	@Resource
//	public void setHibernate(HibernateTemplate hibernate) {
//		this.hibernate = hibernate;
//	}

	@Override
	public String add(User auser) 
	{
		System.out.println("name:"+auser.getName());
		System.out.println("password:"+auser.getPassword());
		this.hibernate.save(auser);
		return "success";
	}

	@Override
	public String delete(User auser)
	{
		this.hibernate.delete(auser);
		return "success";
	}

	@Override
	public User load(int id)
	{
		return (User)this.hibernate.find("from user where id ="+id);
	}

	@Override
	public boolean IsexistUser(String name)
	{
		List<User> list = (List<User>)this.hibernate.find("from user where name='"+name+"'");
		if (list != null)
		{
			if (list.size() > 0) 
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> list() 
	{
		List<User> list = (List<User>)this.hibernate.find("from user");
		return null;
	}

	@Override
	public User login(User auser) 
	{
		List<User> list = (List<User>)this.hibernate.find("from user where name='"+auser.getName()+"' and password='"+auser.getPassword()+"'" );
		if (list != null)
		{
			if (list.size()!=1)
			{
				return null;
			}
			else
			{
				User user = list.get(0);
				return user;
			}
		}
		return null;
	}

	@Override
	public void edit(User auser)
	{
		this.hibernate.update(auser);
	}
	
}
