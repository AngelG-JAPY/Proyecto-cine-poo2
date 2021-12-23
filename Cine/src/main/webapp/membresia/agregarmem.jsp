<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "../admin/Header.jsp" %>

<div class="main-panel">
    <div class="row">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Membresias</h4>
                    <form method="post" action="${pageContext.request.contextPath}/membresia?accion=crear" enctype="multipart/form-data" >
                        <label for="validationServer01" class="form-label">Digite el ID</label>
                        <input type="text" class="form-control is-valid" id="id" name="id"  required>

                        <label for="validationServer01" class="form-label">Digite el Nombre:</label>
                        <input type="text" class="form-control is-valid" id="nombre" name="nombre"  required>

                        <label for="validationServer01" class="form-label">Digite el Valor</label>            
                        <input type="text" class="form-control is-valid" id="valor" name="valor"  required>

                        <button class="btn btn-primary" type="submit">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file = "../admin/Footer.jsp" %>
    </div>
