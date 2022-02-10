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
<td><div>${temp.nickname}</div></td>
</tr>
<tr>
<td><div>별점</div></td>
<td><div>${review.ev_score}</div></td>
</tr>
<tr>
<td><div>반려동물 종류/무게(kg)</div></td>
<td><div>${review.animal_info}</div></td>
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
<a href="BoardModifyView.bo?review_no=${review.review_no}">
<button class="btn btn-info">수정</button>
</a>
<%--href의 주소를 #으로 설정합니다. --%>
<a href="#">
<button class="btn btn-danger" data-toggle="modal"
   data-target="#myModal">삭제</button>
   </a>
   </c:if>
   <a href="BoardList.bo?hotel_no=${review.hotel_no}">
   <button class="btn btn-warning">목록</button>
   </a>

   </td>
   </tr>
</table>
<%--게시판 view end --%>
<%--modal 시작 --%>
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

 			<div class="modal-header">
		          <h6 class="modal-title">리뷰 삭제</h6>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
        	</div>

<%-- Modal body --%>

 <form name="deleteForm" action="BoardDeleteAction.bo" method="post">
<%--http://localhost:8088/Board/BoardDetailAction.bo?num=22
    주소를 보면 num을 파라미터로 넘기고 있습니다.
    이 값을 가져와서 ${param.num}를 사용
    또는 ${boarddata.board_num}
     --%>
     <input type="hidden" name="review_no" value="${review.review_no}" >
     <div class="modal-body">
	     <div style="text-align:center;font-weight:bold;font-size:1.5rem;color:#686666">
	       <label >정말 삭제하시겠습니까?</label>
	     </div>
     </div>
      <div class="modal-footer">
	      <div>
		     <button type="submit" class="btn btn-primary">확인</button>
		     <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
		</div>
	</div>
</form>
</div>
</div>
</div>
</div>


</div>

</body>
</html>