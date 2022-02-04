<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="../css/hotelcontentadd.css">
</head>
<body>	
	<jsp:include page="../template/nav.jsp"/>
 	<section class="content-container">
        <div class="add-detail-form-container">
          <form>
          <div class="add-detail-content-container">
            <div class="content-inner-container">
                <h4>사용자에게 제공할 상세정보</h4>
                <input type="text" class="form-control" placeholder="호텔 링크주소 ex)https://hotelsdot.com">
                <textarea class="content-text" id="content-text" placeholder="호텔의 소개와 설명을 적어주세요."></textarea>

              
            </div>
            <div class="flex-btn">
              <input type="submit" value="호텔 등록" id="filelistbtn" class="btn btn-primary btn-lg">
            </div>

              
          </div>
        </form>
        </div>
     </section>
</body>
</html>