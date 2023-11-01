//la palabra async no es necesaria en las funciones, por que ya son asincronas
//igual proyectan una sincronia visual
async function hola (nombre) {
   return new promise (function (resolve, reject ) {
    setTimeout( function  ( ) {
        console.log( "hola" +nombre);
        resolve ( nombre); 
    }, 1000);
});
}

async function hablar (nombre) {
    return new promise (function (resolve, reject ) { //usamos la sintaxis ES6
     setTimeout( function  ( ) {
         console.log( "bla bla bla");
         resolve ( nombre); 
     }, 1000);
 });
 }

async function adios (nombre) {
    return new promise (function (resolve, reject ) {
     setTimeout( function  ( ) {
        //validamos el error o aprobacion
         console.log( "adios"+nombre);
         //if ( err) reject ("hay un error");
         resolve (); 
     }, 1000);
 });
 }

//await hola("Josefina");  // esto es una mala sintaxis
// await solo es valido dentro de una funcion asincrona
async function main(){
  let nombre =  await hola("josefina");
  await hablar();
  await hablar();
  await hablar();
  await adios(nombre);
  console.log("termina el proceso...")
}
console.log("empezamos el proceso...")
main();
console.log("esta va a ser la segunda instruccion...")



