<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-24">
            <h1 class="page-header">
                Usuarios <small>Administracion tabla usuarios.</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <i class="fa fa-dashboard"></i> Registre un nuevo usuario o modifique uno existente.
                </li>
            </ol>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">Creación y modificación </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-18">
                        <div class="form-group">
                            <label for="txtNombre">Nombre</label>
                            <input type="text" class="form-control" id="txtNombre">
                        </div>
                        <div class="form-group">
                            <label for="txtCorreo">Correo</label>
                            <input type="email" class="form-control" id="txtCorreo">
                        </div>
                        <div class="form-group">
                            <label for="txtContrasena">Contraseña</label>
                            <input type="password" class="form-control" id="txtContrasena">
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <label class="form-check-label" for="cbxEstado">
                                <input type="checkbox" class="form-check-input" id="cbxEstado" value="Activo">
                                Activo</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <button id="btnGuardar" class="btn btn-success">
                                Guardar
                            </button>
                        </div>
                        <div class="form-group">
                            <button id="btnCancelar" class="btn btn-danger">
                                Cancelar
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-24">
            <table id="tablaUsuarios" class="display" cellspacing="0" width="100%">
                <thead>
                <th id="headIdUsuario">Id Usuario</th>
                <th id="headNombre">Nombre</th>
                <th id="headCorreo">Correo</th>
                <th id="headEstado">Estado</th>
                <th id="headContrasena">Contraseña</th>
                <th id="headAccion">Acción</th>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <script src="js/usuario/usuario.model.js"></script>
    <script src="js/usuario/usuario.control.js"></script>
    <script src="js/usuario/usuario.vista.js"></script>