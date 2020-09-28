var restaurantID;
function leerDato(){

    var miDato = localStorage.getItem("ID1");
    var url='http://localhost:8090/restaurante/apiv1/restaurant/'+miDato
    fetch(url)
      .then(response => response.json())
      .then(data =>{
                    console.log(data)
                    restaurantID=data.restaurantId;
                    document.getElementById("Rsocial").value=data.business_name;
                    document.getElementById("Ncomercial").value=data.tradename;
                    document.getElementById("type").value=data.type_restaurant;
                    document.getElementById("city").value=data.city;
                    document.getElementById("Hapertura").value=data.opening_time;
                    document.getElementById("Hcierre").value=data.closing_time;
      } );
}

var url1='http://localhost:8090/restaurante/apiv1/restaurant/update'

var formulario=document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault();

    var datos=new FormData(formulario);

    var data={
              restaurantId:`${restaurantID}`,
              business_name:`${datos.get('business_name')}`,
              tradename:`${datos.get('tradename')}`,
              type_restaurant:`${datos.get('type_restaurant')}`,
              city:`${datos.get('city')}`,
              opening_time:`${datos.get('opening_time')}`,
              closing_time:`${datos.get('closing_time')}`
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