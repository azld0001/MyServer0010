package com.azld.user;

import java.util.List;

public interface UserDao {

	public String add(User auser);
	public String delete(User auser);
	public User load(int id);
	public User login(User auser);
	public boolean IsexistUser(String name);
	public List<User> list();
	public void edit(User auser);
	
}
