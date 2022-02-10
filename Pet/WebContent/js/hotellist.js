/**
 * 
 */

//윈도우 온로드 end
const search_input = document.querySelector('.search-input');
search_input.addEventListener('change', handleSearchInput);
function handleSearchInput(e){
	const rex = /^[a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,50}$/;
	if(!rex.test(e.target.value)){
		e.target.value="";
	}
}
      	
      	