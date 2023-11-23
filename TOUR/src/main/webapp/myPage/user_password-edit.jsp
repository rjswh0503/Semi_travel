<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/myPage/mypage-css/mypage.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script>
	function wrongPassword() {
		alert("비밀번호가 일치하지 않습니다."); 
	}
</script>
</head>
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
<body>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		<input type="hidden" name="action" value="checkPasswordEdit"> <input
			type="hidden" name="USER_ID"
			value="<%=session.getAttribute("user_id")%>">
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
										class="list-group-item list-group-item-action active"
										data-toggle="list" href="user_password-edit.jsp">비밀 번호 변경</a>
									<a class="list-group-item list-group-item-action"
										data-toggle="list" href="user-post.jsp">내가 쓴 게시글</a>
									<a class="list-group-item list-group-item-action"
										data-toggle="list" href="user-delete.jsp">회원 탈퇴</a>
								</div>
							</div>
							<div class="col-md-9">
								<div class="tab-content">
									<div class="card-body media align-items-center"></div>
								</div>
								<hr class="border-light m-0">

								<div class="card-body">
									<div class="form-group">
										<label for="input_password" class="form-label">현재 비밀번호
											입력</label> <input type="password" class="form-control mb-1"
											name="USER_PW" id="input_password">
									</div>
								</div>
								<div class="text-right mt-3">
									<button type="submit" class="btn btn-primary"
										id="check_password">확인하기</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
	</form>

	<%
	String wrongPassword = (String) request.getAttribute("wrongPassword");

	if (wrongPassword != null) {
	%>
	<script>
		wrongPassword();
	</script>
	<%
	}
	%>
</body>
</html>