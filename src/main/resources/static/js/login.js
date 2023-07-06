const przycisk = document.getElementById("przycisk");
const login = document.getElementById("login");
const haslo = document.getElementById("haslo");



function loginn(){
   var formData = new FormData();
   formData.append("login", login.value);
   formData.append("password", haslo.value);

   var request = new XMLHttpRequest();
   request.open("POST", "/banan");
   request.send(formData);

    console.log("zrobilem :)");

  setTimeout(()=>{window.location.href = '/portal';},1000);
 // window.location.href = '/portal';
}