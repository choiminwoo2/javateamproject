<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>회원관리 시스템(회원 상세 보기)</title>
<style>
	tr>td:nth-child(odd) {font-weight: bold}
	td{text-align:center}
	.contaienr{width:50%}
#u1 { 
		text-decoration:none;
		
}

#d1 {
	width:100%;
	text-align:center;
	font-size:18px;
}
	.w-25 {
		text-align:center;
		
	}
	.a1, .a2{
		height:30px;
	}
	tr {
		height:70px;
	}
	tr> th {
		height:5px;
	}
	table {
		width:400px;
	}
</style>
</head>
<body>
 <jsp:include page="../template/nav.jsp"/>
	<div class="container">
	<br>
		<h3 style="font-weight: bold" align="center">회원 상세 정보</h3>
		<br>
		<div class="table-responsive">
		<table class="table table-hover table-sm">
		<tbody>
			<tr class="a1">
				<td colspan="2" class="table-primary w-25">　</td>
			</tr>
			<tr height="1">
				<td>아이디</td>
				<td>${userinfo.id}</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td>${userinfo.nickname}</td>
			<tr>
				<td>전화번호</td>
				<td>${userinfo.tel}</td>
			</tr>
			<tr>
				<td>사용자 구분</td>
				<td>${userinfo.user_grantView}</td>
			</tr>
			<c:if test='${userinfo.user_grantView=="일반 사용자"}'> 
			<tr>
				<td>반려동물 종류</td>
				<td>${animalinfo.kind}</td>
			</tr>
			<tr>
				<td>반려동물 무게</td>
				<td>${animalinfo.kg}</td>
			</tr>
			</c:if>
			<tr>
				<td>가입날짜</td>
				<td>${userinfo.regdate}</td>
			</tr>
			<tr class="a2">
				<td colspan="2" class="table-primary w-25">　</td>
			</tr>
		</tbody>
	</table>
</div>
<br><br>
<div id="d1">
<a id="u1" href="userList.co">리스트로 돌아가기</a>
</div>
	</div>
		<br><br><br><br>
	 <jsp:include page="../template/footer.jsp"/>
</body>
</html>