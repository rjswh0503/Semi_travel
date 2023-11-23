<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.city.Sapporo.acc.SapporoAcc" %>
<%@ page import="com.kh.city.Sapporo.acc.SapporoAccDAO" %>

<!DOCTYPE html>
<html>
<head>
    <script src="./jquery-3.2.1.js"></script>
    <script type="text/javascript" src="./asd.js"></script>
    

    <meta charset="UTF-8">
    <title>삿포로 호텔</title>
    <link rel="stylesheet" type="text/css" href="../spot/SapporoTour.css">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Bagel+Fat+One&display=swap');
  

        
.top10 {
	margin-left: 12%;
	margin-right: 15%;
	width: 75%;
	height: 500px;
	margin-bottom: 25px;
	flex-wrap: wrap;

}

img {
	
	margin-top: 30px;
	border-radius: 20px;
	filter: drop-shadow(10px 8px 8px #c3c3c3);
	

}




.mainImage {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    margin-top: 100px;
    margin-bottom: 80px;
    margin-left: 5%;
    
}

.mainImage a {
    flex: 0 0 40%; /* Adjust the width of each image container */
    margin: 10px; /* Add some margin to provide space between images */
}

.mainImage img {
    width: 300px;
    height: 300px;
    border-radius: 20px;
    right:15%;
}

.main_logo {
	color:  #EE9CA7;
	text-decoration-line: none;
	margin-left: 10%;
	font-family: 'Bagel Fat One', sans-serif;
	text-shadow: 5px 5px 20px #EE9CA7;
}





#dropdownBtn {
	position: relative;
	margin-left: 50%;
	background-color: #EE9CA7;
	color: #fff;
	border: none;
    padding: 10px 30px;
    border-radius: 50px;
    width:170px;
    font-size: 16px;
    font-weight: 600;
	background-size: 290% 100%;
	
	moz-transition: all .4s ease-in-out;
	-o-transtion: all .4s ease-in-out;
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out;
	
	background-image: linear-gradient(to right, #ed6ea0,#ec8c69, #f7186a , #FBB03B);
	box-shadow: 0 4px 15px 0 rgba(236,116,149,0.75);
	left: 13%;
	
}


#dropdownBtn:hover {
	background-position: 100% 0;
	moz-transition: all .4s ease-in-out;
	-o-transition: all .4s ease-in-out;
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out;
	
}


#dropdownBtn:focus {
	outline: none;
}





#dropdownContent {
	display: none;
	position: absolute;
	background-color: white;
	min-width: 150px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	border-radius: 20px;
}

#dropdownContent a {
	color: black;
	padding: 16px 16px;
	text-decoration: none;
	display: block;

	
}

#dropdownContent a:hover {
	background-color: #EE9CA7;
	color: white;
	border-radius: 20px;
}


.info {
	margin-left: 10%;
	margin-right: 10%;
}

.category_img {
	width: 500px;
	height: 300px;
}

#topMenu {
	padding: 20px;
	margin-bottom: 60px;
	height: 60px;
	margin-left:9.2%;

	

}
#topMenu ul {
	
    display: flex;
    list-style: none;
    padding: 0;
    margin-bottom: 30px;

    
    
}

#topMenu li {
    margin-right: 0px;
    
   
    
}

.submenu,
.submenu2,
.submenu3 {
     display: flex;
    flex-direction: row; 
    position: absolute;
    top: 95%;
    left: 0;
    z-index: 1;
    display: none;
}

.submenu li,
.submenu2 li,
.submenu3 li {
    margin: 0.5px;
}

#topMenu li:hover .submenu,
#topMenu li:hover .submenu2,
#topMenu li:hover .submenu3 {
    display: flex;
    
}


h2 {
	text-align: center;
	margin-top: 100px;
	margin-right: 2%;
	color: #EE9CA7;
	font-size: 70px;
	text-shadow: 5px  #EE9CA7; 
	font-family: 'Bagel Fat One', sans-serif;
	
	
}


       
        
        
    </style>
</head>
<body>
<h2>삿포로 호텔</h2>
<div class="tour-container">
    <%
    SapporoAccDAO accDAO = new SapporoAccDAO();
        List<SapporoAcc> accs = accDAO.getAllAccs();

        for (SapporoAcc ad : accs) {
    %>
    </div>
    <div class="tour">
        <p><a href="SapporoAccdetail.jsp?acc_id=<%= ad.getAcc_id()%>"><%= ad.getAcc_name() %></a></p>
        <div class="all">
            <a href="SapporoAccdetail.jsp?acc_id=<%= ad.getAcc_id()%>"><img src="<%=ad.getAcc_img1() %>"></img></a>
        
    </div>
    <%
        }
    %>

    
</div>

</body>
</html>