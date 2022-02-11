<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--  <link href="css/theme.css" rel="stylesheet"> -->
<!--  <link href="css/template.css" rel="stylesheet"> -->
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <!-- <script src="js/bootstrap.js"></script> -->
 <!--  <link rel="icon" href="/favicon.ico"> -->
<title>호텔 상세 페이지</title>
<jsp:include page="../template/nav.jsp"/>
<style>
.info_main {
  max-width: 100%;
  margin-top: 5vh;
  border:1px solid #e3dfdf;
  
} 
.container {
  position: relative;
}

.info_second{
line-height: 1.3;
font-family: sans-serif;
}


#price {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  text-align: center;
}

#price td, #price th {
  border: 1px solid #ddd;
  padding: 8px;
  
}

#price tr:nth-child(even){background-color: #f2f2f2;}/*even:짝수,odd:홀수*/

#price th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #07689F;
  color: white;
}

div.gallery {
  margin: 55px;
  width: 100%;

}

div.gallery>img{border:1px solid #e3dfdf;}

textarea{
    resize:none;/* 크기고정 */ 
}

#liner { 
	text-decoration:none 
} 
</style>
</head>
<body>
<div class="container">

<div class="info_main">
<img src="hotel/img/${img}" alt="호텔메인사진" width="100%" height="400px">
</div>

<c:if test='${temp.user_grant==0}'>
<button type="button" class="btn btn-outline-danger" id="jjim"
	style="
	position: absolute;
    right: 30px;
    top: 0px;
    background: white;">
    
  <!--  0일때 -->
  <c:if test="${empty wish}">
    <a id="liner" href="javascript:add(${hotelinfo.hi_no},${temp.user_no})"><span>찜하기</span>   
     <img src="hotel/img/jjimheartbefore.png" width="18" height="17" style="position: relative; top: -3px;" >
    </a> 
    </c:if>
     <c:if test="${!empty wish}">
   <!--  1이상 -->
    <a id="liner" href="javascript:del(${wish.wish_no})"><span>찜해제</span>  
    <img src="hotel/img/jjimheartafter.png" width="18" height="17" style="position: relative; top: -3px;" ></a> 
    </c:if>
</button>
</c:if>

<hr>
<div class="info_second">
<h4>${hotel_name} ( ${hotelinfo.hotel_addr}${hotelinfo.hotel_addr_detail} )</h4>
<p>tel: ${hotelinfo.hotel_tel}</p>
<a href="${hotelinfo.hi_url}">호텔 예약하기(링크이동)</a>
</div>

<button type="button" class="btn btn-primary mr-1 review" style="position: absolute;
    right: 30px; top:450px" >이용 후기</button>
<hr>

<table id="price">
  <tr>
    <th>몸무게</th>
    <th>호텔 이용요금</th>
  </tr>
  <tr>
    <td>~5kg</td>
    <td>${hotelinfo.hotel_price_5lt}</td>
  </tr>
  <tr>
    <td>5~8kg</td>
    <td>${hotelinfo.hotel_price_5ge8lt}</td>
  </tr>
  <tr>
    <td>8~12kg</td>
    <td>${hotelinfo.hotel_price_8ge12lt}</td>
  </tr>
    <tr>
    <td>12kg~</td>
    <td>${hotelinfo.hotel_price_12gt}</td>
  </tr>
 
</table>

<div class="form-group"> 
   <label for="hi_intro"></label>
   <textarea name="hi_intro" id="hi_intro" rows="10"
          class="form-control" style="background:white;" readOnly>${hotelinfo.hi_intro}</textarea>
   </div> 
  
   <div class="gallery">
  <img class="img1" src='hotel/img/${hi_photofiles.split(",")[0]}' alt="호텔사진1" width="60%" height="300" >
<img class="img2" src='hotel/img/${hi_photofiles.split(",")[1]}' alt="호텔사진2" width="30%" height="300">
<br>
<br>
<img class="img3" src='hotel/img/${hi_photofiles.split(",")[2]}' alt="호텔사진3" width="30%" height="300">

<img class="img4" src='hotel/img/${hi_photofiles.split(",")[3]}' alt="호텔사진4" width="60%" height="300">
</div>

</div>
<%-- <jsp:include page="template/footer.jsp"/> --%>
<script>
$("button.review").click(function(){
	//location.href="BoardList.bo?hotel_no=${hotelinfo.hi_no}&hotel_name=${hotelinfo.hotel_name}&img=${hotelinfo.hotel_photofile}"; (주소가 길어져서 세션에 담았음)
	location.href="BoardList.bo";
})

function add(hi_no, user_no) {
	$.ajax({
		url:'jjim.co',
		data:{hotel_no:hi_no,user_no:user_no},
		success:function(rdata){
			console.log("찜등록 성공");
			$("#liner > img").attr("src","hotel/img/jjimheartafter.png");
			$("#liner > span").text("찜해제");
			$("#liner").attr("href","javascript:del("+rdata+")");
		}
	})
}


function del(wish_no) {
	$.ajax({
		url:'jjim_del.co',
		data:{wish_no:wish_no},
		success:function(rdata){
			console.log("찜해제");
			$("#liner > img").attr("src","hotel/img/jjimheartbefore.png");
			$("#liner > span").text("찜하기");
			$("#liner").attr("href","javascript:add(${hotelinfo.hi_no},${temp.user_no})");
		}
	})
}
</script>
</body>
</html>