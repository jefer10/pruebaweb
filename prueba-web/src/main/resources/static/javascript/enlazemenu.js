
function obtenerDatosMenu(){

    fetch('http://localhost:8090/restaurante/apiv1/menu/all')
      .then(response => response.json())
      .then(data => {
      console.log(data);
      let fila=document.querySelector('#dato');
      fila.innerHTML= '';
      let tipo="";
      for(let dato of data){
            switch (dato.type_menu){
                case 1:
                    tipo="Entrada";
                    break;
                case 2:
                    tipo="Plato fuerte";
                    break;
                case 3:
                    tipo="Plato fuerte";
                    break;
                case 4:
                    tipo="bebida";
                    break;
                default: break;
            }
            fila.innerHTML+=`
            <tr>
                <td>${dato.menuId}</td>
                <td>${tipo}</td>
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