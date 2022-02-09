<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="utf-8">

    <link rel="shortcut icon" href="http://themes.guide/favicon.ico" type="image/x-icon" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/3.0.0/css/ionicons.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   
   </head>
<body>
<div style="height: 60px;">
 <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary" id="navbar1">
        <div class="container">
            <a class="navbar-brand mr-1 mb-1 mt-0" href="index.jsp">Pet Cozi</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-collapse collapse justify-content-center" id="collapsingNavbar">
                <ul class="navbar-nav">
                   
                </ul>
                
                <ul class="navbar-nav ml-auto">
                	
                    <c:if test="${!empty id}">	
                    	<li class="nav-item">	
                    		<a class="nav-link">
                    			${temp.nickname}님 반갑습니다.
                    		</a>	
                    	</li>
                    </c:if>
                    
                    <c:if test="${empty id}">
                      <li class="nav-item">
                        <a class="nav-link" href="hotelList.net">호텔 찾기</a>
                     </li>
                    	<li class="nav-item">
                        	<a class="nav-link" href="login.co">로그인</a>
                    	</li>
                   		<li class="nav-item">
                        	<a class="nav-link" href="join.co">회원가입</a>
                    	</li>
                    </c:if>
                    
                    <%-- 관리자 --%>
                    <c:if test="${temp.user_grant==2}">
                   		 <li class="nav-item">
                        	<a class="nav-link" href="userList.co">회원목록 보기</a>
                   		 </li>
                   		 
                     </c:if>
                     
                     <%-- 호텔측 사용자 --%>
                     <c:if test="${temp.user_grant==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="hotelAdd.net">호텔 등록</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="hotelList.net">호텔 찾기</a>
                     </li>
                    
                    </c:if>
                    
                  	<%-- 일반 사용자 --%>
                   	<c:if test="${temp.user_grant==0}">		
	                 <li class="nav-item">
                        <a class="nav-link" href="hotelList.net">호텔 찾기</a>
                     </li>
                   	  <li class="nav-item">
                        <a class="nav-link" href="userMyList.co">찜한 호텔보기</a>
                      </li>	
                    </c:if> 
                    
                    <c:if test="${!empty id}">
                          <li class="nav-item">
                        <a class="nav-link" href="logout.co">로그아웃</a>
                    </li>
                    </c:if>
                     <c:if test="${!empty id && temp.user_grant != 2}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDd" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          MyPage
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDd">
                            <a class="dropdown-item px-2" href="usermodifyview.co?id=${temp.id}&user_no=${temp.user_no}">회원 정보 수정</a>
                            <a class="dropdown-item px-2" href="userdeleteview.co">회원 탈퇴</a>
                        <div class="dropdown-divider"></div>
                            <a class="dropdown-item px-2" href="#more">All</a>
                        </div>
                    </li>
                    </c:if>
                </ul>
            </div>
        </div>
      </nav>
      </div>
</body>
</html>