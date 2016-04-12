package com.azld.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import sun.org.mozilla.javascript.internal.json.JsonParser;


//import com.javen.tool.JSONUtils;
import com.azld.user.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("useraction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserVo>
{
	/**
	 * 用户接口
	 */
	private static final long serialVersionUID = -5703811458173727295L;
	private UserVo auservo = new UserVo();
	private UserService us;
	private String ret;
	
	
	@Override
	public UserVo getModel() {
		// TODO Auto-generated method stub
		return auservo;
	}

	public String add()
	{
		User user = new User();
		user.setName(auservo.getName());
		user.setPassword(auservo.getPassword());
		
		boolean bisexist = this.us.IsexistUser(user.getName());
		if (bisexist)
		{
			return "fail";
		}
		this.us.add(user);
		return "success";
	}
	
	public String delete()
	{
		User user = new User();
		user.setName(auservo.getName());
		user.setPassword(auservo.getPassword());;
		this.us.delete(user);
		return "success";
	}
	
	public List<User> list()
	{
		return this.us.list();
	}
	
	public UserService getUs() {
		return us;
	}
	
	public String	login() throws IOException
	{
		ActionContext context = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) context.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);

		Map<String, Object> map=new HashMap<String, Object>();
		String status=null;

		User user = new User();
		user.setName(auservo.getName());
		user.setPassword(auservo.getPassword());;
		
		if (auservo.getName() == null || auservo.getPassword() == null ) 
		{
			status = "2";
			map.put("status", status);
			JSONUtils.toJson(response, map);
			return "fail";
		}
		if (user.getName().length()<1 || user.getPassword().length()<1 )
		{
			status = "2";
			map.put("status", status);
			JSONUtils.toJson(response, map);
			return "fail";
		}
		
		User ruser = us.login(user);
		if (ruser != null)
		{
			status = "0";
			map.put("status", status);
			map.put("users", ruser);
//			JSONUtils.toJson(response, map);
//			this.ret = "/usermanager.jsp";
		}
//		else
//		{
//			this.ret = "/registerFail.jsp";
//			status = "1";
//			map.put("status", status);
//			JSONUtils.toJson(response, map);
//		}
		System.out.println("will forward:" + this.ret);
		System.out.println("map:"+map);
		return "success";
	}
	
	@Resource
	public void setUs(UserService us) {
		this.us = us;
	}

	public String getRet() {
		System.out.println("get forward page:" + this.ret);
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}
	
	public void edit(User u)
	{
		this.us.edit(u);
	}

	
}
