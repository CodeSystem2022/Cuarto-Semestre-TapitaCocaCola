function hola(nombre,miCallback){
    setTimeout(function(){
    console.log("hola"+nombre)
    miCallback(nombre)
    }, 2000);
    
};

function hablar(callbackHablar){
    setTimeout(function() {
        console.log("blo blo blo blo blo");
        callbackHablar();
    },1000);
}

function adios(nombre,otroCallback){
    setTimeout(function(){
        console.log('adios...'+nombre)
        otroCallback();

    },2500);

}

//Funcion recursiva
function conversacion(nombre,veces,callback){
    if(veces>0){
        hablar(function(){
            conversacion(nombre,--veces,callback);
        });
    }else{
        callback(nombre,callback);
    }
}
//--proceso principal
console.log('iniciando el proceso')
hola(' Ariel',function(nombre){
    conversacion(nombre,4,function(){
        console.log('terminando el proceso') ;
    });
});

 /*   hola(' Carlos ',function(nombre){
        hablar(function(){
            hablar(function(){
                hablar(function(){
                    hablar(function(){
            adios(nombre,function(){
            console.log('terminando el proceso') ;
                 
                        });     
                    });
                });
            });     
        });
    });*/