const textDoWyslania = document.getElementById("ppp");

function wyslij(id){

    console.log(id);

    if(textDoWyslania.value == ""){
        console.log("NIE wysylamy");
        return;
    }

console.log("siema2");
   var formData = new FormData();
   formData.append("text", textDoWyslania.value);

   var request = new XMLHttpRequest();
   request.open("POST", "post/" + id);
   request.send(formData);
console.log("siema4");
   setTimeout(()=>{location.reload();},1000);
}