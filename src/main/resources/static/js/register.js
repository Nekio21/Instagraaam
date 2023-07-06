const inputLogin = document.getElementById("login");
const inputPass = document.getElementById("pass");
const inputPass2 = document.getElementById("pass2");
const opiss = document.getElementById("opiss");
const url = document.getElementById("urodziny");

function wyslijDoBazy(){

    if((inputPass.value != inputPass2.value)){

        alert("Zle wpisane haslo :(");

        return;
    }

    if((inputPass.value == "") || (inputLogin.value == "")){

            alert("Zle wpisane dane :(");

            return;
    }

    console.log("TAK rejestrana");

   var formData = new FormData();
   formData.append("login", inputLogin.value);
   formData.append("password", inputPass.value);
   formData.append("urlImage", url.value);
   formData.append("opis", opiss.value);

   console.log(inputLogin.value);

   var request = new XMLHttpRequest();
   request.open("POST", "register");
   request.send(formData);

   setTimeout(()=>{location.reload();},1000);
}

function wroc(){
    window.location.href = '/';
}