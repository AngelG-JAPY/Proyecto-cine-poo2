<%-- 
    Document   : VerProgramacion
    Created on : 23/11/2021, 2:21:37 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Programaciones</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th scope="col"># ID</th>
                    <th scope="col">Fecha Inicio</th>
                    <th scope="col">Fecha Fin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="programacion" items="${programacion}">
                    <tr>
                        <th>${programacion.idProgramacion}</th>
                        <td>${programacion.fechaInicio}</td>
                        <td>${programacion.fechaFin}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Programacion/AggProgramacion.jsp" role="button">Agregar nueva programacion</a>
    </body>
</html>
