var that;
var homeVista = {
	init:function(){
        console.log('Vista de inicio cargada!')
		that = this;
		that.activarSidebar();
	},
    activarSidebar:function(){
        $("#navBar").find(".item").on('click',that.cargarVista);
    },
    cargarVista:function(){
        var seleccionado = $(this).attr('id')
        var html = '';
        switch(seleccionado){
            case 'itemUsuario':
                html = 'vistas/usuario.jsp';
                break;
            case 'itemAmortizacion':
                html = 'vistas/amortizacion.jsp';
                break;
        }
        $('.container-fluid').empty().load(html);
    }
};
homeVista.init();