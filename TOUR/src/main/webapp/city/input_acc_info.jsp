<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/Fukuoka/acc/FukuokaAccServlet" method ="post" enctype="multipart/form-data">
		
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
		
		<label for ="acc_name">숙소 이름 : </label>
		<input type ="text" name="acc_name" id="acc_name" required> <br>
		
		<label for ="acc_location">숙소 주소 : </label>
		<input type ="text" name="acc_location" id="acc_location" required> <br>
		
		<label for ="acc_phone">전화번호 : </label>
		<input type ="text" name="acc_phone" id="acc_phone" required> <br>
		
		<label for ="acc_time">운영시간 : </label>
		<input type ="text" name="acc_time" id="acc_time" required> <br>
		
		
		<label for ="acc_comment">숙소 정보 : </label>
		<input type ="text" name="acc_comment" id="acc_comment" required> <br>
		
		<label for="acc_img1"> 이미지 : </label>
		<input type = "file" name = "acc_img1" id="acc_img1" required> <br>
		
		<label for="acc_img2"> 이미지 : </label>
		<input type = "file" name = "acc_img2" id="acc_img2" required> <br>
		
		<label for="acc_img3"> 이미지 : </label>
		<input type = "file" name = "acc_img3" id="acc_img3" required> <br>
		
		<button type="submit">업로드</button>

	</form>


</body>
</html>