<%-- 
    Document   : editarTarifaa
    Created on : 20/11/2021, 7:18:10 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tarifa</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/tarifas?accion=modificar&id=${tarifa.idTarifa}">
            <label for="validationCustom01" class="form-label">ID</label>
            <input type="text" class="form-control is-valid" id="id" name="id" value ="${tarifa.idTarifa}" required disabled="disabled">


            <label for="validationCustom01" class="form-label">Nombre</label>
            <input type="text" class="form-control is-valid" id="nombre" name="nombre"  value ="${tarifa.nombre}" required >

            <label for="validationCustom01" class="form-label">Ingrese el Precio</label>
            <input type="number" class="form-control is-valid" id="precio" name="precio" value="${tarifa.precio}"  required>

            <button class="btn btn-primary" type="submit">Guardar</button>
        </form>
    </body>
</html>
