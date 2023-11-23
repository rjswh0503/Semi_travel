<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/Fukuoka/res/FukuokaAccServlet" method ="post" enctype="multipart/form-data">
		
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
		
		<label for ="res_name">식당 이름 : </label>
		<input type ="text" name="res_name" id="res_name" required> <br>
		
		<label for ="res_location">식당 주소 : </label>
		<input type ="text" name="res_location" id="res_location" required> <br>
		
		<label for ="res_phone">전화번호 : </label>
		<input type ="text" name="res_phone" id="res_phone" required> <br>
		
		<label for ="res_time">운영시간 : </label>
		<input type ="text" name="res_time" id="res_time" required> <br>
		
		
		<label for ="res_comment">식당 정보 : </label>
		<input type ="text" name="res_comment" id="res_comment" required> <br>
		
		<label for="res_img1"> 이미지 : </label>
		<input type = "file" name = "res_img1" id="res_img1" required> <br>
		
		<label for="res_img2"> 이미지 : </label>
		<input type = "file" name = "res_img2" id="res_img2" required> <br>
		
		<label for="res_img3"> 이미지 : </label>
		<input type = "file" name = "res_img3" id="res_img3" required> <br>
		
		<button type="submit">업로드</button>

	</form>


</body>
</html>