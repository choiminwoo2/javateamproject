$(document).ready(function() {
	
		var checkid=false;
		var checknickname=false;
		
		$("input:eq(0)").on('keyup',
				function () {
					$("id_message").empty(); 
					var pattern = /^\w{5,12}$/;
					var id = $("input:eq(0)").val();
					if (!pattern.test(id)) {
						$("#id_message").css('color', 'red').html("영문자 숫자 _로 5~12자 가능합니다.");
						
						checkid=false;
						return;
					}
					
					$.ajax({
						url : "idcheck.co",
						data : {"id" : id}, 
						success : function(resp) {
							if (resp == -1) { //db에 해당 id가 없는경우
								$("#id_message").css('color', 'green').html("사용 가능한 아이디 입니다.");
								checkid=true;
							} else { // db에 해당 id가 있는 경우 (0)
								$("#id_message").css('color', 'blue').html("사용중인 아이디 입니다.");
								checkid=false;
							}
						}
						
					}); 
		});//아이디 중복검사 끝
		
		$("input:eq(2)").on('keyup',
				function () {
					$("nickname_message").empty(); 
					var pattern = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;
					var nickname = $("input:eq(2)").val();
					if (!pattern.test(nickname)) {
						$("#nickname_message").css('color', 'red').html("닉네임은 한글, 영문, 숫자만 가능하며 2~10자리 가능합니다.");
						checknickname=false;
						return;
					}
					
					$.ajax({
						url : "nicknamecheck.co",
						data : {"nickname" : nickname},
						success : function(resp) {
							if (resp == -1) { //db에 해당 닉네임이 없는경우
								$("#nickname_message").css('color', 'green').html("사용 가능한 닉네임 입니다.");
								checknickname=true;
							} else { // db에 해당 닉네임이 있는경우 (0)
								$("#nickname_message").css('color', 'blue').html("사용중인 닉네임 입니다.");
								checknickname=false;
							}
						}
						
					}); 
		})//닉네임 중복검사 끝
		
		
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
			
			if (!checkid) {
				alert("사용가능한 id로 입력하세요.");
				$("input:eq(0)").val('').focus();
				return false;
			}
			
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
			if ($('#kg').val() > 50){
				$("#kg").val(txt.replace(txt, 50));  //12 kg 이상이면 12kg으로
			}
			
		}); //submit
	
	$(".cancelbtn").click(function (){
				location.href="index.jsp";
		}); // 돌아가기 버튼 메인으로 이동
			
});