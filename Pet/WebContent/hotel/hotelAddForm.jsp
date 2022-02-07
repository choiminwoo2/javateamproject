<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호텔 등록 페이지</title>
   <link rel="stylesheet" href="css/hoteladd.css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<jsp:include page="../template/nav.jsp"/>
	 <section class="section-form-container">
          <div class="joinform-container">
        <form action="hotelAddOk.net" method="post" enctype="multipart/form-data">
                <h3>당신의 호텔을 등록하세요.</h3>
                <label for ="">호텔명</label>
                <input class="form-control" id="hotel_name" name="hotel_name" type="text" placeholder="호텔명">
                <label for ="">1박 기준 호텔 이용 요금</label>
                <div class="weight-grid">
                    <input class="form-control " name="hotel_weight_5lt" type="text" placeholder="5kg 미만">
                    <input class="form-control " name="hotel_weight_5ge8lt" type="text" placeholder="5kg이상 8kg미만">
                    <input class="form-control " name="hotel_weight_8ge12lt" type="text" placeholder="8kg 이상 12kg미만">
                    <input class="form-control " name="hotel_weight_12ge" type="text" placeholder="12kg 이상">
                </div>
                <label for ="">전화번호</label>
                <input class="form-control " name="hotel_tel" type="text" placeholder="호텔명">
                <label>호텔을 이용가능한 반려동물</label><br>
                <input type="checkbox" value="0" name="animal"> 강아지
                <input type="checkbox" value="1" name="animal"> 고양이
                <div class="post-grid">
                    <label for="post1">우편번호</label>
                    <input type="button" value="검색" id="postbtn" class="btn btn-primary align-center btn-sm mr-1">
                </div>
                <div class="post-flex">
                    <input type="text" class="form-control"  maxlength="5" name="post1" id="post1" placeholder="우편번호">
                    <input type="text" class="form-control" name="post1" id="address" placeholder="주소">
                </div>
                <input type="text" class="form-control" name="post1" id="addressdetail" placeholder="상세주소">
                <div class="file-container">
                    <div>
                        <label for="mainfile">호텔프로필사진
                        <img src="attach.png" alt="사진을 찾아주세요">
                        </label>
                        <input type="file" name="hotel_file" id="mainfile">
                    </div>
                    <input type="submit" value="다음으로" id="postbtn" class="btn btn-primary align-center btn-lg">
                </div>
            

        </form>
        </div>
      </section>
      <script src="js/hoteladd.js"></script>
</body>
</html>