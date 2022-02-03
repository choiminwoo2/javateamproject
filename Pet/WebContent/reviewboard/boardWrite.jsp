<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.6.0.js"></script>
<script src="js/star-rating.js"></script>
<style>
h1{font-size:1.5em; text-align:center; color:#1a92b9}
.container{width:60%}
label{font-weight:bold}
#upfile{display:none}
img{width:20px;}


</style>

</head>
<body>
<div class="container">
<form action="BoardAddAction.bo" method="post"  name="boardform">
<!--    method="post" enctype="multipart/form-data"는 파일업로드할때 필수 -->
   <h1>이용후기를 작성해주세요.</h1>
   <div class="form-group">
   <label for="board_name">글쓴이</label><%--수정해야함 --%>
   <input name="board_name" id="board_name" value="admin" readOnly
          type="text"       class="form-control"
          placeholder="Enter board_name">
   </div>

    <div class="form-group">
   <label for="board_subject">제목</label>
   <input name="board_subject" id="board_subject" type="text" maxlength="100" 
          class="form-control" placeholder="Enter board_subject">
   </div>
   
   <jsp:include page="../NewFile2.jsp"/>
  <!--  <input name="rating" id="rating-system" type="text" class="rating rating-loading" data-size="xs"> -->
   
     <div class="form-group">
   <label for="board_content">내용</label>
   <textarea name="board_content" id="board_content" rows="10"
          class="form-control"></textarea>
   </div>
   
   <input type="hidden" name="hotel_no" value="">

   <div class="form-group">
   <button type=submit class="btn btn-primary">등록</button>
   <button type=reset class="btn btn-danger">취소</button>
   </div> 
   </form>
</div>
</body>
</html>