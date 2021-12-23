<%-- 
    Document   : EditarPelicula
    Created on : 21/11/2021, 2:54:30 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4">
            <form method="post" action="${pageContext.request.contextPath}/peliculas?accion=modificar&id=${pelicula.id}" >
                <div class="card">
                    <div class="card-header">
                        <h3>Editar Pelicula</h3>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            
                             <!<!-- id -->
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-default">ID de la Pelicula</span>
                                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="id" value="${pelicula.id}" required disabled="disabled">
                            </div>
                             
                            <!<!-- nombre -->
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-default">Nombre de la Pelicula</span>
                                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="nombre" value="${pelicula.nombre}"required>
                            </div>
                            
                            <!<!-- cartelera -->
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" id="inputGroupFile02" name="cartelera" value="${pelicula.cartelera}" >
                                <label class="input-group-text" for="inputGroupFile02">Cartelera</label>
                            </div>

                            <!<!-- Genero -->
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Genero/s</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="genero" value="${pelicula.genero}" required>
                                </div>
                            </div>

                            <!<!-- Duración -->
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Duración</span>
                                    <input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="duracion" value="${pelicula.duracion}" required>
                                </div>
                            </div>

                            <!<!-- Director -->
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Director</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="director" value="${pelicula.director}" required>
                                </div>
                            </div>

                            <!<!-- Clasificación -->
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Clasificación</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="clasificacion" value="${pelicula.clasificacion}" required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary" type="submit">Guardar</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
