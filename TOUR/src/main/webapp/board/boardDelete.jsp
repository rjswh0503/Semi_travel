<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.board.BoardDTO" %>
<%@ page import="com.kh.board.BoardDAO" %>
<%@ page import = "com.kh.board.BoardComment" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

		//DAO 작업
	String post_numberValue = request.getParameter("post_number");
		int post_number = Integer.parseInt(post_numberValue);
		//DAO 작업
			BoardDTO db = new BoardDAO().getBoard(post_number);
	%>

	<form action="deleteServlet" method="post">
	
		
		<input type = "text" id ="post_number" name="post_number" value ="<%=db.getPost_number() %>"> 
		
		<input type ="submit" value="삭제하기">
	</form>
		

	
</body>
</html>