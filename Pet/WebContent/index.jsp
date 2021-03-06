<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>애견 호텔에 오신걸 환영합니다.</title>
    <Style>

    .photoTitle{
    margin-bottom:0.7em;
    }
    #selectPhoto{
    	justify-self: center;
    }
    .card{
    box-shadow: 10px 5px 5px rgba(0,0,0,0.3);
    }
    .btn-more{
    margin-top:2em;
 		height:2em;
    }
    .col-centered {
	  float: none;
	  margin-right: auto;
	  margin-left: auto;
	}
	.photoSection{
		margin-bottom: 12em;
	}
	main{
	margin-top:100px;
	}
    </Style>

  </head>

  <body data-spy="scroll" data-target="#navbar1" data-offset="60">
  <c:if test="${temp.user_grant==1}">
    <header class="bg-primary">
        <div class="container h-100">
            <div class="row h-100 centerItem">
                <div class="col-12">
                    <div class="text-center m-0 vh-100 d-flex flex-column justify-content-center text-light">
                        <h1 class="display-4">호텔 등록</h1>
                        <p class="lead">당신의 호텔을 등록하세요!.</p>
                        <div class="mt-2 mx-auto">
                                  <a href="hotelAdd.net" class="btn btn-outline-light btn-lg .text-primary">
                                		호텔 등록
                                  </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
   </c:if>
       <jsp:include page="template/nav.jsp"/>
    <main>
        <section class="container vh-10">
            <div class="row vh-auto photoSection">
                <div class="col-12 my-auto">
                    <div class="row">
                    <h1 class="text-center w-100  h-25 photoTitle">PhotoGallery</h1>
                     <span class="text-center w-100  h-25 photoTitle">여러분의 반려동물의 정보를 나눌 수 있습니다.</span>
                        <div class="col-lg-3 mb-3 ">
                          	<div class="card col-centered" style="width: 15rem;">
							  <img src="hotel/img/hotel1.jpg" style="min-height: 357px;" class="card-img-top"  alt="...">
							</div>
                        </div>
                        <div class="col-lg-3 mb-3 ">
                           	<div class="card col-centered" style="width: 15rem;">
							  <img src="hotel/img/photo1.jpg" style="min-height: 357px;" class="card-img-top" alt="...">

							</div>
                        </div>
                        <div class="col-lg-3 mb-3">
                           	<div class="card col-centered" style="width: 15rem;">
							  <img src="hotel/img/photo2.png" style="min-height: 357px;" class="card-img-top" alt="...">

							</div>
                        </div>
                         <div class="col-lg-3 mb-3">
                           	<div class="card col-centered" style="width: 15rem;">
							  <img src="hotel/img/thoto3.jpg" style="min-height: 357px;" class="card-img-top" alt="...">

							</div>
                        </div>
                        <div class="col text-center btn-more">
					      <button type="button" class="btn btn-primary align-bottom btn-lg mr-1">더 보기</button>
					    </div>
                    </div>
                </div>
            </div>
        </section>
            
    </main>
      <jsp:include page="template/footer.jsp"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="scripts.js"></script>
</body>
</html>