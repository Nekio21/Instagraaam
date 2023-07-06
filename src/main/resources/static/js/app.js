//const menu = document.getElementById("menuProfil");
//const nameHeader = document.getElementById("f");
//const body = document.getElementsByTagName('body')[0];
//
//var value = false;

//
//nameHeader.addEventListener("click", function(){
//	if(value == false){
//		showMenu();
//	}else{
//		hideMenu();
//	}
//});
//
//
//function showMenu(){
//	console.log("witam");
//	menu.style.display = "flex";
//	value = true;
//}
//
//function hideMenu(){
//	console.log("witam:(");
//	menu.style.display = "none";
//	value = false;
//}

function post(id){
     window.location.href = 'post/' + id;
}

function showprofil(name){
     window.location.href = 'osoba/' + name;
}