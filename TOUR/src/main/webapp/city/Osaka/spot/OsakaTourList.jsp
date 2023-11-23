<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.city.Osaka.spot.OsakaTour" %>
<%@ page import="com.kh.city.Osaka.spot.OsakaTourDAO" %>

<!DOCTYPE html>
<html>
<head>
    <script src="./jquery-3.2.1.js"></script>
    <script type="text/javascript" src="./asd.js"></script>

    <meta charset="UTF-8">
    <title>오사카 관광지</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Bagel+Fat+One&display=swap');
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
        
        h2 {
        	text-align: center;
        	margin-top: 70px;
        	color: #EE9CA7;
        	font-family: 'Bagel Fat One', sans-serif;
        	font-size: 70px;
        }
    </style>
</head>
<body>
 <h2>오사카 관광지</h2>
<div class="tour-container">
    <%
    OsakaTourDAO tourDAO = new OsakaTourDAO();
        List<OsakaTour> tours = tourDAO.getAllTours();

        for (OsakaTour t : tours) {
    %>
    <div class="tour">
        <p><a href="OsakaTourdetail.jsp?tour_id=<%= t.getTour_id()%>"><%= t.getTour_name() %></a></p>
        <div class="all">
            <a href="OsakaTourdetail.jsp?tour_id=<%= t.getTour_id()%>"><img src="<%=t.getTour_img1() %>"></img></a>
        </div>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
