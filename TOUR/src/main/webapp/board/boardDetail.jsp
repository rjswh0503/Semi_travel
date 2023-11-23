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
<title>게시물 보기</title>
</head>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Bagel+Fat+One&display=swap');
        body {
            font-family: Arial, sans-serif;
            background-color: #F2F2F2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 2px 2px 20px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
            color: #EE9CA7;
            font-family: 'Bagel Fat One', sans-serif;
            font-size: 50px;
        }
        p {
            margin: 10px 0;
            padding: 5px;
        }
        button {
            margin-top: 40px;
            background-color:#EE9CA7;
        }
</style>
<body>
<h1>게시판 상세페이지</h1>
<form action="/board/deleteServlet" method="post">
  	<%
  	BoardComment bc = null;
		
	String user_id = (String) session.getAttribute("user_id");
	String post_numberValue = request.getParameter("post_number");
	
	int post_number = Integer.parseInt(post_numberValue);
	
	BoardDTO bd = new BoardDAO().getBoard(post_number);
	ArrayList<BoardComment> reviewList = new BoardDAO().getCommentsByProductId(post_number);

	%>
 
<div class="container">
<p>작성자 :	 <%= bd.getUser_id() %><br></p>
<p>작성날짜 :	 <%= bd.getPost_time() %><br></p>
<p>도시이름 :  <%= bd.getCity_name() %><br></p>
<p>카테고리 :	 <%= bd.getCategory() %><br></p>
<p>제목 : 	 <%= bd.getTitle() %><br></p>
<p>내용 :  	 <%= bd.getContent() %><br></p>

<input type = "text" id ="post_number" name="post_number" value="<%= post_number %>" style="display: none;">
		<input type ="submit" value="삭제하기">
		<a href="update_board.jsp">수정하기</a>
</div>
		
		
	</form>
	



	    	
  	    
	    	
  	    
         
		
         
	</body>	
	 <!--  댓글 목록 표시 -->
   
    

                
</html>