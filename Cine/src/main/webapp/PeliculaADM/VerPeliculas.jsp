
<%@include file = "../admin/Header.jsp" %>
<!-- partial -->
<div class="main-panel">
    <div class="row">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Peliculas registradas</h4>
                    <div class="table-responsive">
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
                                <c:forEach var="peliculasADM" items="${peliculasADM}">
                                    <tr>
                                        <td>${peliculasADM.id}</td>
                                        <td>${peliculasADM.nombre}</td>
                                        <td>${peliculasADM.genero}</td>
                                        <td>${peliculasADM.duracion} min</td>
                                        <td>${peliculasADM.director}</td>
                                        <td>${peliculasADM.clasificacion}</td>
                                        <td><img src="${peliculasADM.cartelera}" width="75px" alt="${peliculasADM.nombre}"/></td>
                                        <td>${peliculasADM.trailer}</td>  
                                        <td>
                                            <a class="btn btn-outline-light" href="${pageContext.request.contextPath}/peliculaAMD?accion=borrar&id=${peliculasADM.id}" role="button">Eliminar</a>
                                            <a class="btn btn-outline-light" href="${pageContext.request.contextPath}/peliculaAMD?accion=editar&id=${peliculasADM.id}" role="button">Editar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <a class="btn btn-outline-light" href="${pageContext.request.contextPath}/peliculaAMD/AggPelicula.jsp" role="button">Agregar nueva pelicula</a>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file = "../admin/Footer.jsp" %>
</div>