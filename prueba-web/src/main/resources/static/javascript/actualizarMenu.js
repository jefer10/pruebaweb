var menuID;
function leerDato(){

    var miDato = localStorage.getItem("ID1")
    console.log(miDato);
    var url='http://localhost:8090/restaurante/apiv1/menu/'+miDato
    fetch(url)
      .then(response => response.json())
      .then(data =>{
                    console.log(data)
                    menuID=data.menuId;
                    document.getElementById("type").value=data.type_menu;
                    document.getElementById("Mname").value=data.name_menu;
                    document.getElementById("Mprecio").value=data.price;
                    document.getElementById("Idrest").value=data.restaurantId;
      } );
}



var url1='http://localhost:8090/restaurante/apiv1/menu/update'

var formulario=document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault();

    var datos=new FormData(formulario);

    var data={
              menuId:`${menuID}`,
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