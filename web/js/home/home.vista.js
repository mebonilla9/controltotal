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
            case 'itemVisitas':
                html = 'vistas/visitas.jsp';
                break;
        }
        $('.container-fluid').empty().load(html);
        that.actualizarFocoMenu($(this));
    },
    actualizarFocoMenu:function(elemento){
        $("#navBar").find(".item").removeClass('active-item-nav');
        elemento.addClass('active-item-nav');
    }
};
homeVista.init();