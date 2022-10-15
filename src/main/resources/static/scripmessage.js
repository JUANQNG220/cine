const ApiUrlM ="https://g05e37dc85df783-kingofringddbb.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message";

class mensaje {

    static savemensaje() {
        const mensajeconst = {
            id:$("#idmensaje").val(),
            messagetext:$("#textomensaje").val(),
        };

        $.ajax({
            url:ApiUrlM,
            type: "POST",
            datatype: "json",
            contentType: "application/json",
            crosDomain: true,
            data: JSON.stringify(mensajeconst),

            complete: function (response) {
                if (response.status === 201) {
                    $("#idmensaje").val("");
                    $("#textomensaje").val("");
                    mensaje.getMensaje();
                    alert("Mensaje adicionado!");
            } else {
                alert("Mensaje no adicionado!");
                }
            }
        });
    }

    static upmensaje() {
        const mensajeconst = {
            id:$("#idmensaje").val(),
            messagetext:$("#textomensaje").val(),
        };

        $.ajax({
            url:ApiUrlM,
            type: "PUT",
            datatype: "json",
            contentType: "application/json",
            crosDomain: true,
            data: JSON.stringify(mensajeconst),

            complete: function (response) {
                if (response.status === 201) {
                    $("#idmensaje").val("");
                    $("#textomensaje").val("");
                    mensaje.getMensaje();
                    alert("Mensaje adicionado!");
            } else {
                alert("Mensaje no adicionado!");
                }
            }
        });
    }

    static getMensaje() {
        $.ajax({
        url: ApiUrlM,
        type: "GET",
        datatype: "json",
        contentType: "application/json",
        crossDomain: true,
        
        success: function (datosm) {
            $("tbody").html("");
            for (let index = 0; index < datosm.items.length; index++) {
                $("tbody").append(`
                    <tr>
                    <td> ${datosm.items[index].messagetext} </td>
                    <td>
                        <a href="javascript:mensaje.getMensajeId(${datosm.items[index].id})"> ${datosm.items[index].id} </a>
                    </td>

                    </tr>
                    `);
                }

        }, error: function(){
                alert("mensajes no encontrados");

            }
        });

    }

    static getMensajeId (idmensaje) {
        $.ajax({
            url: ApiUrlM + "/" + idmensaje,
            type:"GET",
            datatype: "json",
            contentType: "application/json",
            crossDomain: true,
        
            success: function (datosm) {
                if(datosm.items.length === 0) {
                    alert("mensaje no encontrado");
                } else {
                    $("#detalle-mensaje").html(`
                        <p><b>id:</b> ${datosm.items[0].id} </p>        
                        <p><b>id:</b> ${datosm.items[0].messagetext} </p>
                `);
                }
            }, error:function(){
                alert("Mensaje no encontrado");
            }
            

        });

    }

    static deleteMensajeId (idmensaje) {
        $.ajax({
            url: ApiUrlM,
            type:"DELETE",
            datatype: "json",
            contentType: "application/json",
            crossDomain: true,
            data: JSON.stringify(mensajeconst),

            complete: function (response) {
                if (response.status === 204){
                    mensajes.getmensaje();
                    $("#mensaje").html("<p>No se ha seleccionado ningun mensaje</p>");
                    alert("mensaje eliminado");
                } else {
                    alert("mensaje NO eliminado");
                }
            } 
                

        });      
    }

}