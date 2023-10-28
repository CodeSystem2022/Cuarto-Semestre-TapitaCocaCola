//La palabra async no es necesaria en las funciones, porque ya son asincronas
//Igual proyectan una sincronia visual
async function hola(nombre){
    return new Promise(function(resolve,reject){
        setTimeout(function(){
            console.log("hola "+nombre)
            resolve(nombre)
            }, 1000);
    });
    
};

async function hablar(nombre){
    return new Promise((resolve,reject)=>{
        setTimeout(function() {
            console.log("blo blo blo blo blo");
            resolve(nombre);
        },1000);
    });
}

async function adios(nombre){
    return new Promise((resolve,reject)=>{
        setTimeout(function(){
            console.log('adios... '+nombre)
         //   resolve();
            reject('Hay un error');
        },1500);
    })

}

// await hola('Ariel'); //Esto es una mala sintaxis no se debe utilizar
//aweit solo es valido dentro de una funcion asincrona
async function main(){
   let nombre= await hola('Ariel');
   await hablar();
   await hablar();
   await hablar();
   await adios(nombre);
   console.log('Terminar el proceso..')
}
//console.log('Empezamos el proceso...')
//main();
//console.log('Esta va a ser la segunda instruccion')

async function hello(name) {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            console.log("hello " + name);
            resolve(name);
        }, 1000);
    });
}

async function speak(name) {
    return new Promise((resolve, reject) => {
        setTimeout(function() {
            console.log("blo blo blo blo blo");
            resolve(name);
        }, 1000);
    });
}

async function goodbye(name) {
    return new Promise((resolve, reject) => {
        setTimeout(function() {
            console.log('goodbye... ' + name);
            //   resolve();
            reject('There is an error');
        }, 1500);
    });
}

// await hello('Ariel'); // This is incorrect syntax and should not be used.
// 'await' is only valid within an asynchronous function.

async function main() {
    let name = await hello('Ariel');
    await speak(name);
    await speak(name);
    await speak(name);
    await goodbye(name);
    console.log('Finishing the process...');
}

console.log('Starting the process...');
main();
console.log('This will be the second statement.');
