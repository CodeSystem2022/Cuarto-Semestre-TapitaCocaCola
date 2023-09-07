package UTN;
import UTN.Conexion.conexion;
import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;

import java.sql.SQLOutput;
import java.util.Scanner;


public class SistemaEstudianteApp {
    public static void main(String[ ]arg){
        var salir = false;
        var consola = new Scanner(System.in); //leer informacion de la consola
        //creamos una instancia de la clase servicio, se hace fuera de ciclo
        var estudianteDao = new EstudianteDAO(); //esta instancia debe hacerse una vez
        while(!salir){
            try{
                mostrarMenu(); //este sera el metodo que devolvera un booleano
                salir = ejecutarOpciones(consola, estudianteDao); //este arroja una excepcion
            } catch(Exception e){
                System.out.println("Ocurrio un error al ejecutar la operacion:" +e.getMessage());
            }
        }//fin while
    }//fin main

    private static void mostrarMenu(){
        System.out.println("""
                ***Sistema de Estudiantes***
                1. Listar Estudiantes
                2. Buscar Estudiantes
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salie 
                Elige una opcion:
                """);

    }
    //Metodo para ejecutar las opciones, va a regresar un valor booleano, ya que es el que
    //puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private static boolean ejecutarOpciones(Scanner consola,EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> { //listar estudiantes
                System.out.println("Listado de Estudiantes");
                //no muestra la info, solo recupera la info y regresa una lista
                var estudiantes = estudianteDAO.listarEstudiantes(); //recibe el listado
                //vamos a iterar cada objeto de tipo estudiantes
                estudiantes.forEach(System.out::println); //para imprimir la lista
            } //fin caso 1
            case 2 ->{ //buscar estudiante por id
                System.out.println("Introduce el id estudiante a buscar");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantesporid(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrado:"+estudiante);
                else
                    System.out.println("Estudiante No encontrado:"+estudiante);
            }//fin caso 2
            case 3 -> { //Agregar Estudiante
                System.out.println("Agregar estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var Apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var Telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //crear objeto estudiante(sin id)
                var estudiante = new Estudiante(nombre,Apellido, Telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante Agregado:"+estudiante);
                else
                    System.out.println("Estudiante No Agregado: "+estudiante);

            }//fin caso 3
            //case 4 ->{ //Modificar estudiante
                //System.out.println("Modificar estudiante: ");
                //Aqui lo primero especificar cual es el objeto a modificar
                //System.out.println("id Estudiante: ");
              //  var idEstudiante = Integer.parseInt(consola.nextLine());
                //System.out.println("Nombre: ");
                //var nombre = consola.nextLine();
                //System.out.println("Apellido: ");
                //var apellido = consola.nextLine();
                //System.out.println("Telefono: ");
                //var telefono = consola.nextLine();
                //System.out.println("email");
                //var email = consola.nextLine();
                //crea el objeto estudiante a modificar
                //var estudiante =
                  //      new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                //var modificado = EstudianteDAO.modificarEstudiante(estudiante);
                //if(modificado)
                    //System.out.println("Estudiante Modificado:"+estudiante);
                ///else
                   // System.out.println("Estudiante no modificado");
            //}//fin caso 4

            //caso 4 prueba
            case 4 -> { // modificar estudiante
                System.out.println("Modificar estudiante: ");
                // Asegúrate de especificar cuál es el objeto DAO a modificar
                EstudianteDAO EstudianteDAO = new EstudianteDAO();
                System.out.println("id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("email");
                var email = consola.nextLine();
                // crea el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if (modificado)
                    System.out.println("Estudiante Modificado:" + estudiante);
                else
                    System.out.println("Estudiante no modificado");
            }
            //caso 4 prueba
            case 5 -> { //eliminar estudiante
                System.out.println("Eliminar estudiante: ");
                System.out.println("id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado:"+estudiante);
                else
                    System.out.println("Estudiante No eliminado:"+estudiante);
            }//fin caso 5
            case 6 -> { //salir
                System.out.println("Hasta Pronto!!!");
                salir = true;
            } // fin caso 6
            default -> System.out.println("Opcion no reoconocida, ingrese otra opcion");
        }//fin switch
        return salir;

    }
}
