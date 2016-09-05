var that; // almacena el contexto global del documento 
var indexVista = {
    init:function(){
        that = this;
        console.log("Pagina inicial cargada");
        $('#formLogin').on('submit',that.ingresarSistema);
    },
    ingresarSistema:function(e){
        e.preventDefault();
        //console.log('Intentando ingresar');
        var data = {
        	correo:$('#txtUsuario').val(),
            contrasena:$('#txtPassword').val()
        };
        // invocacion del metodo login del script index.control.js
        indexControl.login(data,that.ingresarSistemaCompletado);
    },
    ingresarSistemaCompletado:function(data){
        if(data.codigo == 1){
            window.location = 'home';
            return;
        }
        $('#fallaLogin').html('').removeClass('alert-danger');
        $('#fallaLogin').html(data.mensaje).addClass('alert-danger').slideDown('fast');
        indexModel.tiempoErrorLogin = setTimeout(that.esconderAlertaErrorLogin,2500);
    },
    esconderAlertaErrorLogin:function(){
        clearTimeout(indexModel.tiempoErrorLogin);
        $('#fallaLogin').slideUp('fast');
        indexModel.tiempoErrorLogin = {};
    }
};
indexVista.init();