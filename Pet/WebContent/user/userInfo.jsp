<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
<style>
	tr>td:nth-child(odd) {font-weight: bold}
	td{text-align:center}
	.contaienr{width:50%}
</style>
</head>
<body>
 <jsp:include page="../template/nav.jsp"/>
	<div class="container">
	<br><br><br><br>
		<h3 style="font-weight: bold" align="center">&lt; 회원 상세 정보 &gt;</h3>
		<br>
		<table class="table table-bordered">
		<tr>
				<td>아이디</td>
				<td>${userinfo.id}</td><%-- Member클래스의 getId()메서드 호출 --%>
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
			<tr>
				<td colspan=2>
				<a href="userList.co">리스트로 돌아가기</a></td>
			</tr>
		</table>
	</div>
		<br><br><br><br>
	 <jsp:include page="../template/footer.jsp"/>
</body>
</html>