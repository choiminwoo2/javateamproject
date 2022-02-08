/**
 * 
 */
 function btnClick(e){
    	  console.log(e.target.value);
    		const hotelName = document.querySelector('.card-title');
      		const rehotel = hotelName.innerText.replace(" 호텔","");
    	  	location.href = "hotelinfo.net2?num=" + e.target.value +"&hotel_name=" + rehotel;
}
window.onload= function(){
     const btnGroup = document.querySelectorAll('.item-btn');
     btnGroup.forEach((item) =>{
      	item.addEventListener('click',btnClick);
     });
      		
}
function madebox(){
	var addContent = document.createElement('div');
	addContent.classList.add('hotellist-container');
	document.body.appendChild(addContent);
}
function ajax(url,config){
	fetch(url,config)
	.then(res => res.json())
	.then(data => {
		madebox();
		page=data.page;
		maxpage = data.maxpage;
	})
}
function go(page,scrollfix){
	if(scrollfix){
		return;
	}

	var data = {
		"state" : "ajax",
		"page" : page
	};
	//url에 쿼리 담는 방법.
	var query = Object.keys(data)
				.map(k => encodeURIComponent(k) + '=' + encodeURIComponent(data[k]))
				.join('&');
	var url = 'hotelList.net?' + query;
	//서버로 보내는 data-type과 설정.
	var config = {
			method: 'POST',
			cache: 'no-cache'
	}
	ajax(url,config);
	
	
}
var page = 2;
var maxpage = 0;
var scrollfix = false;
	window.onscroll = function(e){
		console.log("page" + page);
		console.log("maxpage"+(maxpage +1));
		if(page == (maxpage+1)){
			scrollfix = true;
		}
		if((window.innerHeight + window.scrollY) >= document.body.offsetHeight){
			setTimeout(() => {
				go(page,scrollfix);
			}, 100);
			console.log("window="+(window.innerHeight + window.scrollY) +"document" +  document.body.offsetHeight);
			
		}
	}

      	
      	