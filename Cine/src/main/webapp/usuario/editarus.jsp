

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Perfil</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/usuarios?accion=modificar&documento=${usuarios.id_usuario}">
            <label for="validationCustom01" class="form-label">Digite el documento</label>
            <input type="text" class="form-control" value="${usuarios.id_usuario}" id="documento" name="documento" required>
            
            
            <label for="validationCustom01" class="form-label">Digite el nombre</label>
            <input type="text" class="form-control" value="${usuarios.nombre}" id="nombre" name="nombre" required>
            
            
            <label for="validationCustom01" class="form-label">Digite el Género</label>
            <input type="text" class="form-control" value="${usuarios.genero}" id="genero" name="genero" required>
            
            
            <label for="validationCustom01" class="form-label">Digite el email</label>
            <input type="text" class="form-control" value="${usuarios.email}" id="email" name="email" required>
            
            
            <label for="validationCustom01" class="form-label">Digite el contraseña</label>
            <input type="text" class="form-control" value="${usuarios.contrasenia}" id="contrasenia" name="contraseña" required>
            
            
            <label for="validationCustom01" class="form-label">Digite el telefono</label>
            <input type="text" class="form-control" value="${usuarios.telefono}" id="telefono" name="telefono" required>
            
            
            <div class="col-md-4">
                <label for="inputMem" class="form-label">Tipo de Membresia</label>
                <select id="id_membresia" class="form-select" value="${usuarios.membresia.id}" name="id_membresia" required>
                    <option selected>Escoge el tipo</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>
            <button class="btn btn-primary" type="submit">Guardar</button>
        </form>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
