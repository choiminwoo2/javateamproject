<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- http://localhost:8088/Pet/join.co  --%>
<html>
<head>
<style>
 .phone>input[type=text] {
   width:  100px;
   height: 30px;

 }
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link href="css/join.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="joinform" action="joinProcess.co" method="post">
		<h1>회원가입</h1>
		<hr>
		<b>아이디</b>
		<input type="text" name="id" placeholder="Enter id" required maxLength="12">
		<span id="message"></span>

		<b>비밀번호</b><input type="password" name="pass" placeholder="Enter password" required>

		<b>닉네임</b><input type="text" name="name" maxLength="5" required>


		<div class="phone">
		<label for="my_pnumber">전화번호</label><br>
     	<input type="text" name="te1" maxlength="3"> -
        <input type="text" name="tel2" maxlength="4"> -
        <input type="text" name="tel3" maxlength="4">

		</div>
	    <b>반려동물 구분</b>
	    <select name="kind">
	      <option value="dog">강아지</option>
	      <option value="cat">고양이</option>
	    </select><br><br>
   
		 <b>반려동물 무게(kg)</b>
	 	 <input type="text" name="kg"  maxLength="5" required>
	   	 <b></b>

		<b>사용자 구분</b>
		<label><input type="radio" name=user_grant value="0">일반 사용자</label>
		<label><input type="radio" name=user_grant value="1">호텔 사용자</label>
		<div class="clearfix">
			<button type="submit" class="submitbtn">회원가입</button>
			<button type="reset" class="cancelbtn">취소</button>
		</div>
		</form>
</body>
</html>
