console.log('Inicio del programa');//1

setTimeout(()=>{
    console.log('Primer Timeout');//5
},3000);

setTimeout(()=>{//2
    console.log('Segundo Timeout');
},0);

//3
setTimeout(()=>{
    console.log('Tercero Timeout');
},0);

console.log('Fin del programa');//3