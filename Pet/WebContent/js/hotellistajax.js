/**
 * 
 */
function madebox(){
	var addContent = document.createElement('div');
	addContent.classList.add('hotellist-container');
	document.body.appendChild(addContent);
}
function ajax(url,config,ajaxcontroller){
	fetch(url,config)
	.then(res => res.json())
	.then(data => {
		if(ajaxcontroller == false){
			madebox();
			page=data.page;
			maxpage = data.maxpage;
		}else{
			
		}
	})
	.catch(err => console.error(err));
}
function go(page,scrollfix,loc,weight,price,animal,search){
	if(scrollfix){
		return;
	}else{
		
		var data = {
			"state" : "ajax",
			"page" : page,
			"weight" : weight,
			"loc" : loc,
			"price" : price,
			"animal" : animal,
			"search" : search
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
		if(ajaxcontroll == true){
			ajax(url,config,true);
		}else{
			ajax(url,config,false);
		}
	}
}
var page = 2;
var maxpage = 0;
loc = "null";
weight = "null";
price = "null";
animal = "null";
search = "null";
ajaxcontroll = false;
//infinity scroll
var scrollfix = false;
	window.onscroll = function(e){

		if((window.innerHeight + window.scrollY) >= document.body.offsetHeight){
			if(page == (maxpage+1)){
				scrollfix = true;
			}
			ajaxcontroll = false;
			setTimeout(() => {
				console.log("scroll ajax");
				go(page,scrollfix,loc,weight,price,animal,search);
			}, 500);
			
		}
	}
//end
//serarch-btn
document.querySelector('.search-btn')
.addEventListener('click',handleBtnClick);
function handleBtnClick(e){
	ajaxcontroll = true;
	e.preventDefault();
	const weight_list = document.querySelectorAll('input[name="weight"]');
	const animal_list = document.querySelectorAll('input[name="animal"]');
	const loc_list = document.querySelectorAll('input[name="location"]');
	const price_list = document.querySelectorAll('input[name="price"]');
	weight_list.forEach((item) =>{
		if(item.checked == true){
			weight = item.value;
		}
	});
	animal_list.forEach((item) =>{
		if(item.checked == true){
			animal = item.value;
		}
	});
	loc_list.forEach((item) =>{
		if(item.checked == true){
			loc = item.value;
		}
	});
	price_list.forEach((item) =>{
		if(item.checked == true){
			price = item.value;
		}
	});
	setTimeout(() => {
		console.log("search ajax");
		go(page,false,loc,weight,price,animal,search);
	}, 500);
	
	
}
