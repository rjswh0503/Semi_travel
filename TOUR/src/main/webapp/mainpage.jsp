<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인페이지</title>
    <link rel="stylesheet" href="mainpage.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <form action="LoginServlet" method="post">
        <input type="hidden" name="action" value="login">
        <header>
           
            <div class="navbar">
                <ul>
                    <li class="active"><a href="website.jsp">TOP 여행지</a></li>

                    <%	
                        String loggedIn = (String) session.getAttribute("user_id");
                        String userName = (String) session.getAttribute("user_name");

                        if (loggedIn != null && !loggedIn.isEmpty()) {
                    %>
                            <li class="active"><span><%=userName%>님</span></li>
                    <%
                        } else {
                    %>
                            <li><a href="login.jsp">로그인</a></li>
                    <%
                        }
                    %>

                </ul>
            </div>
            <div class="title">
                <h1>떠나조</h1>
            </div>
            
        </header>
    </form>
</body>
</html>
