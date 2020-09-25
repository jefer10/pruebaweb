
function obtenerDatos(){

    fetch('http://localhost:8090/restaurante/apiv1/restaurant/all')
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato');
      fila.innerHTML= '';
      for(let dato of data){
            fila.innerHTML+=`
            <tr>
                <td>${dato.restaurantId}</td>
                <td>${dato.business_name}</td>
                <td>${dato.tradename}</td>
                <td>${dato.type_restaurant}</td>
                <td>${dato.city}</td>
                <td>${dato.opening_time}</td>
                <td>${dato.closing_time}</td>
            </tr>
            `
      }

      })
}


function newRestaurant(){
    let rsocial=document.getElementById("Rsocial").value;
    let Ncomercial=document.getElementById("Ncomercial").value;
    let lista=document.getElementById("type").value;
   // Obtener el valor de la opción seleccionada
   let type = lista.options[lista.selectedIndex].value;
   let city=document.getElementById("city").value;
   let Hapertura=document.getElementById("Hapertura").value;
   let Hcierre=document.getElementById("Hcierre").value;


    let url='http://localhost:8090/restaurante/apiv1/restaurant/save'
    let data={business_name:`${rsocial}`,
               tradename:`${Ncomercial}`,
               type_restaurant:`${type}`,
               city:`${city}`,
               opening_time:`${Hapertura}`,
               closing_time:`${Hcierre}`
               };

    console.log(rsocial);
    console.log(type);
    console.log(JSON.stringify(data));

    //fetch(url,{
      //        method:'post',
        //      headers:{'Content-Type': 'application/json'},
          //    body:JSON.stringify(data)
    //        })
      //.then(response => response.json())
      //.then(data => console.log(data));


}