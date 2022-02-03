<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- http://localhost:8088/Pet/join.co  --%>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/join.js"></script>
<link href="css/join.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>회원가입</title>


<style>
span {
	font-size:15px;
}
</style>
</head>
<body>
	<form name="joinform" action="joinProcess.co" method="post">
		<h1>회원가입</h1>
		<hr>
		<b>아이디</b>
		<input type="text" name="id" placeholder="Enter id" required maxLength="12">
		<span id="id_message"></span>

		<b>비밀번호</b><input type="password" name="password" placeholder="Enter password" required>

		<b>닉네임</b><input type="text" name="nickname" maxLength="10" required>
		<span id="nickname_message"></span>

		<div class="phone">
		<label for="tel">전화번호</label><br>
     	<input type="text" name="tel" maxlength="13" required> 
     	<span id="tel_message"></span>
        </div><br><br>
		
	    <b>반려동물 구분</b>
	    <select name="kind">
	      <option value="dog">강아지</option>
	      <option value="cat">고양이</option>
	    </select><br><br>
   
		 <b>반려동물 무게(kg)</b>
	 	 <input type="text" name="kg"  maxLength="5" required>
	   	 <b></b>
		
		<b>사용자 구분</b>
		<label><input type="radio" name=user_grant value="0" checked>일반 사용자</label>
		<label><input type="radio" name=user_grant value="1">호텔 사용자</label>
		<div class="clearfix">
			<button type="submit" class="submitbtn">회원가입</button>
			<button type="reset" class="cancelbtn">돌아가기</button>
		</div>
		</form>
</body>
</html>
