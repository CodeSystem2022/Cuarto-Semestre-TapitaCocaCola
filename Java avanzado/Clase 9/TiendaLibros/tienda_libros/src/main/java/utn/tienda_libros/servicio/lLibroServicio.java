package utn.tienda_libros.servicio;

import utn.tienda_libros.modelo.Libro;
import java.util.List;

public interface lLibroServicio {
    List<Libro> listarLibros();
    Libro buscarLibroPorId(Integer idLibro);
    void guardarLibro(Libro libro);
    void eliminarLibro(Libro libro);
}
