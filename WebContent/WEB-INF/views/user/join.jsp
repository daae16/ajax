<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	var isChecked = false;
		function checkValue(formObj) {
			if(!isChecked){
				alert('중복확인');
				return false;
			}
			var uiId = document.querySelector('#ui_id');
			if (uiId.value.trim().length < 4) {
				alert('아이디를 확인해주세요.');
				uiId.focus();
				return false;
			}
			var ui_password = document.querySelector('#ui_password');
			if (ui_password.value.trim().length < 4) {
				alert('비번를 확인해주세요.');
				ui_password.focus();
				return false;
			}
			var ui_name = document.querySelector('#ui_name');
			if (ui_name.value.trim().length < 2) {
				alert('이름을 확인해주세요.');
				ui_name.focus();
				return false;
			}
			var ui_age = document.querySelector('#ui_age');
			if (ui_age.value<1 || ui_age.value>150) {
				alert('나이를 확인해주세요.');
				ui_age.focus();
				return false;
			}
			var ui_birth = document.querySelector('#ui_birth');
			if (!ui_birth.value) {
				alert('생년월일을 확인해주세요.');
				ui_birth.focus();
				return false;
			}
			var ui_nickname = document.querySelector('#ui_nickname');
			if (ui_nickname.value.trim().length < 2) {
				alert('별명은 2글자 이상입니다.');
				ui_nickname.focus();
				return false;
			}

		}
		function checkId() {
			var id = document.querySelector('#ui_id').value;
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/checkid?ui_id=' + id);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var res = JSON.parse(xhr.responseText);
						alert(xhr.responseText);
						if(res.result=='true'){
							isChecked = true;
						}
					}
				}
			}
			xhr.send();
		}
	</script>
	<form action="/user/join" method="post"
		onsubmit="return checkValue(this)">
		ID : <input type="text" name="ui_id" id="ui_id">
		<button type="button" onclick="checkId()">중복확인</button>
		<br> PWD : <input type="password" name="ui_password"
			id="ui_password"><br> 이름 : <input type="text"
			name="ui_name" id="ui_name"><br> age : <input
			type="number" name="ui_age" id="ui_age"><br> birth : <input
			type="date" name="ui_birth" id="ui_birth"><br> phone : <input
			type="text" name="ui_phone" id="ui_phone"><br> email : <input
			type="text" name="ui_email" id="ui_email"><br> 별명 : <input
			type="text" name="ui_nickname" id="ui_nickname"><br>
		<button>회원가입</button>
	</form>
</body>
</html>