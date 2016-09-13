var that = null;
var usuarioVista = {
	init:function(){
		that = this;
		that.cargarTablaUsuarios();
		$('#btnGuardar').on('click',that.guardarUsuario);
		$('#btnCancelar').on('click',that.cancelarTarea);
		console.log('Vista de usuarios cargada');
	},
	cargarTablaUsuarios:function(){
		// solicitud de ajax
		usuarioControl.consultarUsuarios(that.cargarTablaUsuariosCompletado);
	},
	cargarTablaUsuariosCompletado:function(data){
		if (data.codigo === 1) {
			usuarioModel.datosUsuario = data.datos;
			var tabla = $('#tablaUsuarios tbody');
			for (var i = 0; i < usuarioModel.datosUsuario.length; i++) {
				var usuario = usuarioModel.datosUsuario[i];
				var fila = $('<tr>');
				// se inserta una nueva celda en la fila
				fila.append(
					$('<td>').html(usuario.idUsuario)
				);
				fila.append(
					$('<td>').html(usuario.nombre)
				);
				fila.append(
					$('<td>').html(usuario.correo)
				);
				fila.append(
					$('<td>').html(usuario.estado)
				);
				fila.append(
					$('<td>').html(usuario.contrasena)
				);
				fila.append(
					$('<td>').append(
						$('<button>').addClass('btn btn-info btnEditar')
						.attr('data-id',usuario.idUsuario)
						.text('Editar')
					)
				);
				tabla.append(fila);
			}
			$('#tablaUsuarios').find('.btnEditar').on('click',that.editarUsuario);
			$('#tablaUsuarios').DataTable();
			return;
		}
		console.log(data.mensaje);
	},
	editarUsuario:function(){
		var data = {
			idUsuario:$(this).attr('data-id')
		};
		usuarioControl.consultarUsuarioEditar(data,that.editarUsuarioCompletado);
	},
	editarUsuarioCompletado:function(data){
		
		if (data.codigo === 1) {
			usuarioModel.usuarioActual = data.datos;
			$('#txtNombre').val(usuarioModel.usuarioActual.nombre);
			$('#txtCorreo').val(usuarioModel.usuarioActual.correo);
			$('#txtContrasena').val(usuarioModel.usuarioActual.contrasena);
			$('#cbxEstado').prop('checked',usuarioModel.usuarioActual.estado);
			usuarioModel.usuarioEditar = 1;
			$('#btnGuardar').empty().html('Actualizar').removeClass('btn-success').addClass('btn-info');
		}
		console.log(data.mensaje);	
	},
	// eventos click de los botones en el metodo init
	guardarUsuario:function(){
		
		console.log(usuarioModel.usuarioEditar);
		switch(usuarioModel.usuarioEditar){
			case 1:
				that.actualizarUsuario();
				break;
			default:
				that.guardarNuevoUsuario();
				break
		}
	},
	cancelarTarea:function(){

	},
	actualizarUsuario:function(){
		var data = {
			idUsuario:usuarioModel.usuarioActual.idUsuario,
			nombre:$('#txtNombre').val(),
			correo:$('#txtCorreo').val(),
			contrasena:$('#txtContrasena').val(),
			estado:$('#cbxEstado').prop('checked')
		};

		usuarioControl.editarUsuario(data,that.actualizarUsuarioCompletado);
	},
	actualizarUsuarioCompletado:function(data){
		
		if (data.codigo === 1) {
			$('#modalTitle').empty().html('Actualización de Usuario');
			$('#modalMsg').empty().html(data.mensaje);
			$('#ventanaDialog').modal();
			that.limpiarTabla();
			that.cargarTablaUsuarios();
			that.limpiarFormulario();
			$('#btnGuardar').empty().html('Guardar').removeClass('btn-info').addClass('btn-success');
			usuarioModel.usuarioEditar = 0;
			return;
		};
		console.log(data.mensaje);
	},
	guardarNuevoUsuario:function(){
		var data = {
			nombre:$('#txtNombre').val(),
			correo:$('#txtCorreo').val(),
			contrasena:$('#txtContrasena').val(),
			estado:$('#cbxEstado').prop('checked')
		};
		usuarioControl.registrarUsuario(data,that.actualizarUsuarioCompletado);
	},
	limpiarTabla:function(){
		$('#tablaUsuarios tbody').empty();
	},
	limpiarFormulario:function(){
		$('#txtNombre').val(''),
		$('#txtCorreo').val(''),
		$('#txtContrasena').val(''),
		$('#cbxEstado').prop('checked',false);
	}
};
usuarioVista.init();