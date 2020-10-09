
var url1='http://localhost:8090/restaurante/apiv1/menu/save'

var formulario=document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault();

    var datos=new FormData(formulario);

    var data={
              type_menu:`${datos.get('type_menu')}`,
              name_menu:`${datos.get('name_menu')}`,
              price:`${datos.get('price')}`,
              restaurantId:`${datos.get('restaurant')}`
              };

    console.log(JSON.stringify(data));

    fetch(url1, {
      method: 'POST', // or 'PUT'
      body: JSON.stringify(data), // data can be `string` or {object}!
      headers:{
        'Content-Type': 'application/json'
      }
    }).then(res => console.log('Success:', res));

}, false);