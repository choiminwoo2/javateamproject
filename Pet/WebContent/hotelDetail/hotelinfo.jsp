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
  <link rel="icon" href="/favicon.ico">
<title>호텔 상세 페이지</title>
<jsp:include page="../template/nav.jsp"/>
<style>
.info_main {
  max-width: 100%;
  height:auto;
  margin-top: 14vh;
  
} 
.container {
  position: relative;
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

#price tr:nth-child(even){background-color: #f2f2f2;}

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




</style>
</head>
<body>
<div class="container">
<div class="info_main">
<img src="hotelDetail/image/test2.jpg" alt="호텔메인사진" width="100%" height="200px">


</div>

<button type="button" class="btn btn-outline-danger" style="
    position: absolute;
    right: 30px;
    top: 0px;
    background: white;">    
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"></path>
</svg><br>찜하기</button>

<hr>
<p>${hotelinfo.hotel_name}</p>
<a href="${hotelinfo.hi_url}">호텔 예약하기(링크이동)</a>
<button type="button" class="btn btn-primary mr-1 review" style="position: absolute;
    right: 30px; top:250px" >이용 후기</button>
<hr>

<table id="price">
  <tr>
    <th>몸무게</th>
    <th>호텔 이용요금</th>
  </tr>
  <tr>
    <td>~5kg</td>
    <td>가격</td>
  </tr>
  <tr>
    <td>~10kg</td>
    <td>가격</td>
  </tr>
 
</table>

<div class="form-group">
   <label for="hi_intro"></label>
   <textarea name="hi_intro" id="hi_intro" rows="10"
          class="form-control">${hotelinfo.hi_intro}</textarea>
   </div>
  
   <div class="gallery">
  <img class="img1" src="hotelDetail/image/test2.jpg" alt="호텔사진1" width="60%" height="300" >
<img class="img2" src="hotelDetail/image/test2.jpg" alt="호텔사진2" width="30%" height="300">
<br>
<br>
<img class="img3" src="hotelDetail/image/test2.jpg" alt="호텔사진3" width="30%" height="300">

<img class="img4" src="hotelDetail/image/test2.jpg" alt="호텔사진4" width="60%" height="300">
</div>

</div>
<%-- <jsp:include page="template/footer.jsp"/> --%>
<script> /* 주소: http://localhost:8088/Pet/BoardList.bo?hotel_no=1&hotel_name=%EC%9A%B0%EB%A6%AC%ED%98%B8%ED%85%941 */
$("button.review").click(function(){
	location.href="BoardList.bo?hotel_no=${hotelinfo.hi_no}&hotel_name=${hotelinfo.hotel_name}";
})
</script>
</body>
</html>