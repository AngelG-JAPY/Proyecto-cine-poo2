<%-- 
    Document   : VerPeliculas
    Created on : 21/11/2021, 2:54:23 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Peliculas</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>

        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th scope="col"># ID</th>
                    <th scope="col">Pelicula</th>
                    <th scope="col">Genero</th>
                    <th scope="col">Duracion</th>
                    <th scope="col">Director</th>
                    <th scope="col">Clasificación</th>
                    <th scope="col">Cartelera</th>
                    <th scope="col">Trailer</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="peliculas" items="${peliculas}">
                    <tr>
                        <td>${peliculas.id}</td>
                        <td>${peliculas.nombre}</td>
                        <td>${peliculas.genero}</td>
                        <td>${peliculas.duracion} min</td>
                        <td>${peliculas.director}</td>
                        <td>${peliculas.clasificacion}</td>
                        <td><img src="${peliculas.cartelera}" width="75px" alt="${peliculas.nombre}"/></td>
                        <td>${peliculas.trailer}</td>  
                        <td>
                            <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/peliculas?accion=borrar&id=${peliculas.id}" role="button">Eliminar</a>
                            <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/peliculas?accion=editar&id=${peliculas.id}" role="button">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/Pelicula/AggPelicula.jsp" role="button">Agregar nueva pelicula</a>

    </body>
</html>
