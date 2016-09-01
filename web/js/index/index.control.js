var indexControl = {
	login:function(data,completado){
		return __cnn.ajax({
			'url':__rout.root+'login',
			'data':data,
			'completado':completado
		});
	}
};