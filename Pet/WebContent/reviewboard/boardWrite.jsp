<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>리뷰 작성페이지</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
<link href="star/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
  <jsp:include page="../template/nav.jsp"/>
  <script src="js/bootstrap.js"></script> 
<!-- <script src="js/jquery-3.6.0.js"></script> -->
<script src="star/js/star-rating.js"></script>
 
  <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 -->
<style>
h1{font-size:2em; text-align:center; color:#1a92b9}
label{font-size:1.2em;font-weight:bold}
</style>

</head>
<body>
<div class="container">
<form action="BoardAddAction.bo" method="post"  name="boardform">

   <h1>이용후기를 작성해주세요.</h1>
   <div class="form-group">
   <label for="board_name">글쓴이</label>
   <input name="rb_id" id="board_name" value="${temp.nickname}" readOnly
          type="text"       class="form-control">
   </div>

   <hr>
   <label>&nbsp;이용은 만족하셨나요?</label>
   <jsp:include page="../NewFile2.jsp"/>
  <!--  <input name="rating" id="rating-system" type="text" class="rating rating-loading" data-size="xs"> -->
   <hr>

<label>&nbsp;반려동물 신체정보</label>
<br>
  ▶반려동물 종류&nbsp;&nbsp;&nbsp;
  <div class="btn-group">
    <button type="button" class="btn btn-primary" >강아지</button>
    <button type="button" class="btn btn-light">고양이</button>
    <input type="hidden" name="animal_info"  id="animal_info" value="강아지">
  </div>
  <br><br>
    <div class="form-group">
  ▶몸무게&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden">
<input name="weight" type="text" placeholder="KG" pattern="[0-9]{1,2}" required>
</div>
<br>

    <div class="form-group">
   <label for="board_subject">제목</label>
   <input name="rb_title" id="board_subject" type="text" maxlength="100" 
          class="form-control" placeholder="제목을 적어주세요" required>
   </div>

     <div class="form-group">
   <label for="board_content">내용</label>
   <textarea name="rb_text" id="board_content" rows="10"
          class="form-control" required></textarea>
   </div>
   
   <input type="hidden" name="hotel_no" value="${hotel_no}">

   <div class="form-group">
   <button type=submit class="btn btn-primary">등록</button>
   <button type=reset class="btn btn-danger" onClick="history.go(-1)">취소</button>
   </div> 
   </form>
</div>
<script>
$('.btn-group > button').click(function(){
	$(this).addClass('btn-primary').removeClass('btn-light');
	$('.btn-group > button').not(this).addClass('btn-light').removeClass('btn-primary');
	$('#animal_info').val($(this).text())
})
</script>
</body>
</html>