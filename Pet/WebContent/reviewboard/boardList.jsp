<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
select.form-control{
width:auto; margin-bottom:2em; display:inline-block
}
.rows{text-align:right;}
.gray{color:gray}
body > div > table > thead > tr:nth-child(2) > th:nth-child(1){width:8%}
body > div > table > thead > tr:nth-child(2) > th:nth-child(2){width:50%}
body > div > table > thead > tr:nth-child(2) > th:nth-child(3){width:14%}
body > div > table > thead > tr:nth-child(2) > th:nth-child(4){width:17%}
body > div > table > thead > tr:nth-child(2) > th:nth-child(5){width:11%}
</style>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="../js/list.js"></script>
<title>이용후기 게시판</title>
</head>
<body>
<div class="container">
<%--게시글이 있는 경우 --%>
<c:if test="${listcount > 0 }">

<h1 style="text-align:center">이용후기 게시판</h1>
<table class="table table-striped">
<thead>
<tr>
<!-- <th colspan="3">이용후기 게시판 </th> -->
<th>
<font size=3 style="text-align:right">글 개수 : ${listcount}</font>
</th>
</tr>
<tr>
<th><div>번호</div></th>
<th><div>제목</div></th>
<th><div>작성자</div></th>
<th><div>날짜</div></th>
</tr>
</thead>
<tbody>
<c:set var="num" value="${listcount-(page-1)*limit}"/>
<c:forEach var="b" items="${boardlist}">
<tr>
<td><%--번호 --%>
<c:out value="${num}"/><%--num출력 --%>
<c:set var="num" value="${num-1}"/> <%--num=num-1; 의미 --%>
</td>
<td><%--제목 --%>
<div>
  <%--답변글 제목앞에 여백 처리 부분 
        board_re_lev, board_num,
        board_subject, board_name, board_date,
        board_readcount : property 이름
        --%>

   
   <a href="BoardDetailAction.bo?num=${b.review_no}">
   <c:out value="${b.rb_title}"/>
   </a>  
</div>
</td>
<td><div>${b.rb_id}</div></td>
<td><div>${b.rb_date}</div></td>
</tr>
</c:forEach>
</tbody>
</table>

<div class="center-block">
<ul class="pagination justify-content-center">
<c:if test="${page <= 1}">
<li class="page-item">
<a class="page-link gray">이전&nbsp;</a>
</li>
</c:if>
<c:if test="${page > 1 }">
<li class="page-item">
<a href="BoardList.bo?page=${page-1}"
class="page-link">이전&nbsp;</a>
</li>
</c:if>

<c:forEach var="a" begin="${startpage}" end="${endpage}">
<c:if test="${a == page}">
<li class="page-item active">
<a class="page-link">${a}</a>
</li>
</c:if>
<c:if test="${a != page }">
<li class="page-item">
<a href="BoardList.bo?page=${a}"
   class="page-link">${a}</a>
   </li>
   </c:if>
   </c:forEach>
   
   <c:if test="${page >= maxpage }">
   <li class="page-item">
   <a class="page-link gray">&nbsp;다음</a>
   </li>
   </c:if>
   <c:if test="${page < maxpage }">
   <li class="page-item">
   <a href="BoardList.bo?page=${page+1}"
      class="page-link">&nbsp;다음</a>
</li>
</c:if>   
</ul>
</div>
</c:if><%--<c:if test="${listcount > 0 }"> end --%>

<%--게시글이 없는 경우 --%>
<c:if test="${listcount == 0 }">
<font size=5>등록된 글이 없습니다.</font>
</c:if>

<button type="button" class="btn btn-info float-right">글 쓰 기</button>
</div>
</body>
</html>