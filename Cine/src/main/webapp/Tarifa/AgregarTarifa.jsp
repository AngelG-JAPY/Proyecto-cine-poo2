<%-- 
    Document   : AgregarTarifa
    Created on : 20/11/2021, 4:50:00 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir Tarifa</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/tarifas?accion=registrar" method="post">

            <select class="form-select" aria-label="Default select example" id="dia" name="dia">
                <option selected>Día</option>
                <option value="Lunes">Lunes</option>
                <option value="Martes">Martes</option>
                <option value="Miercoles">Miércoles</option>
                <option value="Jueves">Jueves</option>
                <option value="Viernes">Viernes</option>
                <option value="Sabado">Sabado</option>
                <option value="Domingo">Domingo</option> 
            </select>
            
            <label for="validationCustom01" class="form-label">Ingresar Precio</label>
            <input type="number" class="form-control is-valid" id="precio" name="precio"  required>

            <button class="btn btn-primary" type="submit">Guardar</button>
        </form>
    </body>
</html>
