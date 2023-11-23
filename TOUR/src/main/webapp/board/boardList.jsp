<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.board.BoardDAO" %>
<%@ page import="com.kh.board.BoardDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Bagel+Fat+One&display=swap');
	*{
		padding: 0;
		margin: 0;
		box-sizing: border-box;
		
	
	}
	h1 {
        text-align: center;
        margin-top: 100px;
        color: #EE9CA7;
        font-family:'Bagel Fat One',sans-serif;
        text-shadow: 5px 5px 20px  #EE9CA7;
        font-size: 60px;
    }

   .container {
    margin-top: 80px;

   }
	
	h2{
	font-family: 'Bagel Fat One',sans-serif;
	color: #ee9ca7;
	font-size: 50px;
	margin-left : 5%;
	margin-top :  5%;
	text-shadow: 5px 5px 20px #ee9ca7;
	}
	

</style>
<body>

<a href="../website.jsp">
		<h2>떠나조</h2></a>
	<h1>
	자유게시판 
	</h1>
	<div class="container">
		<div class="board">
	
	<table class="table table-striped">
	<!-- 메인 내 공간정리 -->
		<colgroup>
			<col width="15%">
			<col width="15%">
			<col width="*">
			<col width="10%">
		</colgroup>
		
		<head>
		<tr>
			<td>도시이름</td>
			<td>카테고리</td>
			<td>제목</td>
			<td>작성날짜</td>
		</tr>
	</head>	
	<%
		BoardDAO boardDAO = new BoardDAO();
	List<BoardDTO> boards = boardDAO.getAllBoards();
	
		for(BoardDTO b : boards) {
	%>
	<tbody>
	
	<tr>	<!-- ? 에 클릭하는 POST_NUMBER가 들어간다 -->
		<td><%= b.getCity_name() %></td>
		<td> <%= b.getCategory() %>	</td>	
		<td> <a href="boardDetail.jsp?post_number=<%=b.getPost_number()%>"> <%= b.getTitle() %> </a></td>
		<td> <%= b.getPost_time() %> </td>
	</tr>
	
	</tbody>	
		
		
			
		<%
		
			}
		%>
   </table>
   <a href="board_write.jsp" class="btn btn-default pull-right">글쓰기</a>
   
   <nav class="text-center">
   	<ul class="pagination">
   		<li class="page-item disabled"><a class="page-link" href="#">Previous</a>
   		<li class="page-item active"><a class="page-link" href="#">1</a>
   		 <li class="page-item "><a class="page-link" href="#">2</a>
   		 <li class="page-item "><a class="page-link" href="#">3</a> 
   		 <li class="page-item "><a class="page-link" href="#">4</a> 
   		 <li class="page-item "><a class="page-link" href="#">5</a>
   		 <li class="page-item "><a class="page-link" href="#">Next</a>  
   	</ul>
   
   
   </nav>
   
   	</div>
   </div>
   
   
   
   
   
</body>
</html>