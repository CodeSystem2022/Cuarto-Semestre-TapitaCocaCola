package UTN.datos;
import UTN.dominio.Estudiante;
import static UTN.Conexion.conexion.getConnection;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class EstudianteDAO {
    //Metodo listar
    public List<Estudiante> listarEstudiantes () {
        List<Estudiante> estudiantes = new ArrayList<>();
        //Creamos algunos objetos que son necesarios para comunicarnos con la base de datos
        PreparedStatement ps; //envia la sentencia a la base de datos
        ResultSet rs; //obtenemos el resultado de la base de datos
        //creamos un objeto tipo conexion
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022 ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){

                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("Nombre"));
                estudiante.setApellido(rs.getString("Apellido"));
                estudiante.setTelefono(rs.getString("Telefono"));
                estudiante.setEmail(rs.getString("Email"));
                //Falta agregarlo a la lista
                estudiantes.add(estudiante);


            }
        } catch (Exception e) {
            System.out.println("Ocurrio un Errror al seleccionar datos" + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch(Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion " +e.getMessage());
            }
        } //fin finally
        return estudiantes;
    }//fin metodo listar

    //metodo por id  -> fin by id
    public boolean buscarEstudiantesporid(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SeELECT * FROM estudiantes2022 WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("Nombre"));
                estudiante.setApellido(rs.getString("Apellido"));
                estudiante.setTelefono(rs.getString("Telefono"));
                estudiante.setEmail(rs.getString("Email"));
                return true; //se encontro un registro

            } //fin if
        } catch (Exception e) {
            System.out.println("Ocurrio un error al buscar estudiante:" + e.getMessage());

        } //fin catch
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("ocurrio un error al cerrar conexion:" + e.getMessage());

            }//fin catch
        }//fin finally
        return false;
    }
    //Metodo agregar un nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES(?, ?, ?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute();
            return true;

        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar el estudiante" +e.getMessage());

        } //fin catch
        finally {
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar la conexion:" +e.getMessage());
            } //fin catch
        } //fin finally
        return false;
    } //fin metodo agregarEstudiante

    //metodo para modificar
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch(Exception e){
            System.out.println("Error al modificar estudiante"+e.getMessage());

        }//fin catch
        finally {
            try {
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion" +e.getMessage());
            }//fin  catch
        } //fin finally
        return false;
    } //fin metodo modificarEstudiante
    public  boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2022 WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("error al eliminar estudiante:"+e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexion:"+e.getMessage());
            }
        }
        return false;
    }

           public static void main(String[]arg){
                var estudianteDao = new EstudianteDAO();
        //modificar estudiante
                var estudianteModificado = new Estudiante(1,"juan", "perez","98765435","perez@gmailxom");
                var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
                if(modificado)
                    System.out.println("estudiante modificado"+estudianteModificado);
                else
                    System.out.println("no se modifico el estudiante"+estudianteModificado);


                //Listar los estudiantes
                System.out.println("Listado de estudiantes");
                List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println); //funcion lambda para imprimir

                //Agregar estudiante

                //var nuevoEstudiante = new Estudiante("Carlos", "lara", "545677545", "carlos@gmailcom");
                //var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
                //if(agregado)
                  //  System.out.println("Estudiante agregado:"+nuevoEstudiante);
                //else
                  //  System.out.println("no se ha ahgregado estudiante:"+nuevoEstudiante);

               //Eliminar estudiante con id 3
               var estudianteEliminar = new Estudiante(1);
               var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
               if(eliminado)
                   System.out.println("Estudiante eliminado:"+estudianteEliminar);
               else
                   System.out.println("No se elimino estudiante:"+estudianteEliminar);

               //listar los estudiantes
               System.out.println("Listado de estudiantes: ");
               List<Estudiante> estudiante = estudianteDao.listarEstudiantes();
               estudiantes.forEach(System.out::println); //funcion lamba para imprimir

                //buscar por id
                //var estudiante1 = new Estudiante(1);
                //System.out.println("Estudiantes antes de la busqueda:" +estudiante1);
                //var encontrado= estudianteDao.buscarEstudiantesporid(estudiante1);
               // if(encontrado) {
                    //System.out.println("Estudiante encontrado: " + estudiante1);
               // }
                  //  else{
                   // System.out.println("no se encontro el estudiante:" + estudiante1.getIdEstudiante());
                //}
            }

        }
