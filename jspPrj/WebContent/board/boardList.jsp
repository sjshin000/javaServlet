<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, jspPrj.BoardModel,jspPrj.BoardListServlet, jspPrj.BoardProccess"%>
<%
	List<BoardModel> list = (List<BoardModel>)request.getAttribute("list");
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
    			<table>
		<tr class = 'title'>
			<th width = 50>순서</th>
			<th width = 300>제목</th>
			<th width = 50>작성자</th>
			<th width = 100>작성일</th>
			<th width = 100>수정일</th>
			<th width = 50>조회수</th>
			
		</tr>
		<% 
			//for(int i = 0; i < list.size(); i++) {
			int index = 0;
			for(BoardModel boardModel : list) {
				//boardModel = list.get(i);
		%>
		<tr class = 'list'>
			
			<td><%=(++index) %></td>
			<td><a href = "BoardModify?boardId=<%=boardModel.getBoardId()%>"><%=boardModel.getTitle()%></a></td>
			<td><%=boardModel.getWriter() %></td>
			<td><%=boardModel.getCreatDate() %></td>
			<td><%=boardModel.getUpdateDate() %></td>
			<td><%=boardModel.getHit() %></td>
		</tr>
		<% } %>
	</table>
    	</div>
    	<div id="jb-footer">
    		jb-footer
    	</div>
    </div>	
</body>
</html>