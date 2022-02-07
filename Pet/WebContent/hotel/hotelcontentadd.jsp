<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="css/hotelcontentadd.css">
</head>
<body>	
	<jsp:include page="../template/nav.jsp"/>
 	<section class="content-container">
        <div class="add-detail-form-container">
          <form action="hotelList.net" method="post">
          <input type="hidden" value="${files}" name="fileList">
          <div class="add-detail-content-container">
            <div class="content-inner-container">
                <h4>사용자에게 제공할 상세정보</h4>
                <input type="text" class="form-control" name="link" placeholder="호텔 링크주소 ex)https://hotelsdot.com">
                <span class="hidden" style="display:none;"></span>
                <textarea class="content-text" id="content-text" name="content" placeholder="호텔의 소개와 설명을 적어주세요."></textarea>
                <span class="text-span" style="display:none;"></span>
                <input type="hidden" value="${num}" name="num">

              
            </div>
            <div class="flex-btn">
              <input type="submit" value="호텔 등록" id="filelistbtn" class="btn btn-primary btn-lg">
            </div>

              
          </div>
        </form>
        </div>
     </section>
     <script>
		const email_chk = document.querySelector('input[type="text"]');
		const form = document.querySelector('form');
		function changeEmail(e){
			const regex = /[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)?/gi;
			const email_reg = new RegExp(regex);
			const span = document.querySelector('.hidden');
			span.style.marginLeft= "5px";
			span.style.fontWeight= "700";
			if(email_reg.test(e.target.value)){
				span.innerText = "알맞는 이메일 형식입니다.";
				span.style.display = "block";
				span.classList.remove('text-danger');
				span.classList.add('text-primary');
			}else{
				e.target.value = "";
				span.innerText = "알맞지 않은 이메일 형식입니다.";
				span.style.display = "block";
				span.classList.add('text-danger');
				span.classList.remove('text-primary');
				
				e.target.focus();
			}
		}
		function sumbitForm(e){
			e.preventDefault();
			if(e.target[1].value == "" || e.target[1].value == undefined ){
				const span = document.querySelector('.hidden');
				span.innerText="해당 정보를 작성해야 합니다.";
				span.classList.add('text-danger');
				span.classList.remove('text-primary');
				return;
			}
			if(e.target[2].value == "" || e.target[2].value == undefined ){
				const span = document.querySelector('.text-span');
				span.style.display="block";
				span.innerText="해당 정보를 작성해야 합니다.";
				span.classList.add('text-danger');
				span.classList.remove('text-primary');
				return;
			}else{
				const span = document.querySelector('.text-span');
				span.classList.remove('text-primary');
				span.style.display="none";
			}
			form.submit();
		}
		email_chk.addEventListener('change', changeEmail);
		form.addEventListener('submit', sumbitForm);
     </script>
</body>
</html>