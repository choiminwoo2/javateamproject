<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="scripts.js"></script>

<title>회원관리 시스템 관리자모드(회원목록 보기)</title>
<style>
table caption {
	caption-side: top;
	text-align: center
}

h1 {
	text-align: center
}

li .gray {
	color: gray;
}

body>div>table>tbody>tr>td:last-child>a {
	color: white;
}

form {
	margin: 0 auto;
	width: 80%;
	text-align: center
}

select {
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: .25rem;
	transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
	outline: none;
}
.container {
	width: 60%
}
td:nth-child(1) {
	width: 20%
}
td:nth-child(2) {
	width: 20%
}
td:nth-child(3) {
	width: 25%
}
td:nth-child(4) {
	width: 25%
}
td:nth-child(5) {
	width: 10%
}
.input-group {
	margin-bottom: 3em
}
</style>
<script>
$(document).ready(function() {
	$(".listdel").click(function(event) {
		var answer= confirm("정말 삭제 하시겠습니까?");
		console.log(answer); 
		if (!answer) { 		
			event.preventDefault();
		}
	});
});
</script>
</head>
  <body>
   <jsp:include page="../template/nav.jsp"/>
	<div class="container">
		<c:if test="${listcount > 0 }">
		<br><br><br>
		<form name="deleteform" method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<th colspan="4"> 회원 목록</th>
						<th><font size="3">회원수: ${listcount}명</font></th>
					</tr>
					<tr>
						<td>아이디</td>
						<td>호텔 번호</td>
						<td>사용자 번호</td>
						<td>전화번호</td>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="temp" items="${totallist}">
						<tr>
							<td><a href="userInfo.co?id=${temp.id}&user_no=${temp.user_no}">${temp.id}</a></td>
							<td>${temp.nickname}</td>
							<td>${temp.user_no}</td>
							<td>${temp.tel}</td>
							
						</tr>
					</c:forEach>	
				</tbody>	
			</table>
			</form>
			<div>
				<ul class="pagination justify-content-center">
					<c:if test="${page <= 1 }">
						<li class="page-item">
							<a class="page-link gray">이전&nbsp;</a>
						</li>
					</c:if>
					<c:if test="${page >1 }">
						<li class="page-item"> 
							<a href="userList.co?page=${page-1}" class="page-link">이전</a>&nbsp;				
						</li>
					</c:if>
					
					<c:forEach var="a" begin="${startpage}" end="${endpage}">
						<c:if test="${a == page}">
							<li class="page-item active">
								<a class="page-link">${a}</a>
							</li>
						</c:if>
						<c:if test="${a != page}">
							<c:url var="go" value="userList.co">
								<c:param name="page" value="${a}"/>
							</c:url>
							<li class="page-item">
								<a href="${go}" class="page-link">${a}</a>
							</li>
						</c:if>
					</c:forEach>
					
					<c:if test="${page >= maxpage }">
						<li class="page-item">
							<a class="page-link gray">&nbsp;다음</a>
						</li>
					</c:if>
					<c:if test="${page < maxpage}">
						<c:url var="next" value="userList.co">
							<c:param name="page"         value="${page+1}" />
						</c:url>
						<li class="page-item">
							<a href="${next}" class="page-link">&nbsp;다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
		
	</div>
	
 	<br><br><br>
	<c:if test="${listcount == 0}">
		<h1>회원이 없습니다.</h1>
		<br><br><br>
	</c:if>
	<br><br><br><br><br>
	  <jsp:include page="../template/footer.jsp"/>
</body>
</html>