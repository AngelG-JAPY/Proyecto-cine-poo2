<%-- 
    Document   : agregarsala
    Created on : 29/11/2021, 5:19:15 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Autor</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    </head>
    <body>
        <form method ="post" action="$(pageContext.request.contextPath)/sala?accion=AgregarConfiteria">
            <label for="validationDefault01" class="form-label">Digite el numero de asientos de la sala</label>
            <input type="text" class="form-control" id="cantidad_asientos"  name="cantidad_asientos"   required>
            <div class="valid-feedback">
             <button class="btn btn-primary" type="submit">Guardar</button>
    
        </form>
    </body>
</html>
