<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="alert alert-warning" role="alert">
           En construcción las demás vistas.
        </div>
        <a href="${pageContext.request.contextPath}/peliculas" class="btn btn-outline-secondary">Ir al listado de peliculas</a>    
        <a href="${pageContext.request.contextPath}/tarifas" class="btn btn-outline-secondary">Ir al listado de tarifas</a>
        <a href="${pageContext.request.contextPath}/programaciones" class="btn btn-outline-secondary">Ver listado de programaciones</a>
        <a href="${pageContext.request.contextPath}/usuario" class="btn btn-outline-secondary">Ver usuarios registrados</a>
    </body>
</html>
