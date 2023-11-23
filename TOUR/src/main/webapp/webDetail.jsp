<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="website.css">

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
	font-size: 80px;
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
	font-size: 100px;
	text-shadow: 5px 5px 25px #EE9CA7; 
	font-family: 'Bagel Fat One', sans-serif;
	
	
}

h3 {

	text-align: center;
	margin-top: 100px;
	margin-right: 2%;
	color: #EE9CA7;
	font-size: 25px;
	text-shadow: 5px 5px 25px #EE9CA7; 
	font-family: 'Bagel Fat One', sans-serif;
}









</style>


<body>
	<form action="LoginServlet" method="post">
        <input type="hidden" name="formAction" value="userInfoForm">
	
		<a href="website.jsp" class="main_logo">
			<h1 style="display: inline-block;">
				<span class="main_title2">떠나조</span>
			</h1>
		</a> 
		<%
		String loggedIn = (String) session.getAttribute("user_id");
		%>

		
		

		
		<!-- Navbar End -->



		<!-- Header Start -->



		<!-- Header End -->



		<!-- Booking Start -->
		

<div class="text">
			

		<h2>관광지 상세정보</h2>

<div id="imageSlider">
			<a href=""><img src="./Image/1.jpg" class="top10"
				alt=""></a> <a href=""><img
				src="./Image/2.jpg" class="top10" alt=""></a>
			<a href=""><img src="./Image/4.jpg" class="top10"
				alt=""></a> <a href=""><img
				src="./Image/4.jpg" class="top10" alt=""></a> 
				
		</div>
		<h3>관광지 이름 : 오타루운하 </h3>
		<h3>관광지 위치 : 2 Chome Odorinishi, Chuo Ward, Sapporo, Hokkaido 060-0042 일본 </h3>
		<h3>운영시간 : 24시간 운영 </h3>
		<h3>전화번호 : +81 11-251-0438 </h3>
		
		

</div>


		<!-- Blog Start -->
		
		
	
	
	
		<script>
			var dropdownBtn = document.getElementById("dropdownBtn");
			var dropdownContent = document.getElementById("dropdownContent");

			dropdownBtn.addEventListener("click", function() {
				if (dropdownContent.style.display === "none"
						|| dropdownContent.style.display === "") {
					dropdownContent.style.display = "block";
				} else {
					dropdownContent.style.display = "none";
				}
			});

			document.addEventListener("click", function(event) {
				if (event.target !== dropdownBtn
						&& event.target !== dropdownContent) {
					dropdownContent.style.display = "none";
				}
			});

			let slideIndex = 0;
			const images = document.querySelectorAll('#imageSlider img');

			function showSlides() {
				for (let i = 0; i < images.length; i++) {
					images[i].style.display = 'none';
				}
				slideIndex++;
				if (slideIndex > images.length) {
					slideIndex = 1;
				}
				images[slideIndex - 1].style.display = 'block';
				setTimeout(showSlides, 3000); 
			}

			showSlides(); 
			
		
		
		</script>
	</form>

</body>
</html>