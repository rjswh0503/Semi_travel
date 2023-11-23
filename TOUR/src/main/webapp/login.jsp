<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>로그인</title>
    <link rel="stylesheet" href="login.css">

    <script>
        function displayLoginFail() {
            alert("아이디 / 비밀번호가 일치하지 않습니다.");
        }
    </script>
</head>
<body>
	<form action="<%= request.getContextPath() %>/LoginServlet?action=login" method="post">
    <input type="hidden" name="action" value="login">
    <header>
        <div class="total">
            <h1>Login</h1>
            <div class="login-form">
                <input type="text" name="USER_ID" id="user_id" placeholder="ID">
                <input type="password" name="USER_PW" id="user_pw" placeholder="PASSWORD">
                <input type="checkbox" id="check">아이디 저장하기
                <input type="checkbox" id="passCheck">비밀번호 저장하기
                <input type="submit" id="btn" value="Log In">
                <input type="button" onclick="location.href='<%= request.getContextPath() %>/signIn/signIn.jsp'" id="btn2" value="회원 가입">
            </div>
            <a href="mainpage.jsp" class="back">돌아가기</a>
        </div>
    </header>
    </form>

    <%
        String loginError = (String) request.getAttribute("loginError");

        if (loginError != null) {
    %>
        <script>
            displayLoginFail();
        </script>
    <%
        }
    %>
</body>
</html>
