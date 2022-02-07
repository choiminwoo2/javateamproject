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

</head>
<body data-spy="scroll" data-target="#navbar1" data-offset="60">
       <jsp:include page="../template/nav.jsp"/>
       <br><br><br><br>
       
   	<div align="center">
		<form name="deleteform" method="post">
			<table>
				<tr>
					<td>회원아이디</td>
					<td><input type="text" name="id" value="${temp.id}" readonly="readonly"/></td>
				</tr>
			
			</table>
					<div class="clearfix">
			<input type="button" class="submitbtn" id="btnDelete" value="회원 탈퇴">
			<button type="reset" class="cancelbtn" >취소 </button>
		</div>	
		</form>
	</div>
   	
  		<br><br><br><br><br><br><br><br><br><br>
      <jsp:include page="../template/footer.jsp"/>
  
    
    
    
</body>
</html>
