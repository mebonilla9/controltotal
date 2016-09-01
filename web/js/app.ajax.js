var __cnn = {
	myError:null,
    ajax:function(args) {
        var result;
        var defecto = {
            'url':args.url,
            'data':(args.data)?args.data:null,
            'type': (args.metodo)?args.metodo : 'POST',
            'async': (args.async!==null || args.async!==undefined)?args.async:true,
            'dataType': (args.tipo)?args.tipo:'json',
            'success': (args.async!==undefined && args.async===false)?function(data){result = data;  }:args.completado,
            'error': (args.error)?args.error:this.capturarError,
            'beforeSend': (!args.background)?console.log('cargando'):null,
            'timeout':180000000
        };
        $.ajax(defecto);
        if(result !== undefined){
            return result;
        }
        else{
            if(__cnn.myError!==null){
                return __cnn.myError.responseText;
            }
        }
    },
    capturarError:function(_error) {
        __cnn.myError = _error;
    }
};