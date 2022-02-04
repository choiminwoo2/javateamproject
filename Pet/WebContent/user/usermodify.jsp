<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="scripts.js"></script>
<link href="../css/join.css" type="text/css" rel="stylesheet">
    <link href="css/theme.css" type="text/css" rel="stylesheet">
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>회원 정보 수정</title>
<script>
$(".cancelbtn").click(function (){
	location.href="index.jsp";
}); // 돌아가기 버튼 메인으로 이동

</script>
</head>
<body>
	<form name="modifyform" action="usermodifyProcess.co" method="post">
		<h1>회원 정보 수정</h1>
		<hr>
		<b>${temp.nickname}</b>
		<input type="text" name="id" value="${temp.id}" required maxLength="12" readOnly>
		<span id="id_message"></span>

		<b>비밀번호</b><input type="password" name="password" placeholder="Enter password" required>${id}${temp.nickname}

		<b>닉네임</b><input type="text" name="nickname" maxLength="10" value="${temp.nickname}" required>
		<span id="nickname_message"></span>

		<div class="phone">
		전화번호<br>
     	<input type="text" name="tel" maxlength="13" value="${temp.tel}" required> 
     	<span id="tel_message"></span>
        </div><br>
		
		<b>사용자 구분</b>
		<input type="radio" id="user" name=user_grant value="0" onchange="setDisplay()" checked readonly>일반 사용자
		<input type="radio" id="hotel" name=user_grant value="1" onchange="setDisplay()" readonly>호텔 사용자
		<br><br>
		
		<div id="usercheck">
	    <b>반려동물 구분</b>
	    <select name="kind">
	      <option value="dog">강아지</option>
	      <option value="cat">고양이</option>
	    </select><br><br>
   
		 <b>반려동물 무게(kg)</b>
	 	 <input type="text" id="kg" name="kg"  maxLength="5" value="${temp.kg}">
	 	 <span id="animal_message"></span>
	   	 <b></b>
		</div>
		
		<div class="clearfix">
			<button type="submit" class="submitbtn">완료</button>
			<button type="reset" class="cancelbtn">취소 </button>
		</div>
		</form>
</body>
</html>
