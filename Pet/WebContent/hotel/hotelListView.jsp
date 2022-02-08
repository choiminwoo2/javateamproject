<%@page import="vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="css/hotellist.css">
   <style type="text/css">
   	p{
   		margin: 2px 0px !important;
   	}
   	select{
   		font-size: 8px;
   	}
   	.hotellist-grid p{
   		font-size: 16px;
   	}
   </style>
</head>
<body>
<jsp:include page="../template/nav.jsp"/>
 <div class="categori">
        <section class="categori-grid">
            <div class="grid-item">
            <form>
                <ul class="flex-ul-container">
                    <li>몸무게</li>
                    <li><input type="radio" name="weight" id="">5kg미만</li>
                    <li><input type="radio" name="weight" id="">5~8kg미만</li>
                    <li><input type="radio" name="weight" id="">8~12kg미만</li>
                    <li><input type="radio" name="weight" id="">12kg이상</li>
                </ul>
            </div>
            <div class="grid-item">
                <ul class="flex-ul-container">
                    <li>종류</li>
                    <li><input type="radio" name="animal" id="">강아지</li>
                    <li><input type="radio" name="animal" id="">고양이</li>
                </ul>
            </div>
            <div class="grid-item">
                <ul class="flex-ul-container">
                    <li>지역</li>
                    <li><input type="radio" name="location" id="">서울</li>
                    <li><input type="radio" name="location" id="">경기</li>
                    <li><input list="other-location" name="location" class="form-control col-lg-6" type="text" placeholder="검색">
                        <datalist id="other-location">
                            <option value="경상도">
                            <option value="전라도">
                        </datalist>
                    </li>
                </ul>
            </div>
            <div class="grid-item">
                <ul class="flex-ul-container">
                    <li>가격</li>
                    <li><input type="radio" name="price" id="">10만원 이하</li>
                    <li><input type="radio" name="price" id="">10~20만원</li>
                    <li><input type="radio" name="price" id="">20~30만원 이상</li>
                </ul>
            </div>
            <div class="grid-catagori-button-containers">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                  </svg>
                <input class="form-control col-lg-4" type="text" placeholder="검색하세요.">
                <button type="button" class="btn btn-primary align-bottom mr-1">검색</button>
            </form>
        </section>
      </div>
      <div class ="hotellist-container">
        <div class="hotellist-grid">
        <c:forEach items="${hotel_list}" var="h">
        	 <div class="card" style="width: 15rem;">
                <img src="hotel/img/${h.hotel_pthtofile }" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">${h.hotel_name} 호텔</h5>
                  <p> 지역: ${h.hotel_location}</p>
                  <p>동물 종류:
                   ${h.hotel_animal_kinds}</p>
                  <p>가격</p>
                  <div class="sm-3">
	                  <select class="form-control">
	                   		<option>5kg 미만 : ${h.hotel_price_5lt}원</option>
                   </select>
                  </div>
                  <button class="btn float-right item-btn" value="${h.hotel_no}">더 보기</button>
                   
                </div>
              </div> 
        </c:forEach>
           
        </div>
      </div>
      <script>
      function btnClick(e){
    	  console.log(e.target.value);
    		const hotelName = document.querySelector('.card-title');
      		const rehotel = hotelName.innerText.replace(" 호텔","");
    	  	location.href = "hotelinfo.net2?num=" + e.target.value +"&hotel_name=" + rehotel;
      }
      	window.onload= function(){
      		const btnGroup = document.querySelectorAll('.item-btn');
      		btnGroup.forEach((item) =>{
      			item.addEventListener('click',btnClick);
      		});
      		
      	}
      </script>
</body>
</html>