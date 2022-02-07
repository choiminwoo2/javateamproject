<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>리뷰 상세페이지</title>
<!-- <script src="js/view.js"></script> -->
<link rel="stylesheet" href="css/view.css">
<jsp:include page="../template/nav.jsp"/>
 <script src="js/bootstrap.js"></script>
</head>
<body>
<input type="hidden" id="loginid" value="${id}" name="loginid">
<div class="container">
<table class="table">
<tr>
<th colspan="2">리뷰 상세페이지</th>
</tr>
<tr>
<td><div>글쓴이</div></td>
<td><div>${review.rb_id}</div></td>
</tr>
<tr>
<td><div>제목</div></td>
<td><c:out value="${review.rb_title}" /></td>
</tr>
<tr>
<td><div>내용</div></td>
<td style="padding-right:0px">
<textarea class="form-control"
          rows="5" readOnly>${review.rb_text}</textarea></td>
</tr>


<tr>
<td colspan="2" class="center">
<c:if test="${review.rb_id == temp.nickname || id == 'admin' }">
<a href="BoardModifyView.bo?num=${review.review_no}">
<button class="btn btn-info">수정</button>
</a>
<%--href의 주소를 #으로 설정합니다. --%>
<a href="#">
<button class="btn btn-danger" data-toggle="modal"
   data-target="#myModal">삭제</button>
   </a>
   </c:if>
   <a href="BoardList.bo?hotel_no=${review.hotel_no}&hotel_name=${param.hotel_name}">
   <button class="btn btn-warning">목록</button>
   </a>

   </td>
   </tr>
</table>
<%--게시판 view end --%>




</div>

</body>
</html>