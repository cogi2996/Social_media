<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Đăng ký</title>
  </head>
  <body>
    <h1>Đăng ký tài khoản</h1>
    <form id="registration-form">
      <label for="name">User name:</label>
      <input type="name" id="username" name="username" required />
      <br />
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required />
      <br />
      <label for="password">Mật khẩu:</label>
      <input type="password" id="password" name="password" required />
      <br />
      <button type="button" id="register-button">Đăng ký</button>
    </form>

    <div id="message"></div>
   
    <script type="module" src="auth.js"></script>
  </body>
</html>
