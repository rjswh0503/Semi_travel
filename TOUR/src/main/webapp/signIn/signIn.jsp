<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="signIn.css">
<meta charset="UTF-8">

<title>회원가입</title>

</head>
<style>
</style>
<body>

	<form
		action="<%=request.getContextPath()%>/LoginServlet?action=signIn"
		method="post">
		
	<header>
		
		<section>
		
			<h1>회원가입</h1>
			<div>
				<label for="user_name">이름 : <em> * </em>
				</label> <input type="text" id="user_name" name="user_name" required>
			</div>



			<div>
				<label for="user_id">아이디 : <em> * </em>
				</label> <input type="text" id="user_id" name="user_id" required>
			</div>


			<div>
				<label for="user_pw">비밀번호 :<em> * </em>
				</label> <input type="password" id="user_pw" name="user_pw" required>
				<br> <label for="user_pw2">비밀번호 재입력 :<em> * </em>
				</label> <input type="password" id="user_pw2" name="user_pw2" required>


			</div>

			<div>
				<label for="user_phone"> 전화번호 : <em> * </em>
				</label> <input type="tel" id="user_phone" name="user_phone" required><br>
			</div>

			<div>
				<label for="user_email">이메일 : </label><br> <input type="email"
					id="user_email" name="user_email"><br>
			</div>

			<br>

			<p>
				<label for="user_age">생년월일 : </label> <input type="date"
					id="user_age" name="user_age">
			</p>


			<p>
				<label for="user_sex">성별 : </label> <input type="radio"
					name="user_sex" value="남">남성 <input type="radio"
					name="user_sex" value="여">여성
			</p>


			<o>
			<button type="submit" onclick="Validation()">회원 가입</button>
			<button type="reset" onclick="alert('초기화 했습니다.')">다시 입력</button>
			</o>
		
		</section>
		
		</header>
	</form>
	

	<script>
		function Validation() {

			var user_pw = document.getElementById("user_pw")
			var user_pw2 = document.getElementById("user_pw2")
			var user_id = document.getElementById("user_id")
			var user_name = document.getElementById("user_name")
			var user_phone = document.getElementById("user_phone")
			var user_age = document.getElementById("user_age")

			var reguser_phone = /^01([0|1|6|7|8|9])-?([0-9]{4})-?([0-9]{4})$/

			var reguser_pw = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/;

			if (user_name.value == "") {
				alert("이름을 입력하세요.")
				user_name.focus();
				return false;
			}
			if (user_id.value == "") {
				alert("아이디를 입력하세요.")
				user_id.focus();
				return false;
			}
			if (user_pw.value == "") {
				alert("비밀번호를 입력하세요.")
				user_pw.focus();

				return false;
			}
			if (user_pw.value != user_pw2.value) {
				alert("비밀번호가 불일치합니다")
				user_pw.focus();
				return false;
			}
			if (!reguser_pw.test(user_pw.value)) {
				alert("10~12자 영문 대소문자, 숫자를 이용해 입력하세요.")
				user_pw.focus();
				return false;
			}
			if (user_pw.value == user_id.value) {
				alert("아이디와 동일한 비밀번호를 사용할 수 없습니다.")
				user_pw.focus();
				return false;
			}

			if (user_phone.value == "") {
				alert("전화번호를 입력하세요.")
				user_phone.focus();
				return false;
			}
			S

			if (!reguser_phone.test(user_phone.value)) {
				alert("정확한 전화번호를 입력해주세요.")
				user_phone.focus();
				return false;

			}

			if (user_age.value == "") {
				alert("생년월일을 입력하세요")
				user_age.focus();
				return false;
			}

			return true;

		}
	</script>

</body>

</html>