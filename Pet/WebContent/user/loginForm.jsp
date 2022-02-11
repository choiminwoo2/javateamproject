<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<link href="css/login.css" type="text/css" rel="stylesheet">
<link href="css/theme.css" type="text/css" rel="stylesheet">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}
</style>
<script>
$(document).ready(function() {
	
	$(".cancelbtn").click(function (){
		location.href="index.jsp";
	});    
	
	var id = '${id}';
	if(id){
		$("#id").val(id);
		$("#remember").prop('checked', true);
	}
});
</script>
</head>
<body>

	<form name="loginform" action="loginProcess.co" method="post"><h1>로그인</h1>
	<hr>
		<b>ID</b>
		<input type="text" name="id" placeholder="Enter id" id="id" required>
		<b>Password</b>
		<input type="password" name="password" placeholder="Enter password" id="password" required>
		
		<input type="checkbox" id="remember" name="remember" value="store">
		<span>ID 기억하기</span><br><br>
		<div class="clearfix">
			<button type="submit" class="btn btn-primary mr-2 submitbtn">로그인</button>
			<button type="reset" class="btn btn-outline-secondary mr-2 cancelbtn">돌아가기</button>
		</div>
		<input type="hidden" value="index.jsp">
	</form>
</body>
</html>