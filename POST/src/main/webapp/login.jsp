<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="email">Email:</label>
	<input type="email" id="email" name="email" required />
	<br />
	<label for="password">Mật khẩu:</label>
	<input type="password" id="password" name="password" required />
	<button type="button" id="login-button">Đăng nhập</button>
	<script type="module" src="login.js"></script>
	 <div id="message"></div>
</body>
</html>