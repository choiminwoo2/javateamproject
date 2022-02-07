$(document).ready(function() {
	
	  $("#btnDelete").click(function(){

        // 확인 대화상자 

        if(confirm("정말 탈퇴하시겠습니까?")){

            document.deleteform.action = "userdeleteProcess.co";

            document.deleteform.submit();

        }

    });

	
	$(".cancelbtn").click(function (){
				location.href="index.jsp";
		}); // 돌아가기 버튼 메인으로 이동
			
	
});