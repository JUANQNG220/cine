/*function leerClientes(){
     
//Funcion GET request    
    $.ajax({
        url: "https://g05e37dc85df783-kingofringddbb.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "GET",
        datatype: 'json',

        success: function (clientes) {
            let cs = clientes.items;
            $("#listaClientes").empty();
            for(i=0;i<cs.length;i++) {
                $("#listaClientes").append("id: "+cs[i].id+" "+"<b>"+cs[i].name+"</b>"+" email: "+cs[i].email+" Edad: "+cs[i].age);
                $("#listaClientes").append("<button onclick='borrarCliente("+cs[i].id+")'>Borrar</button><br>");
                $("#listaClientes").append();
            }
        },
        error: function (xhr, status) {
            alert("Ha sucedido un error: " + xhr.status);
        }
        
    });
}

function guardarCliente(){
    let idCliente=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let email=$("#emailCliente").val();
    let edad=$("#edadCliente").val();

    let data ={
        id:idCliente,
        name:nombre,
        email:email,
        age:edad,
    };

    let dataToSend = JSON.stringify(data);

    //console.log(dataToSend); // impresión de la variable

    $.ajax({
        url: "https://g05e37dc85df783-kingofringddbb.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "POST",
        datatype: 'json',
        data: dataToSend,
        contentType: 'application/json',

        success: function (pepito) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#emailCliente").val("");
            $("#edadCliente").val("");
        },
        error: function (pepito) {
            console.log(pepito);
        },
        complete: function (){
            leerClientes();
        }
        
    });
}

function editarCliente(){
    let idCliente=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let email=$("#emailCliente").val();
    let edad=$("#edadCliente").val();

    let data ={
        id:idCliente,
        name:nombre,
        email:email,
        age:edad,
    };

    let dataToSend = JSON.stringify(data);

    //console.log(dataToSend); // impresión de la variable

    $.ajax({
        url: "https://g05e37dc85df783-kingofringddbb.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "PUT",
        datatype: 'json',
        data: dataToSend,
        contentType: 'application/json',

        success: function (pepito) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#emailCliente").val("");
            $("#edadCliente").val("");
        },
        error: function (pepito) {
            console.log(pepito);
        },
        complete: function (){
            leerClientes();
        }
        
    });   

}

function borrarCliente(idCliente){
    
    let data ={
        id:idCliente
    };

    let dataToSend = JSON.stringify(data);

    //console.log(dataToSend); // impresión de la variable

    $.ajax({
        url: "https://g05e37dc85df783-kingofringddbb.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
        type: "DELETE",
        datatype: 'json',
        data: dataToSend,
        contentType: 'application/json',

        success: function (pepito) {
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#emailCliente").val("");
            $("#edadCliente").val("");
        },
        error: function (pepito) {
            console.log(pepito);
        },
        complete: function (){
            leerClientes();
        }
        
    });   

}
 */

///////////////////////////////////// ejercicio 2 con profesor jose

const ApiUrl ="https://g05e37dc85df783-kingofringddbb.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client";

class readClientes{

    static guardarCliente(){
        const clientes ={
            id:$("#idCliente").val(),
            name: $("#nombreCliente").val(),
            email: $("#emailCliente").val(),
            age: $("#edadCliente").val(),
        };
        $.ajax({
            url: ApiUrl,
            type: "POST",
            datatype: 'json',
            contentType:"application/json",
            crossDomain: true,
            data: JSON.stringify(clientes),

            complete: function (response) {
                if (response.status === 201){
                    $("#idCliente").val(""),
                    $("#nombreCliente").val(""),
                    $("#emailCliente").val(""),
                    $("#edadCliente").val(""),
                    $("#detalle-cliente").html("<p>No se ha seleccionado ningun cliente</p>");
                    readClientes.loadAll(); //Lo utilizamos para que cargue cada que se haga un crud
                    alert("cliente adicionado");
                }
                else{
                    alert("cliente NO adicionado");
                }
            }
        });
    }

    static loadAll(){
        $.ajax({
            url: ApiUrl,
            type: "GET",
            datatype: 'json',
            contentType:"application/json",
            crossDomain: true,
            
            success: function (data) {
                $("tbody").html(""); //Es para eliminar la fila que tenia vacia
                for(let index = 0; index < data.items.length; index++) {
                    $("tbody").append(`
                        <tr>
                            <td>${data.items[index].id}</td>
                            <td>
                            <a href="javascript:readClientes.loadById(${data.items[index].id})"> ${data.items[index].name} </a>
                            </td>
                            <td>${data.items[index].email}</td>
                            <td>${data.items[index].age}</td>
                        </tr>
                        `);
                }                
            },
            error: function () {
                alert("clientes NO encontrados");
            }
        });
    }

    static loadById(idCliente){
        $.ajax({
            url: ApiUrl + "/" + idCliente,
            type: "GET",
            datatype: 'json',
            contentType:"application/json",
            crossDomain: true,
            
            success: function (data) {
                if (data.items.length === 0) {
                    alert("No clients found")
                } else{
                $("#detalle-cliente").html(`
                    <p><b>id:</b> ${data.items[0].id} </p>
                    <p><b>name:</b> ${data.items[0].name} </p>
                    <p><b>email:</b> ${data.items[0].email} </p>
                    <p><b>age:</b>${data.items[0].age} </p>
                    <button onclick="readClientes.deleteById(${data.items[0].id})" type="button"> Borrar Cliente</button>
                    `);
                }
            },
            error: function () {
                alert("cliente NO encontrado");
            }
        });
    }

    static editarCliente(){
        const clientes ={
            id: $("#idCliente").val(),
            name: $("#nombreCliente").val(),
            email: $("#emailCliente").val(),
            age: $("#edadCliente").val(),
        };
        $.ajax({
            url: ApiUrl,
            type: "PUT",
            datatype: 'json',
            contentType:"application/json",
            crossDomain: true,
            data: JSON.stringify(clientes),

            complete: function (response) {
                if (response.status === 201){
                    $("#idCliente").val(""),
                    $("#nombreCliente").val(""),
                    $("#emailCliente").val(""),
                    $("#edadCliente").val(""),
                    $("#detalle-cliente").html("<p>No se ha seleccionado ningun cliente</p>");
                    readClientes.loadAll();
                    alert("cliente actualizado");
                }
                else{
                    alert("cliente NO actualizado");
                }
            }
        });
    }

    static deleteById(id){
        $.ajax({
            url: ApiUrl,
            type: "DELETE",
            datatype: 'json',
            contentType:"application/json",
            crossDomain: true,
            data: JSON.stringify({id}),

            complete: function (response) {
                if (response.status === 204){
                    readClientes.loadAll();
                    $("#detalle-cliente").html("<p>No se ha seleccionado ningun cliente</p>");
                    alert("cliente eliminado");
                }
                else{
                    alert("cliente NO eliminado")
                }
            }
        });

    }

}