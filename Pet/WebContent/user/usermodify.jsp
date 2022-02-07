<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="scripts.js"></script>
<script src="js/user_modify.js"></script>
<link href="css/join.css" type="text/css" rel="stylesheet">
    <link href="css/theme.css" type="text/css" rel="stylesheet">
      
<title>회원 정보 수정</title>
<script>
$(document).ready(function() {
	var snickname = '${temp.nickname}';

 	$("input:eq(2)").on('keyup',
			function () {
				$("nickname_message").empty(); 
				var pattern = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;
				var nickname = $("input:eq(2)").val();
				if (!pattern.test(nickname)) {
					$("#nickname_message").css('color', 'red').html("닉네임은 한글, 영문, 숫자만 가능하며 2~10자리 가능합니다.");
					checknickname=false;
					return;
				}
				$.ajax({
					url : "nicknamecheck.co",
					data : {"nickname" : nickname},
					success : function(resp) {
						if ($("input:eq(2)").val() == snickname) {
									checknickname=true;
						} else if (resp == -1) { //db에 해당 닉네임이 없는경우
							$("#nickname_message").css('color', 'green').html("사용 가능한 닉네임 입니다.");
							checknickname=true;
						} else { // db에 해당 닉네임이 있는경우 (0)
						
							$("#nickname_message").css('color', 'blue').html("사용중인 닉네임 입니다.");
							checknickname=false;
						}
					}
			})
				
	})//닉네임 중복검사
});	
</script>

</head>
<body>
	<jsp:include page="../template/nav.jsp"/>
	<form name="modifyform" action="usermodifyProcess.co" method="post">
		<h1>회원 정보 수정</h1>
		<hr>
		<b>아이디</b>
		<input type="text"  class="form-control" name="id" value="${temp.id}" required maxLength="12" readOnly>
		<span id="id_message"></span>

		<b>비밀번호</b><input type="password" name="password" placeholder="Enter password" required>

		<b>닉네임</b><input type="text" name="nickname" maxLength="10" value="${temp.nickname}" required>
		<span id="nickname_message"></span>

		<div class="phone">
		전화번호<br>
     	<input type="text" name="tel" maxlength="13" value="${temp.tel}" required> 
     	<span id="tel_message"></span>
        </div><br>
		
		<c:if test="${temp.user_grant==0}">	
		<b>사용자 구분</b>
		<input type="radio" id="user" name=user_grant value="0" onchange="setDisplay()" checked onclick="return(false);">일반 사용자
		<input type="radio" id="hotel" name=user_grant value="1" onchange="setDisplay()" onclick="return(false);">호텔 사용자
		<br><br>
		</c:if>
		
		<c:if test="${temp.user_grant==1}">	
		<b>사용자 구분</b>
		<input type="radio" id="user" name=user_grant value="0" onchange="setDisplay()" onclick="return(false);">일반 사용자
		<input type="radio" id="hotel" name=user_grant value="1" onchange="setDisplay()" checked onclick="return(false);">호텔 사용자
		<br><br>
		</c:if>
		
		<c:if test="${temp.user_grant==0}">	
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
		</c:if>
		
		<div class="clearfix">
			<button type="submit" class="submitbtn">완료</button>
			<button type="reset" class="cancelbtn">취소 </button>
		</div>
		</form>
		<jsp:include page="../template/footer.jsp"/>
</body>
</html>
