package utn.tienda_libros.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.repositorio.LibroRepositorio;

import java.util.List;

@Service
public class LibroServicio implements  ILibroServicio{
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();//regresa todos los libros en la tabla de la base de datos
    }

    @Override
    public Libro buscarLibroPorid(Integer idLibro) {
        Libro libro = libroRepositorio.findById(idLibro).orElse(null);//recibe el id y sino recibe devuelve un null
        return libro;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
    libroRepositorio.delete(libro);

    }
}
