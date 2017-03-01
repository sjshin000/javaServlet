<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, jspPrj.BoardModel,jspPrj.BoardListServlet, jspPrj.BoardProccess"%>
<%
	BoardModel board = (BoardModel)request.getAttribute("board");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="/css/style.css" rel="stylesheet" />
</head>
<body>
    <div id="<element>jb-container</element>">
    	<div id="jb-header">
    		<%@ include file= "/login/loginOk.jsp" %>
    		<a href = "/BoardServletList">[게시판 리스트]</a>
    		<a href = "/board/boardWrite.jsp">[게시판 글쓰기]</a>
    	</div>
    	<div id="jb-content">
    		<form action="/BoardModify" method = "post">
				<p><input type ="hidden" name="boardId" value = "<%=board.getBoardId()%>" /></p>
			    <p>제목 : <input type = "text" name = "title" value = "<%=board.getTitle()%>" /></p>
				<p>작성자 : <input type = "text" name = "writer" value = "<%=board.getWriter()%>" /></p>
				<p>내용 : <br /><textarea rows="10" cols="80" name = "description"><%=board.getDescription()%></textarea></p>
				<p><input type = "submit" value = "확인" />
			</form>
		 	<form action="/BoardDelete" method = "post">
				<p><input type ="hidden" name="boardId" value = "<%=board.getBoardId()%>" /></p>
				<p><input type = "submit" value = "글삭제" /></p>
			</form>
    	</div>
    	<div id="jb-footer">
    		jb-footer
    	</div>
    </div>
</body>
</html>