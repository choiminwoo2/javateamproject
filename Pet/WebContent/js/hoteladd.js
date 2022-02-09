const post_btn = document.querySelector('#postbtn');
const hotel_name = document.querySelector('#hotel_name');
//호텔이름 인풋 이벤트
hotel_name.addEventListener('change',hotelInput);
function hotelInput(e){
	const span = document.querySelector('.nameinput');
	if(e.target.value.length > 20){
		span.innerText = "호텔길이를 초과하였습니다.";
		span.classList.add('show');
		span.classList.add('text-danger');
		span.classList.remove('hidden');
	}else{
		span.classList.add('hidden');
		span.classList.remove('text-danger');
		span.classList.remove('show');
	}
}
//몸무게 인풋 처리
const weight_input_list = document.querySelectorAll('.weight-grid input[type="text"]');
weight_input_list.forEach(item => item.addEventListener('change',hotel_weight));
function hotel_weight(e){
	const rex = /^[1-9][0-9]{4,5}$/;
	console.log(e.target.value);
	console.log(rex.test(e.target.value));
	const span = document.querySelector('.weight-span');
	if(!rex.test(e.target.value)){
		e.target.value= "";
		span.classList.add('show');
		span.classList.add('text-danger');
		span.classList.remove('hidden');
		e.target.focus();
	}else{
		span.classList.add('hidden');
		span.classList.remove('text-danger');
		span.classList.remove('show');
	}
}
//호텔 번호
const hotel_tel = document.querySelector('.hotel_tel');
hotel_tel.addEventListener('change',handleChangeTel);
function handleChangeTel(e){
	var pattern = /^0[2-6][1-5]?(\)|-)?[2-9]\d{2,3}-\d{4}$/;
	const span = document.querySelector('.tel-span');
	if(!pattern.test(e.target.value)){
		e.target.value="";
		span.classList.add('show');
		span.classList.add('text-danger');
		span.classList.remove('hidden');
		e.target.focus();
	}else{
		span.classList.add('hidden');
		span.classList.remove('text-danger');
		span.classList.remove('show');
	}
}
//상세 주소
const addr_detail = document.querySelector('#addressdetail');
addr_detail.addEventListener('change',handleChangeDetail);
function handleChangeDetail(e){
	const span = document.querySelector('.detail-span');
	if(e.target.value.length > 100){
		e.target.value="";
		span.classList.add('show');
		span.classList.add('text-danger');
		span.classList.remove('hidden');
		e.target.focus();
	}else{
		span.classList.add('hidden');
		span.classList.remove('text-danger');
		span.classList.remove('show');
	}
	
}
//파일처리
const input_file = document.querySelector('#mainfile');
input_file.addEventListener('change',handleChangeFile);
function handleChangeFile(e){
	var img = document.querySelectorAll('img');
	console.log(e);
		const file = e.target.files[0];
		loadFile(file);
		
}
function createImgFile(file){
	var pattern = /\.(gif|jpe?g|tiff?|png|webp|bmp)$/i;
	const span = document.querySelector('.file_span');
	var newImg = document.createElement("img");
	if(pattern.test(file.name)){
		var fileReader = new FileReader();
		fileReader.readAsDataURL(file);
		span.classList.add('hidden');
		span.classList.remove('text-danger');
		span.classList.remove('show');
		fileReader.onload = function(e){
 		newImg.src = e.target.result;
 		const div = document.querySelector('.file-container > div');
 		console.log(div);
 		newImg.style.display = "inline-block";
 		newImg.classList.add('file-item');
 		newImg.style.maxHeight="100px";
 		newImg.style.maxWidth = "100px";
 		div.insertBefore(newImg,document.querySelector('.file_span'))	
	}
	}else{
		file.value = "";
		document.querySelector('img')
		span.innerText = '사진을 추가해주세요. 확장자는 gif,jpeg, png가 가능합니다';
		span.classList.add('show');
		span.classList.add('text-danger');
		span.classList.remove('hidden');
		e.target.focus();
	}
}
function loadFile(fileNode){
		const oldImg = document.querySelector('.file-item');
		var file = fileNode;
		if(oldImg ==  undefined){
			createImgFile(file);
		}else{
			oldImg.remove();
			createImgFile(file);
		}
	}
//파일처리 end
//우편검색
post_btn.addEventListener('click',postBtnClick);
function postBtnClick(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }
            
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
             $('#post1').val(data.zonecode); //5자리 새우편번호 사용
             $('#address').val(fullRoadAddr);
           
        }
    }).open();
}
//우편검색 end
//window.onload 하면
window.onload = function(){
    const mainfile = document.querySelector('#mainfile');
    mainfile.style.display = "none";
}
//파일 관련 함수
