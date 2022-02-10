/**
 * 
 */
function animalToStr(animal_grade){
	let str = "";
	if(animal_grade == 1){
		str ="고양이";
	}else if(animal_grade ==2){
		str = "강아지,고양이";
	}else{
		str ="강아지";
	}
	return str;
}
function madeItem(list,parent){
	//카드 div
	const card = document.createElement('div');
	card.classList.add('card');
	card.style.width = "15rem";
	const img = document.createElement('img');
	img.src = "hotel/img/" + list.hotel_pthtofile;
	img.style.height = "200px";
	img.classList.add('card-img-top');
	//카드 바디
	const card_body =  document.createElement('div');
	card_body.classList.add('card-body');
	//바디 안에 들어간 태그들
	const h5_hotel = document.createElement('h5');
	const p_loc = document.createElement('p');
	const p_animal = document.createElement('p');
	const p_price_text = document.createElement('p');
	const body_div = document.createElement('div');
	const btn = document.createElement('button');
	h5_hotel.classList.add('card-title');
	h5_hotel.innerText= list.hotel_name +" 호텔";
	p_loc.innerText = " 지역: " +list.hotel_addr.substring(0,list.hotel_addr.indexOf(" "));
	const str = animalToStr(list.hotel_animal_grade);
	p_animal.innerText = "동물 종류: " +str;
	p_price_text.innerText = "가격";
	body_div.classList.add('sm-3');
	btn.classList.add('btn');
	btn.classList.add('float-right');
	btn.classList.add('item-btn');
	btn.value = list.hotel_no;
	btn.innerText="더 보기";
	//body_div 안에 태그들
	const select =  document.createElement('select');
	const option1 =  document.createElement('option'); 
	const option2 =  document.createElement('option'); 
	const option3 =  document.createElement('option'); 
	const option4 =  document.createElement('option'); 
	select.classList.add('form-control');
	option1.innerText = "5kg 미만:" + list.hotel_price_5lt;
	option2.innerText = "5kg 이상 8kg 미만:" + list.hotel_price_5ge8lt;
	option3.innerText = "8kg 이상 12kg 미만:" + list.hotel_price_8ge12lt;
	option4.innerText = "12kg 이상:" + list.hotel_price_12gt;
	if(weight != "null"){
		if(weight == "5"){
			option1.selected =true;
		}else if(weight == "5,8"){
			option2.selected =true;
		}else if(weight == "8,12"){
			option3.selected =true;
		}else{
			option4.selected =true;
		}	
	}
	select.appendChild(option1);
	select.appendChild(option2);
	select.appendChild(option3);
	select.appendChild(option4);
	body_div.appendChild(select);
	card_body.appendChild(h5_hotel);
	card_body.appendChild(p_loc);
	card_body.appendChild(p_animal);
	card_body.appendChild(p_price_text);
	card_body.appendChild(body_div);
	card_body.appendChild(btn);
	card.appendChild(img);
	card.appendChild(card_body);
	parent.appendChild(card);
}
function madebox(list){
	const list_container = document.createElement('div');
	list_container.classList.add('hotellist-container');
	const list_grid = document.createElement('div');
	list_grid.classList.add('hotellist-grid');
	list.forEach((item)=> madeItem(item,list_grid));
	list_container.appendChild(list_grid);
	document.body.appendChild(list_container);
}
function removebox(){
	const divlist = document.querySelectorAll('.hotellist-container');
	divlist.forEach(item=>item.remove());
}
function ajax(url,config,ajaxcontroller){
	fetch(url,config)
	.then(res => res.json())
	.then(data => {
		if(ajaxcontroller == false){
			console.log(page);
			madebox(data.hotellist);
			page=data.page;
			maxpage = data.maxpage;
			weight = data.weight;
			animal = data.animal;
			
		}else{
			page = page +1;
			madebox(data.hotellist);
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
var page = 1;
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
		ajaxcontroll = false;
		if((window.innerHeight + window.scrollY) >= document.body.offsetHeight){
			if(page == maxpage){
				scrollfix = true;
			}
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
	loc = "null";
	weight = "null";
	price = "null";
	animal = "null";
	search = "null";
	page = 1;
	removebox();
	ajaxcontroll = true;
	scrollfix = false;
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
document.addEventListener('click', function(e){
    if(e.target && e.target.className == 'btn float-right item-btn'){
    	const hotelName = document.querySelector('.card-title');
  		const rehotel = hotelName.innerText.replace(" 호텔","");
	  	location.href = "hotelinfo.net2?num=" + e.target.value;
    }
});
