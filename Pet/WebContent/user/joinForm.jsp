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
<script>
function setDisplay(){
    if($('input:radio[id=hotel]').is(':checked')){
        $('#usercheck').hide();
        $('#kg').val('');
    }else{
        $('#usercheck').show();
    }
 }
 </script>
 <style>
span {
	font-size:15px;
}
</style>
</head>
<body>
	<form id="joinform" name="joinform" action="joinProcess.co" method="post">
		<h1>회원가입</h1>
		<hr>
		<b>아이디</b>
		<input type="text" name="id" placeholder="Enter id" required maxLength="12">
		<span id="id_message"></span>

		<b>비밀번호</b><input type="password" name="password" placeholder="Enter password" required>

		<b>닉네임</b><input type="text" name="nickname" maxLength="10" required>
		<span id="nickname_message"></span>

		<div class="phone">
		전화번호<br>
     	<input type="text" name="tel" maxlength="13" required> 
     	<span id="tel_message"></span>
        </div><br>
		
		<b>사용자 구분</b>
		<input type="radio" id="user" name=user_grant value="0" onchange="setDisplay()" checked>일반 사용자
		<input type="radio" id="hotel" name=user_grant value="1" onchange="setDisplay()">호텔 사용자
		<br><br>
		
		<div id="usercheck">
	    <b>반려동물 구분</b>
	    <select name="kind">
	      <option value="dog">강아지</option>
	      <option value="cat">고양이</option>
	    </select><br><br>
   
		 <b>반려동물 무게</b>
	 	 <input type="text" id="kg" name="kg"  maxLength="5" placeholder="KG">
	 	 <span id="animal_message"></span>
	   	 <b></b>
		</div>
		
		<div class="clearfix">
			<button type="submit" class="submitbtn">회원가입</button>
			<button type="reset" class="cancelbtn">돌아가기</button>
		</div>
		</form>
</body>
</html>
