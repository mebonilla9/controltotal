var usuarioControl = {
	consultarUsuarios:function(completado){
		return __cnn.ajax({
			'url':__rout.root+'usuario/consultar',
			'completado':completado
		});
	},
	consultarUsuarioEditar:function(data,completado){
		return __cnn.ajax({
			'data':data,
			'url':__rout.root+'usuario/buscar',
			'completado':completado
		});
	},
	editarUsuario:function(data,completado){
		return __cnn.ajax({
			'data':data,
			'url':__rout.root+'usuario/editar',
			'completado':completado
		});
	},
	registrarUsuario:function(data,completado){
		return __cnn.ajax({
			'data':data,
			'url':__rout.root+'usuario/insertar',
			'completado':completado
		});
	}
};