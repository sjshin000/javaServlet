<%@page import="jspPrj.LoginModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	LoginModel getLoginModel = (LoginModel)session.getAttribute("loginInfo");
	if (null != session.getAttribute("isLogin") && session.getAttribute("isLogin").equals("true")) {
		out.println("아이디 : " + getLoginModel.getId() + " <a href = /login/logout.jsp>[로그아웃]</a>" + getLoginModel.getName());
	} else {
		out.println("<a href=/login/login.html>[로그인]</a>");
	}
%>
	<a href = "/index.jsp">[홈 이동]</a>
</body>
</html>