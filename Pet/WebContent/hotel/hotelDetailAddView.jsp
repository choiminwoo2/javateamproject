<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/hoteladddetail.css">
</head>
<body>
	<jsp:include page="../template/nav.jsp"/>
	     <section class="content-container">
        <div class="add-detail-form-container">
          <form>
          <div class="add-detail-file-container">
            <div class="file-inner-container">
              <label for="fileinput">
              <h4 class="before_file">클릭해서 사진을 등록해주세요</h4>
              <div class="file-grid-container">
                <input type='file' id="fileinput" name='' multiple/>
                <div class="inline-gap"></div>
                <img src="./img/image.png">
                <img src="./img/image.png">
                <img src="./img/image.png">
                <img src="./img/image.png">
                <img src="./img/image.png">
                <img src="./img/image.png">
                <img src="./img/image.png">
                <img src="./img/image.png">
              </div>
            </label>
              <div class="description-form">
                <p>사진 등록시 주의 사항</p>
                <p>1.사진을 순서에 맞춰 등록해주세요.</p>
                <p>2.사용자에게 보이는 호텔 내부 사진을 등록해주세요.</p>
              </div>
              <input type="submit" value="다음으로" id="filelistbtn" class="btn btn-primary btn-lg">
              
            </div>

              
          </div>
        </form>
        </div>
     </section>
</body>
</html>