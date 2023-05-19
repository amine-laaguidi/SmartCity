<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>Login page</h1>
<form method="post" action="/login">
    <label>email</label>
    <input type="email" name="username" required>
    <label>password</label>
    <input type="password" name="password" required>
    <input type="submit" name="submit" value="Login" >
</form>
</body>
</html>