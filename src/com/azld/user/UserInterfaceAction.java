package com.azld.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("useriaction")
@Scope("prototype")
public class UserInterfaceAction extends ActionSupport {

	private UserService us;
	private String ret;
	public UserService getUs() {
		return us;
	}
	@Resource
	public void setUs(UserService us) {
		this.us = us;
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}

	public String	logini() throws IOException
	{
		ActionContext context = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) context.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);  
		request.getSession();
		
		Map<String, Object> map=new HashMap<String, Object>();
		String status=null;

		String uname = request.getParameter("name");
		String upassword = request.getParameter("password");
		
		status = "2";
		map.put("status", status);
		map.put("name", uname);
		map.put("password", upassword);
		JSONUtils.toJson(response, map);
		this.ret = "/usermanager.jsp";
		return "success";
	}
	
	
	
}
