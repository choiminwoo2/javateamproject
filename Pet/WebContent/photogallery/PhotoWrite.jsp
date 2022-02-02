<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="css/theme.css" rel="stylesheet">
 <link href="css/template.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="js/bootstrap.js"></script>
<title>포토갤러리 작성페이지</title>
<jsp:include page="../template/nav.jsp"/>
<style>
.photo_main {
  max-width: 100%;
  height:auto;
  margin-top: 14vh;
  
} 
.container {
  position: relative;
}
	h1{font-size:1.5rem; text-align:center; color:#07689F}
	label{font-weight:bold}
	#upfile{display:none}

</style>
</head>
<body>
<div class="container">
<div class="photo_main">

</div>

<h1>Photo Gallery</h1>

<hr>
<div class="container">
<form action="PhotoAddAction.bo" method="post" enctype="multipart/form-data"
		name="boardform">
	<div class="form-group">
		<label for="board_name">글쓴이</label>
		<input name="board_name" id="board_name" value="${id}" readOnly
			type="text" class="form-control"
			placeholder="ID or NickName">
	</div>
	<div class="form-group">
		<label for="board_pass">비밀번호</label>
		<input name="board_pass" id="board_pass" type="password" maxlength="30"
			class="form-control" placeholder="Enter board_pass">
	</div>
	<div class="form-group">
		<label for="board_subject">제목</label>
		<input name="board_subject" id="board_subject" type="text" maxlength="100"
			class="form-control" placeholder="제목을 입력하세요">
	</div>
	<div class="form-group">
		<label for="board_content">본문</label>
		<textarea name="board_content" id="board_content"
			rows="10" class="form-control" placeholder="사진을 올리고 본문을 입력하세요"></textarea>
	</div>
	<div class="form-group">
		<label for="board_file"></label>
		<label for="upfile">
			<button type=submit class="btn btn-primary">포토업로드</button>
		</label>
		<input type="file" id="upfile" name="board_file">
		<span id="filevalue"></span>
		<button type=submit class="btn btn-primary, float-right" class=float-right>작성하기</button>
	</div>

	</form>
	</div>

</div>
<%-- <jsp:include page="template/footer.jsp"/> --%>
</body>
</html>