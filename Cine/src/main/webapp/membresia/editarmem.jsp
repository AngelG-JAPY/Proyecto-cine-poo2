<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "../admin/Header.jsp" %>

        <div class="main-panel">
            <div class="row">
                <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Membresias</h4>
                            <form method="post" action="${pageContext.request.contextPath}/membresia?accion=modificar&id=${membresias.id}">
                                <label for="validationServer01" class="form-label">Digite el nuevo ID:</label>
                                <input type="text" class="form-control is-valid" value="${membresias.id}" id="id" name="id"  required>

                                <label for="validationServer01" class="form-label">Digite el nuevo nombre:</label>
                                <input type="text" class="form-control is-valid" value="${membresias.nombre}" id="nombre" name="nombre"  required>


                                <label for="validationServer01" class="form-label">Digite el nuevo valor:</label>
                                <input type="text" class="form-control is-valid" value="${membresias.valor}" id="valor" name="valor"  required>
                                <button class="btn btn-primary" type="submit">Guardar</button>
                            </form>

                        </div>
                    </div>
                </div>
                <%@include file = "../admin/Footer.jsp" %>
            </div>
    