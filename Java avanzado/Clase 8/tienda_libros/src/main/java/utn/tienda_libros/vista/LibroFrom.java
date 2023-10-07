package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private DefaultTableModel tableModeloLibros;


    @Autowired
    public LibroFrom(LibroServicio libroServicio){
        this.libroServicio=libroServicio;
        iniciartForma();
    }
    private void iniciartForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        //Para obtener las dimenciones de la ventana
        Toolkit toolKit=Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla=toolKit.getScreenSize();
        int x =(tamanioPantalla.width-getWidth()/2);
        int y =(tamanioPantalla.height-getHeight()/2);
        setLocation(x,y);

    }

    private void createUIComponents() {
        this.tableModeloLibros = new DefaultTableModel(0, 5);
        String[] cabecera = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tableModeloLibros.setColumnIdentifiers(cabecera); // Cambié "serColumnIdentifiers" a "setColumnIdentifiers"
        // Instanciar el objeto de JTable
        this.tablaLibros = new JTable(this.tableModeloLibros); // Usé "this.tableModeloLibros" en lugar de "tablaModeloLibros"
        listarLibros();
    }
    private void listarLibros() {
        // Limpiar la tabla
        tableModeloLibros.setRowCount(0);

        // Obtener los libros de la BD
        var libros = libroServicio.listarLibros();

        // Iteramos cada libro
        libros.forEach((libro) -> {
            Object[] renglonLibros = {
                    libro.getIdLibre(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            // Agregamos el renglón a la tabla
            tableModeloLibros.addRow(renglonLibros);
        });
    }
}