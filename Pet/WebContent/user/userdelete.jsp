<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/user_delete.js"></script>
<script src="scripts.js"></script>
    <link href="css/theme.css" type="text/css" rel="stylesheet">
<title>회원 탈퇴</title>
<style>
.main {
		
		margin:0 auto;
		width:80%;
		margin-left:30%;
		margin-right:10%;
	}
		
.del {
	margin-top:5%;
	margin-right:25%;
	width:30%;
}	

p {
	font-size:18px;
}	
</style>
</head>
<body data-spy="scroll" data-target="#navbar1" data-offset="60">
       <jsp:include page="../template/nav.jsp"/>
       <br><br><br><br>
      <div class="main" align="center">
       <div class="cotent" align="left">
        <h2 align="left">회원 탈퇴</h2>
        <hr align="left" width="900px">
        <br>
        <p>회원 탈퇴후 재가입이 가능합니다</p>
		<br><br>
		<p>내가 작성한 게시물은 삭제되지 않습니다.</p>
		<br><br>
		</div>  
   	<div class="del" align="right">
		<form name="deleteform" method="post">
			<input type="hidden" name="id" value="${temp.id}"/>
			<div class="form-group row">
			<label class="col-lg-2 col-form-label form-control-label"></label>
			<div class="col-lg-10">
			<div class="clearfix">
			<input type="button" class="btn btn-primary mr-2 submitbtn" id="btnDelete" value="회원 탈퇴">
			<button type="reset" class="btn btn-outline-secondary mr-2 cancelbtn" >취소 </button>
		</div>	
		</div>
		</div>
		</form>
	</div>
   	</div>
  		<br><br><br><br><br><br><br><br><br><br>
      <jsp:include page="../template/footer.jsp"/>
  
    
    
    
</body>
</html>