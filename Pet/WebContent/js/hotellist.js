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

var cnt = 0;
let onetime= false;
	window.onscroll = function(e){
		if((window.innerHeight + window.scrollY) >= document.body.offsetHeight){
			setTimeout(() => {
				madebox();
			}, 1000);
			console.log("window="+(window.innerHeight + window.scrollY) +"document" +  document.body.offsetHeight);
			
		}
	}
      	
      	