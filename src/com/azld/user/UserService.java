package com.azld.user;

import java.util.List;

public interface UserService
{
	public String add(User auser);
	public String delete(User auser);
	public User load(int id);
	public boolean IsexistUser(String name);
	public List<User> list();
	public User login(User auser);
	public void edit(User auser);
	
}
