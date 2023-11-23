<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.city.Nagoya.spot.NagoyaTour" %>
<%@ page import="com.kh.city.Nagoya.spot.NagoyaTourDAO" %>

<!DOCTYPE html>
<html>
<head>
    <script src="./jquery-3.2.1.js"></script>
    <script type="text/javascript" src="./asd.js"></script>

    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        p {
            font-size: 20px;
            text-align: center;
            padding-top: 150px;
        }

        a {
            text-decoration-line: none;
        }

        img {
            width: 300px;
            height: 300px;
            border-radius: 30px;
            margin: 0 auto;
            margin-right: 15px;
            padding-top: 14px;
            padding: 10px 0px 0px 10px;
            filter: drop-shadow(10px 6px 6px #c3c3c3);
        }

        .tour-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr); /* Display images in two columns */
            gap: 0.5%;
            box-sizing: border-box;
        }

        .tour {
            position: relative;
            vertical-align: middle;
            width: 100%;
            box-sizing: border-box;
        }

        .all {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="tour-container">
    <%
    NagoyaTourDAO tourDAO = new NagoyaTourDAO();
        List<NagoyaTour> tours = tourDAO.getAllTours();

        for (NagoyaTour t : tours) {
    %>
    <div class="tour">
        <p><a href="NagoyaTourdetail.jsp?tour_id=<%= t.getTour_id()%>"><%= t.getTour_name() %></a></p>
        <div class="all">
            <a href="NagoyaTourdetail.jsp?tour_id=<%= t.getTour_id()%>"><img src="<%=t.getTour_img1() %>"></img></a>
        </div>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
