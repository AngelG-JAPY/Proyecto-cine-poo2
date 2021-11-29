<%-- 
    Document   : verus
    Created on : 28/11/2021, 9:50:54 a. m.
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Usuario</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>  
        <a class="btn btn-primary btn-lg" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/usuario/agregarus.jsp">Registrar Usuario</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Documento</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Género</th>
                    <th scope="col">Email</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Tipo de Membresia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usu" items="${usuarios}">
                    <tr>
                        <td>${usu.documento}</td>
                        <td>${usu.nombre}</td>
                        <td>${usu.genero}</td>
                        <td>${usu.email}</td>
                        <td>${usu.contraseña}</td>
                        <td>${usu.telefono}</td>
                        <td>${usu.membresia}</td>
                        <td>
                            <a class="btn btn-primary btn-lg" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/usuario?documento=${usu.documento}&accion=eliminar">Eliminar</a>
                            <a class="btn btn-primary btn-lg" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/usuario?documento=${usu.documento}&accion=editar">Editar</a>
                        </td>  
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
