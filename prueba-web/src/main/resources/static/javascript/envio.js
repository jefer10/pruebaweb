var url='http://localhost:8090/restaurante/apiv1/restaurant/save'

var formulario=document.getElementById("formulario");

formulario.addEventListener("submit", function(e){
    e.preventDefault();

    var datos=new FormData(formulario);

    var data={business_name:`${datos.get('business_name')}`,
              tradename:`${datos.get('tradename')}`,
              type_restaurant:`${datos.get('type_restaurant')}`,
              city:`${datos.get('city')}`,
              opening_time:`${datos.get('opening_time')}`,
              closing_time:`${datos.get('closing_time')}`
              };

    console.log(JSON.stringify(data));

    fetch(url, {
      method: 'POST', // or 'PUT'
      body: JSON.stringify(data), // data can be `string` or {object}!
      headers:{
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));

}, false);
