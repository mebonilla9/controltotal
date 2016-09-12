<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-24">
            <h1 class="page-header">
                Visitas <small>Contador de visitas de la aplicación.</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-dashboard"></i> Permite verificar la cantidad de visitas.
                </li>
            </ol>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="panel panel-warning">
            <div class="panel-heading">Visitas Generadas</div>
            <div class="panel-body">
                <p> Contador de visitas </p>
                <ul class="list-group">
                <c:forEach var="visita" items="${applicationScope.visitas}">
                    <li class="list-group-item">${visita.key} <span class="badge">${visita.value}</span></li>
                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
