/**
 * 
 */
 function btnClick(e){
    		const hotelName = document.querySelector('.card-title');
      		const rehotel = hotelName.innerText.replace(" 호텔","");
    	  	location.href = "hotelinfo.net2?num=" + e.target.value;

}
window.onload= function(){
     const btnGroup = document.querySelectorAll('.item-btn');
     btnGroup.forEach((item) =>{
      	item.addEventListener('click',btnClick);
     });   		
}
//윈도우 온로드 end
const search_input = document.querySelector('.search-input');
search_input.addEventListener('change', handleSearchInput);
function handleSearchInput(e){
	const rex = /^[a-zA-Zㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,50}$/;
	if(!rex.test(e.target.value)){
		e.target.value="";
	}
}



      	
      	