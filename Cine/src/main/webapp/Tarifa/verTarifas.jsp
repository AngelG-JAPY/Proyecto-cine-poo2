<%-- 
    Document   : verTarifas
    Created on : 20/11/2021, 4:25:21 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarifas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Día</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tarifa" items="${tarifa}">
                    <tr>
                        <td>${tarifa.idTarifa}</td>
                        <td>${tarifa.nombre}</td>
                        <td>${tarifa.precio}</td>
                        <td>
                            <a class="btn btn-outline-danger" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/tarifas?id=${tarifa.idTarifa}&accion=eliminar">Eliminar</a>
                            <a class="btn btn-outline-danger" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/tarifas?id=${tarifa.idTarifa}&accion=editar">Editar</a>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-outline-dark" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/Tarifa/AgregarTarifa.jsp">Agregar tarifa</a>


        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
