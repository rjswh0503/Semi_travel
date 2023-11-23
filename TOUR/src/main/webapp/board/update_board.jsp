<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.board.BoardDTO" %>
<%@ page import="com.kh.board.BoardDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 업데이트</title>
	<style>
	 @import url('https://fonts.googleapis.com/css2?family=Bagel+Fat+One&display=swap');

        body {
            
            margin: 20px;
            padding: 20px;
            background-color: #f8f8f8;
        }

        table.table2 {
            border-collapse: separate;
            border-spacing: 1px;
            text-align: left;
            line-height: 1.5;
            border-top: 1px solid #ccc;
            margin: 20px 10px;
            width: 100%;
        }

        table.table2 tr {
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            border-bottom: 1px solid #ccc;
        }

        table.table2 td {
            padding: 10px;
            vertical-align: top;
            border-bottom: 1px solid #ccc;
        }

        .submit {
            text-align: center;
            margin-top: 20px;
            color: #EE9CA7;
        }

        h1 {
            text-align: center;
            font-size: 60px;
            color: #EE9CA7;
            font-family: 'Bagel Fat One', sans-serif;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #EE9CA7;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #EE9CA7;
        }

        p input {
            margin-right: 8px;
            display: inline-block;
            
        }
        
	
	</style>

</head>
<body>
<%

		//DAO 작업
			BoardDAO boardDAO = new BoardDAO();
	List<BoardDTO> boards = boardDAO.getAllBoards();
	
		for(BoardDTO b : boards) {
	%>


	<form action="/board/updateServlet" method="post">
	
	
				<label style="display: none;" for ="post_number"><%= b.getPost_number() %></label>
				<input style="display: none;" type = "text" id ="post_number" name="post_number" value=<%= b.getPost_number() %> required>
				<%
		
			}
		%>
		<table class="table2" align="center">
			<form>
				<label for="title">제목</label>
                    <input type="text" name="title" required>

                    <label for="content">내용</label>
                    <textarea name="content" cols="85" rows="15" required></textarea>

                    <label for="city_name">도시</label>
                    <p id="city_name">
                        <input type="radio" id="city_name" name="city_name" value="오사카">오사카
                        <input type="radio" id="city_name" name="city_name" value="삿포로">삿포로
                        <input type="radio" id="city_name" name="city_name" value="나가사키">나가사키
                        <input type="radio" id="city_name" name="city_name" value="도쿄">도쿄
                        <input type="radio" id="city_name" name="city_name" value="시즈오카">시즈오카
                        <input type="radio" id="city_name" name="city_name" value="교토">교토
                        <input type="radio" id="city_name" name="city_name" value="나고야">나고야
                        <input type="radio" id="city_name" name="city_name" value="후쿠오카">후쿠오카
                    </p>

                    <label for="category">카테고리</label>
                    <p id="category">
                        <input type="radio" id="category" name="category" value="숙소">숙소
                        <input type="radio" id="category" name="category" value="관광지">관광지
                        <input type="radio" id="category" name="category" value="식당">식당
                    </p>
				


	<input type ="submit" value="수정하기">
</form>
</table>
</form>

</body>
</html>