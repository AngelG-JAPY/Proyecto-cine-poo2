<%@include file = "../admin/Header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main-panel">
        <div class="row">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Membresias</h4>
                    <div class="table-responsive">
                        <a class="btn btn-outline-light" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/membresia/agregarmem.jsp">Agregar Membresia</a>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Valor</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="membresias" items="${membresias}">
                                    <tr>
                                        <td>${membresias.id}</td>
                                        <td>${membresias.nombre}</td>
                                        <td>${membresias.valor}</td>
                                        <td>
                                            <a class="btn btn-outline-danger" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/membresia?id=${membresias.id}&accion=eliminar">Eliminar</a>
                                            <a class="btn btn-outline-danger" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/membresia?id=${membresias.id}&accion=editar">Editar</a>
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
