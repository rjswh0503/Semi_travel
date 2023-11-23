<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>
	<form action="LoginServlet" method="post">
		<header>
		<a href="../website.jsp">
		<h1>떠나조</h1></a>
        <div class="total">
            <div class="container light-style flex-grow-1 container-p-y">
                <h3 class="font-weight-bold py-3 mb-4">
                    마이 페이지
                </h3>

                <div class="card overflow-hidden">
                    <div class="row no-gutters row-bordered row-border-light">
                        <div class="col-md-3 pt-0">
                            <div class="list-group list-group-flush account-settings-links">
                                <a class="list-group-item list-group-item-action" data-toggle="list" href="./user-info.html">회원
                                    정보</a>
                                <a class="list-group-item list-group-item-action" data-toggle="list" href="./user-password.html">비밀 번호
                                    변경</a>
                                <a class="list-group-item list-group-item-action" data-toggle="list"
                                    href="./user-post.html">내가 쓴 게시글</a>
                                    
                                   
                           
                                <a class="list-group-item list-group-item-action" data-toggle="list" href="./user-delete.html">회원 탈퇴</a>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="tab-content">
                                <div class="card-body media align-items-center">
                                </div>
                            </div>
                            <hr class="border-light m-0">
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="form-label">현재 비밀번호 입력</label>
                                    <input type="password" class="form-control mb-1" value="">
                                </div>
                                

                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-right mt-3">
                    <a href="user-inquiry.jsp"><button type="button" class="btn btn-primary">확인</button></a>
                </div>
            </div>
        </div>
    </header>
	</form>
</body>
</html>