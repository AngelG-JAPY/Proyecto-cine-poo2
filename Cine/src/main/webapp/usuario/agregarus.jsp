<%-- 
    Document   : agregarus
    Created on : 28/11/2021, 9:50:42 a. m.
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/usuario?accion=insertar">
            <label for="validationCustom01" class="form-label">Documento</label>
            <input type="text" class="form-control" id="documento" name="documento" required>


            <label for="validationCustom01" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>


            <label for="validationCustom01" class="form-label">Género</label>
            <input type="text" class="form-control" id="genero" name="genero" required>


            <label for="validationCustom01" class="form-label">Email</label>
            <input type="text" class="form-control" id="email" name="nombre" required>


            <label for="validationCustom01" class="form-label">Contraseña</label>
            <input type="text" class="form-control" id="contraseña" name="contraseña" required>


            <label for="validationCustom01" class="form-label">Telefono</label>
            <input type="text" class="form-control" id="telefono" name="telefono" required>


            
                <label for="membresia" class="form-label">Tipo de Membresia</label>
                <select id="membresia" class="form-select">
                    <option selected>Escoge el tipo</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            
            <button class="btn btn-primary" type="submit">guardar</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
