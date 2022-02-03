<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="utf-8">
    <link rel="icon" href="http://themes.guide/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="http://themes.guide/favicon.ico" type="image/x-icon" />
    <meta property="og:image" name="twitter:image" content="http://bootstrap.themes.guide/assets/ss_fresca.png">
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@ThemesGuide">
    <meta name="twitter:creator" content="@ThemesGuide">
    <meta name="twitter:title" content="Open-source Bootstrap 4 Themes">
    <meta name="twitter:description" content="Download Fresca - free, open source Bootstrap 4 theme by Themes.guide">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/3.0.0/css/ionicons.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <link href="css/template.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
<div style="height: 60px;">
 <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary" id="navbar1">
        <div class="container">
            <a class="navbar-brand mr-1 mb-1 mt-0" href="../">Bootstrap 4</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-collapse collapse justify-content-center" id="collapsingNavbar">
                <ul class="navbar-nav">
                   
                </ul>
                <ul class="navbar-nav ml-auto">
                
                 
                    <c:if test="${!empty id}">			
                    		<span style="color:white">${id}님 반갑습니다.</span>
                    </c:if>
                    
                    <c:if test="${empty id}">
                      <li class="nav-item">
                        <a class="nav-link" href="login.co">로그인</a>
                    </li>
                   </c:if>
                    <c:if test="${empty id}">
                    <li class="nav-item">
                        <a class="nav-link" href="join.co">회원가입</a>
                    </li>
                   	</c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="#cards">호텔 유저 호텔등록</a>
                    </li>
                    
                    
                    <li class="nav-item">
                        <a class="nav-link" href="#forms">관리자 회원 정보</a>
                    </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#forms">관리자 마이페이지</a>
                    </li>
                   			
                       <li class="nav-item">
                        <a class="nav-link" href="#forms">일반유저 마이페이지</a>
                    </li>
                   
                          <li class="nav-item">
                        <a class="nav-link" href="#forms">일반유저 찜목록</a>
                       
                    </li>
                     
                    <c:if test="${!empty id}">
                          <li class="nav-item">
                        <a class="nav-link" href="logout.co">로그아웃</a>
                    </li>
                    </c:if>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDd" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          More
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDd">
                            <a class="dropdown-item px-2" href="#more">Badges</a>
                            <a class="dropdown-item px-2" href="#more">Tooltips &amp; Popups</a>
                            <a class="dropdown-item px-2" href="#more">Progress &amp; Alerts</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item px-2" href="#more">All</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
      </nav>
      </div>
</body>
</html>