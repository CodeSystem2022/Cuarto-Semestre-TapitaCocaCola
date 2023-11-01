//this == global =true

//mostar algo en la consola
//console.log()

//mostar un mensaje en forma de error

//console.error()

//Ejecutar un codigo despues de un intervalo de tiempo

//setTimeout(()=>{});

//Ejecutar un codigo cada intervalo de tiempo

//setInterval(()=>{});

//Da prioridad de ejecucion a una funcion asincronica

//setImmdiate(()=>{});

//console.log(setInterval); 

/*let i=0;
let intervalo=setInterval(()=>{
    console.log('Hola');
    if(i==3){
        clearInterval(intervalo);
    }
    i++;

},1000);*/

setImmediate(()=>{
    console.log('Saludos inmediatos');

})

//require();

console.log(__dirname);

global.miVariable='Mi variable global';

console.log(miVariable);