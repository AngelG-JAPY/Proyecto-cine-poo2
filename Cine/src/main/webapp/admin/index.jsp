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
                                <c:forEach var="usuarios" items="${usuarios}">
                                    <tr>
                                        <td>${usuarios.id_usuario}</td>
                                        <td>${usuarios.nombre}</td>
                                        <td>${usuarios.genero}</td>
                                        <td>${usuarios.email}</td>
                                        <td>${usuarios.contrasenia}</td>
                                        <td>${usuarios.telefono}</td>
                                        <td>${usuarios.membresia.id}</td>
                                        <td>
                                            <a class="btn btn-primary btn-lg" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/usuario?documento=${usuarios.id_usuario}&accion=eliminar">Eliminar</a>
                                            <a class="btn btn-primary btn-lg" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/usuario?documento=${usuarios.id_usuario}&accion=editar">Editar</a>
                                        </td>  
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file = "../admin/Footer.jsp" %>
</div>


