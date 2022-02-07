$(document).ready(function() {
	
	$("input:eq(3)").on('keyup',
				function () {
					$("tel_message").empty(); 
					var pattern = /^01([0|1|]?)-([0-9]{4})-([0-9]{4})$/
					var tel = $("input:eq(3)").val();
					if (!pattern.test(tel)) {
						$("#tel_message").css('color', 'red').html("형식은 (010 또는 011)-0000-0000 입니다."); // 010 , 010 시작
						checktel=false;
						return;
					}else {
						$("#tel_message").css('color', 'green').html(""); // 010 , 010 시작
						checktel=true;
						return;
					}
					
		})//핸드폰 정규 표현식끝
		
		$('form').submit(function() {
			
			
			if (!checknickname) {
				alert("사용가능한 닉네임으로 입력하세요.");
				$("input:eq(2)").val('').focus();
				return false;
			}
			
			if (!checktel) {
				alert("전화번호 형식을 맞추세요.");
				$("input:eq(3)").val('').focus();
				return false;
			}
		
			var txt = $("#kg").val();
	
			$("#kg").val(txt.replace(/(\.\d+)+/, "").replace(/[^0-9]/g,"")); // 소숫점아래 제거, 문자열 제거
			if ($('#kg').val() > 12){
				$("#kg").val(txt.replace(txt,12));  //12 kg 이상이면 12kg으로
			}
			
		}); //submit
	
	$(".cancelbtn").click(function (){
				location.href="index.jsp";
		}); // 돌아가기 버튼 메인으로 이동
			
	
});