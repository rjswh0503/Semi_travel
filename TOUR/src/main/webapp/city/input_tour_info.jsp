<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/Fukuoka/spot/FukuokaTourServlet" method ="post" enctype="multipart/form-data">
		
		<label for ="user_id">유저 이름 : </label>
		<input type ="text" name="user_id" id="user_id" required> <br>
		
		<p id="city_name">
				<label for ="city_name">도시</label> <br>
                <input type="radio" id ="city_name"name="city_name" value="Osaka">오사카
                <input type="radio" id ="city_name"name="city_name" value="Sapporo">삿포로
                <input type="radio" id ="city_name"name="city_name" value="Nagasaki">나가사키
                <input type="radio" id ="city_name"name="city_name" value="Tokyo">도쿄
                <input type="radio" id ="city_name"name="city_name" value="Shizuoka">시즈오카
                <input type="radio" id ="city_name"name="city_name" value="Kyoto">교토
                <input type="radio" id ="city_name"name="city_name" value="Nagoya">나고야
                <input type="radio" id ="city_name"name="city_name" value="Fukuoka">후쿠오카
		
			</p>
		
		<label for ="tour_name">관광지 이름 : </label>
		<input type ="text" name="tour_name" id="tour_name" required> <br>
		
		<label for ="tour_location">관광지 주소 : </label>
		<input type ="text" name="tour_location" id="tour_location" required> <br>
		
		<label for ="tour_phone">전화번호 : </label>
		<input type ="text" name="tour_phone" id="tour_phone" required> <br>
		
		<label for ="tour_time">운영시간 : </label>
		<input type ="text" name="tour_time" id="tour_time" required> <br>
		
		
		<label for ="tour_comment">관광지 정보 : </label>
		<input type ="text" name="tour_comment" id="tour_comment" required> <br>
		
		<label for="tour_img1"> 이미지 : </label>
		<input type = "file" name = "tour_img1" id="tour_img1" required> <br>
		
		<label for="tour_img2"> 이미지 : </label>
		<input type = "file" name = "tour_img2" id="tour_img2" required> <br>
		
		<label for="tour_img3"> 이미지 : </label>
		<input type = "file" name = "tour_img3" id="tour_img3" required> <br>
		
		<button type="submit">업로드</button>

	</form>


</body>
</html>