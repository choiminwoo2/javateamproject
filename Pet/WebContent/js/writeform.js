$(document).ready(function(){
	
//submit 버튼 클릭할 때 이벤트 부분
	$("form").submit(function(){
	

		if($.trim($("input").eq(1).val())==""){
			alert("제목을 입력하세요");
			$("input:eq(2)").focus();
			return false;
		}
		if($.trim($("textarea").val())==""){
			alert("내용을 입력하세요");
			$("textares").focus();
			return false;
		}
	});
	

	});
	