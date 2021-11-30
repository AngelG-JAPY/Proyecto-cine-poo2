<%-- 
    Document   : versala
    Created on : 27/11/2021, 10:23:28 p. m.
    Author     : USUARIO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sala</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    
    <body>
         <a class="btn btn-primary btn-lg disabled" role="button" aria-disabled="true" href="agregarsala.jsp">AgregarConfiteria</a>
        
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Sala</th>
                    <th scope="col">Asientos</th>
                    <th scope="col">Eventos</th>

                </tr>
            </thead>
            <tbody>
                
               
            </tbody>
        </table>
        <c:forEach var= "sal" items="$(sala)">
             <tr>
                 <td>$(sal.id)</td>
                 <td>$(sal.cntidad_asientos)</td>
                 <td>
                <a class="btn btn-primary btn-lg disabled" role="button" aria-disabled="true" href="$(pageContext.request.contextPath)/sala">Editar</a>
                <a class="btn btn-primary btn-lg disabled" role="button" aria-disabled="true" href="$(pageContext.request.contextPath)/sala?id">Eliminar</a>

                 </td>
                    
                    
                </tr>
            
        </c:forEach>
            </tbody>
        </table>
        
            
        <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
