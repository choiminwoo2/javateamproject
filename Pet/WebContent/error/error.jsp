<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
<style>
 body {width:500px; margin:3em auto}
 div {
 	color:orange;
 	font-size:30px;
}
span{font-size:1.5em; color:#5d5de2}
</style>
</head>
<body>
	<a href="index.jsp"><img src="error/error.png" width="100px"></a><br>
	<div>죄송합니다. <br>
	${message}</div> <br>
	<span>서비스 이용에 불편을 드려 죄송합니다.</span>
</body>
</html>