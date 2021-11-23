<%-- 
    Document   : AggProgramacion
    Created on : 23/11/2021, 2:24:42 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar nueva Programación</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4">
            <form method="post" action="${pageContext.request.contextPath}/peliculas?accion=registar" >
                <div class="card">
                    <div class="card-header">
                        <h3>Registro de Pelicula</h3>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <!<!-- ID -->
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="inputGroup-sizing-default">ID de la Programacion</span>
                                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="id" required>
                            </div>

                            
                            <!<!-- Fecha Inicio -->
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Fecha de Inicio</span>
                                    <input type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="fecha-inicio" required>
                                </div>
                            </div>

                            <!<!-- Fecha fin -->
                            <div class="form-group">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Duración</span>
                                    <input type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="fecha-fin" required>
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
