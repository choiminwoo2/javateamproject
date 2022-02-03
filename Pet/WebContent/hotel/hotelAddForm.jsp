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
                <input class="form-control" id="hotel_name" type="text" placeholder="호텔명">
                <label for ="">1박 기준 호텔 이용 요금</label>
                <div class="weight-grid">
                    <input class="form-control " type="text" placeholder="5kg 미만">
                    <input class="form-control " type="text" placeholder="5kg이상 8kg미만">
                    <input class="form-control " type="text" placeholder="8kg 이상 12kg미만">
                    <input class="form-control " type="text" placeholder="12kg 이상">
                </div>
                <label for ="">전화번호</label>
                <input class="form-control " type="text" placeholder="호텔명">
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
                        <input type="file" name="filelist" id="mainfile">
                    </div>
                    <input type="submit" value="다음으로" id="postbtn" class="btn btn-primary align-center btn-lg">
                </div>
            
            

        </form>
        </div>
      </section>
      <jsp:include page="../template/footer.jsp"/>
      <script src="js/hoteladd.js"></script>
</body>
</html>