<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<link href="css/login.css" type="text/css" rel="stylesheet">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}
</style>
</head>
<body>
	<form name="loginform" action="loginProcess.co" method="post"><h1>로그인</h1>
	<hr>
		<b>ID</b>
		<input type="text" name="id" placeholder="Enter id" id="id" required>
		<b>Password</b>
		<input type="password" name="pass" placeholder="Enter password" id="id" required>
		<input type="checkbox" id="remember" name="remember" value="store">
		<span>remember</span>
		<div class="clearfix">
			<button type="submit" class="submitbtn">로그인</button>
			<button type="reset" class="cancelbtn">돌아가기</button>
		</div>
		
</form>
</body>
</html>