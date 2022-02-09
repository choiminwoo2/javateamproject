<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호텔 등록 페이지</title>
   <link rel="stylesheet" href="css/hoteladd.css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style type="text/css">
	.hidden{
		display:none;
	}
	.show{
		display:block;
	}
	
</style>
</head>
<body>
	<jsp:include page="../template/nav.jsp"/>
	 <section class="section-form-container">
          <div class="joinform-container">
        <form action="hotelAddOk.net" method="post" enctype="multipart/form-data">
                <h3>당신의 호텔을 등록하세요.</h3>
                <label for="hotel_name">호텔명</label>
                <input class="form-control" id="hotel_name" name="hotel_name" type="text" placeholder="호텔명 20글자 이하">
                <span class="nameinput hidden"></span>
                <label for ="">1박 기준 호텔 이용 요금</label>
                <div class="weight-grid">
                    <input class="form-control " name="hotel_weight_5lt" type="text" placeholder="5kg 미만 최소 10000이상, 최대 100만 미만">
                    <input class="form-control " name="hotel_weight_5ge8lt" type="text" placeholder="5kg이상 8kg미만 최소 10000이상, 최대 100만 미만">
                    <input class="form-control " name="hotel_weight_8ge12lt" type="text" placeholder="8kg 이상 12kg미만 최소 10000이상, 최대 100만 미만">
                    <input class="form-control " name="hotel_weight_12ge" type="text" placeholder="12kg 이상 최소 10000이상, 최대 100만 미만">
                    <span class="weight-span hidden">해당 가격을 확인해주세요.</span>
                </div>
                <label for ="">전화번호</label>
                <input class="form-control hotel_tel" name="hotel_tel" type="text" placeholder="호텔의 전화번호를 입력해주세요. ex) 02-515-9999">
                <span class="tel-span hidden">전화번호를 다시 입력해주세요.</span>
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
                <span class="detail-span hidden">상세 주소를 다시 입력해주세요</span>
                <div class="file-container">
                    <div>
                        <label for="mainfile">호텔프로필사진
                        <img src="hotel/img/attach.png" style="hieght:25px; width:25px;" alt="사진을 찾아주세요">
                        </label>
                        <input type="file" name="hotel_file" id="mainfile">
                        <span class="file_span hidden">사진을 추가해주세요.</span>
                    </div>
                    <input type="submit" value="다음으로" id="postbtn" class="btn btn-primary align-center btn-lg">
                </div>
            

        </form>
        </div>
      </section>
      <script src="js/hoteladd.js"></script>
</body>
</html>