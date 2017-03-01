<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="/css/style.css" rel="stylesheet" />
<title>Insert title here</title>
</head>

<body>
    <div id="<element>jb-container</element>">
    	<div id="jb-header">
    		<%@ include file= "/login/loginOk.jsp" %>
    		<a href = "/BoardServletList">[게시판 리스트]</a>
    		<a href = "/board/boardWrite.jsp">[게시판 글쓰기]</a>
    		<a href = "/login/join.html">[회원가입]</a>
    	</div>
 <!-- 	<div id="jb-sidebar-left">
    		<a href = "/BoardServletList">[게시판 리스트]</a> <br />
    		<a href = "/board/boardWrite.jsp">[게시판 글쓰기]</a>
    		<a href = "/login/join.html">[회원가입]</a> <br />
    	</div>
-->
    	<div id="jb-content">
    		jb-content
    	</div>
    	<div id="jb-footer">
    		jb-footer
    	</div>
    </div>
</body>
</html>