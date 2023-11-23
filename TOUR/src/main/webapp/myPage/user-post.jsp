<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kh.board.BoardDTO"%>
<%@ page import="com.kh.board.BoardDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<link rel="stylesheet" href="../myPage/mypage-css/mypage.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
	<style>
.list-group-item.active {
    z-index: 2;
    color: #fff;
    background-color: #EE9CA7;
    border-color: #EE9CA7;
}

.btn-primary {
    color: white;
    background-color: #EE9CA7;
    border-color: #EE9CA7;
    
    
    
}

.btn-primary:hover {
    color: black;
    background-color: #EE9CA7;
    border-color: #EE9CA7;
    
}
</style>

</head>
<body>

	<form action="<%= request.getContextPath() %>/LoginServlet?action=login" method="post">
		<header>
		<a href="../website.jsp">
		<h1>떠나조</h1></a>
			<div class="total">
				<div class="container light-style flex-grow-1 container-p-y">
					<h3 class="font-weight-bold py-3 mb-4">마이 페이지</h3>

					<div class="card overflow-hidden">
						<div class="row no-gutters row-bordered row-border-light">
							<div class="col-md-3 pt-0">
								<div class="list-group list-group-flush account-settings-links">
									<a class="list-group-item list-group-item-action"
										data-toggle="list" href="user-info.jsp">회원 정보</a> <a
										class="list-group-item list-group-item-action"
										data-toggle="list" href="user_password-edit.jsp">비밀 번호 변경</a>
									<a class="list-group-item list-group-item-action active"
										data-toggle="list" href="user-post.jsp">내가 쓴 게시글</a> 
									<a class="list-group-item list-group-item-action"
										data-toggle="list" href="user-delete.jsp">회원 탈퇴</a>
								</div>
							</div>
							<div class="col-md-9">
								<div class="tab-content">
									<div class="card-body media align-items-center"></div>
									<table border="1">
										<colgroup>
											<col width="15%">
											<col width="15%">
											<col width="*">
											<col width="10%">
										</colgroup>
										<tr>
											<td>도시이름</td>
											<td>카테고리</td>
											<td>제목</td>
											<td>작성날짜</td>
										</tr>
										<%
										String user_id = (String) session.getAttribute("user_id");
										BoardDAO boardDAO = new BoardDAO();
										List<BoardDTO> userBoards = boardDAO.getBoardsByUserId(user_id);

										for (BoardDTO board : userBoards) {
										%>
										<tr>
											<td><%=board.getCity_name()%></td>
											<td><%=board.getCategory()%></td>
											<td><a
												href="../board/boardDetail.jsp?post_number=<%=board.getPost_number()%>"><%=board.getTitle()%></a></td>
											<td><%=board.getPost_time()%></td>
										</tr>
										<%
										}
										%>
									</table>



								</div>
								<hr class="border-light m-0">
								<div class="card-body"></div>
							</div>
						</div>
					</div>
					<div class="text-right mt-3"></div>
				</div>
			</div>
		</header>
	</form>
</body>
</html>