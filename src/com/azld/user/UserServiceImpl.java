package com.azld.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	private UserDao userdao;
	
	public UserDao getUserdao() {
		return userdao;
	}

	@Resource
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public String add(User auser) 
	{
		return this.userdao.add(auser);
	}

	@Override
	public String delete(User auser)
	{
		return this.userdao.delete(auser);
	}

	@Override
	public User load(int id) 
	{
		return this.userdao.load(id);
	}

	@Override
	public boolean IsexistUser(String name)
	{
		return this.userdao.IsexistUser(name);
	}

	@Override
	public List<User> list() 
	{
		return this.userdao.list();
	}

	@Override
	public User login(User auser) 
	{
		return this.userdao.login(auser);
	}

	@Override
	public void edit(User auser) 
	{
		this.userdao.edit(auser);
	}
}
