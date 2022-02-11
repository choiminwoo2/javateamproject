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
<title>회원탈퇴 비밀번호 확인</title>
<style>
.main {
		display:block;
		width:40%;
		margin-left:30%;
		margin-right:30%;
		
	}
	
.clear {
		float:right;
	}		

tr {
		height:60px;
	}
	
.f1 {
		width:50% important!;
	}

td:nth-child(1) {
	width: 30%
}
</style>
</head>

<body data-spy="scroll" data-target="#navbar1" data-offset="60">
       <jsp:include page="../template/nav.jsp"/> 
       <br><br><br><br>
       
     <div class="main">
    	 <form name="deleteformcheck" action="userdeletecheckprocess.co" method="post">
			<input type="hidden" name="id" value="${temp.id}"/>
			<div class="form-group row">
		
			
			
			 <div class="table-responsive">
			<table class="table table-hover table-sm">
				<tr>
					<td id="t1">아이디</td>
					<td>${temp.id}</td>
				</tr>
				<tr>
					<td id="t2">비밀번호</td>
					<td><input type="password" name="password" class="form-control f1" placeholder="Enter Password" size="10" required></td>
			
			</table>
				<div class="clear">
					<input type="submit" class="btn btn-primary mr-2 submitbtn" value="확인">
					<button type="reset" class="btn btn-outline-secondary mr-2 cancelbtn" >취소 </button>
				</div>
			</div>	
	
	
		</div>
		</form>
	</div>
    
   
  		<br><br><br><br><br><br><br><br><br><br>
      <jsp:include page="../template/footer.jsp"/>
  
</body>
</html>