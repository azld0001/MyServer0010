package com.azld.user;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="user")
public class User 
{
	private int id;
	private String name;
	private String password;
	private String title;
	private String loginkey; 
	
	public User()
	{
		;
	}
	public User(User u)
	{
		this.setId(u.getId());
		this.setName(u.getName());
		this.setPassword(u.getPassword());
		this.setTitle(u.getTitle());
		this.setLoginkey(u.getLoginkey());
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoginkey() {
		return loginkey;
	}
	public void setLoginkey(String loginkey) {
		this.loginkey = loginkey;
	}
	
	public void updateloginkey()
	{
		UUID uuid = UUID.randomUUID();
		this.setLoginkey(uuid.toString());
	}
	
	
	
	
}
