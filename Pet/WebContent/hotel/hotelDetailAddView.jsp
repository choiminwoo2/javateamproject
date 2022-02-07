<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hoteladddetail.css">
</head>
<body>
	<jsp:include page="../template/nav.jsp"/>
	     <section class="content-container">
        <div class="add-detail-form-container">
          <form method="post" action="hotelDetailAdd.net" enctype="multipart/form-data">
          <div class="add-detail-file-container">
            <div class="file-inner-container">
              <label for="fileinput">
              <h4 class="before_file">클릭해서 사진을 등록해주세요</h4>
              <div class="file-grid-container">
              	<input type="hidden" name="num" value="${num}">
                <input type='file' id="fileinput" multiple="multiple" name="files[]"/>
                <div class="inline-gap"></div>
                <img src="hotel/img/image.png">
                <img src="hotel/img/image.png">
                <img src="hotel/img/image.png">
                <img src="hotel/img/image.png">
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
     <script defer>
     	const files = document.querySelector('input[type="file"]');
     	window.onload = function(){
     		const el = document.querySelector('.before_file');
     		el.style.display = "block";
     	}
     	files.onchange= function(e){
     		var img = document.querySelectorAll('img');
     		img.forEach(item => item.remove());
     		const fileList = e.target.files;
     		console.log(fileList);
     		console.log(fileList.length);
     		for(let i = 0; i < fileList.length; i++){
     			loadFile(fileList[i]);
     		}
     		
     	}
     	function loadFile(fileNode){
     		var file = fileNode;
     		var pattern = /\.(gif|jpe?g|tiff?|png|webp|bmp)$/i;
     		if(pattern.test(file.name)){
     			var fileReader = new FileReader();
         		fileReader.readAsDataURL(file);
         		fileReader.onload = function(e){
         			var newImg = document.createElement("img");
             		newImg.src = e.target.result;
             		const div = document.querySelector('.file-grid-container');
             		console.log(div);
             		const el = document.querySelector('.before_file');
             		div.style.opacity ="1.0";
              		el.style.display = 'none';
             		div.appendChild(newImg);	
     		}
     		}else{
     			alert('확장자는 gif,jpeg, png가 가능합니다');
     			file.value = "";
     		}
     	}
     	
     </script>
</body>
</html>