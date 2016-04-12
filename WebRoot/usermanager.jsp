<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>User manager page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%-- 	<%
		String sret = "sret";//response.getWriter().toString();
	 %> --%>
	
  </head>
  
  <body>
    
    <tr>hello <%= request.getParameter("name") %></tr>
    <br>
	  <!--  -->
   
     
    
    <table width="768" align="center" border=2 >
    <tr>
    	<th width="30%" align="center">编号</th>
  	  	<th width="30%" align="center">用户名</th>
  	  	<th align="center">等级</th>
    </tr>
	<%
		for(int i = 1; i < 11; i++)
		{
	 %>
	 <tr>
    	<td valign="middle" height="50"><%=i %></td>
    	<td>user<%=i %></td>
    	<td>title</td>
     </tr>
    <%
    	}
     %>
    </table>
    <!-- 
     <tr>response get string: <%=response.getWriter() %></tr>
      -->
  </body>
</html>
