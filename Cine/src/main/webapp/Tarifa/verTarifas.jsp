
<%@include file = "../admin/Header.jsp" %>
<!-- partial -->
<div class="main-panel">
    <div class="row">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Usuarios registrados</h4>
                    <div class="table-responsive">
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
                        <a class="btn btn-outline-light" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/Tarifa/AgregarTarifa.jsp">Agregar tarifa</a>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file = "../admin/Footer.jsp" %>
</div>

