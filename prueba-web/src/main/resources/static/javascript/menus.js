var miDato = localStorage.getItem("ID1");

function menus(){
menuEntrada();
menuPlatoFuerte();
menuPostres();
menuBebidas();
}

function menuEntrada(){

    var url='http://localhost:8090/restaurante/apiv1/menu/buscar/1/'+miDato
    fetch(url)
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato');
      fila.innerHTML= '';
      let tipo="";
      for(let dato of data){
            fila.innerHTML+=`
            <tr>
                <td>${dato.menuId}</td>
                <td>${dato.name_menu}</td>
                <td>${dato.price}</td>
                <td><button value=${dato.menuId}; onClick="actualizar(this)">Modificar</button></td>
                <td><button value=${dato.menuId} onclick="eliminar('${dato.menuId}')">Eliminar</button></td>
            </tr>
            `
      }

      })
}


function menuPlatoFuerte(){

    var url='http://localhost:8090/restaurante/apiv1/menu/buscar/2/'+miDato
    fetch(url)
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato1');
      fila.innerHTML= '';
      let tipo="";
      for(let dato of data){
            fila.innerHTML+=`
            <tr>
                <td>${dato.menuId}</td>
                <td>${dato.name_menu}</td>
                <td>${dato.price}</td>
                <td><button value=${dato.menuId}; onClick="actualizar(this)">Modificar</button></td>
                <td><button value=${dato.menuId} onclick="eliminar('${dato.menuId}')">Eliminar</button></td>
            </tr>
            `
      }

      })
}

function menuPostres(){

    var url='http://localhost:8090/restaurante/apiv1/menu/buscar/3/'+miDato
    fetch(url)
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato2');
      fila.innerHTML= '';
      let tipo="";
      for(let dato of data){
            fila.innerHTML+=`
            <tr>
                <td>${dato.menuId}</td>
                <td>${dato.name_menu}</td>
                <td>${dato.price}</td>
                <td><button value=${dato.menuId}; onClick="actualizar(this)">Modificar</button></td>
                <td><button value=${dato.menuId} onclick="eliminar('${dato.menuId}')">Eliminar</button></td>
            </tr>
            `
      }

      })
}


function menuBebidas(){

    var url='http://localhost:8090/restaurante/apiv1/menu/buscar/4/'+miDato
    fetch(url)
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato3');
      fila.innerHTML= '';
      let tipo="";
      for(let dato of data){
            fila.innerHTML+=`
            <tr>
                <td>${dato.menuId}</td>
                <td>${dato.name_menu}</td>
                <td>${dato.price}</td>
                <td><button value=${dato.menuId}; onClick="actualizar(this)">Modificar</button></td>
                <td><button value=${dato.menuId} onclick="eliminar('${dato.menuId}')">Eliminar</button></td>
            </tr>
            `
      }

      })
}

function redireccionarUpdate(){
    location.href='http://localhost:8090/restaurante/apiv1/usuario/actualizarMenu';
}

function actualizar(comp){
    let id=comp.value;
    console.log(id);
    localStorage.setItem("ID1",id);
    redireccionarUpdate();
}


function eliminar(comp){

    var requestOptions = {
      method: 'DELETE',
      redirect: 'follow'
    };
    let url='http://localhost:8090/restaurante/apiv1/menu/delete/'+comp
    fetch(url, requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
    location.href='http://localhost:8090/restaurante/apiv1/usuario/Menu-list';

}