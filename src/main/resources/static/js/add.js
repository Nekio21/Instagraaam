const url = document.getElementById("superi");
const inputText = document.getElementById("text");

function zrob(){

    if(url.value == "" || inputText.value == ""){
        alert("Prosze wypelnic wszystkie pola :)");

        url.value = "";
        inputText.value = "";

        return;
    }

   var formData = new FormData();
   formData.append("url", url.value);
   formData.append("opis", inputText.value);


   var request = new XMLHttpRequest();
   request.open("POST", "add");
   request.send(formData);


   setTimeout(()=>{window.location.href = '/portal';},1000);

   url.value = "";
   inputText.value = "";
}