var that; // almacena el contexto global del documento 
var index = {
    init:function(){
        that = this;
        console.log("Pagina inicial cargada");
        $('#btnIngresar').on('click',that.ingresarSistema);
    },
    ingresarSistema:function(){
        console.log('Intentando ingresar');
    }
};
index.init();