package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField LibroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField ecistenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tableModeloLibros;


    @Autowired
    public LibroFrom(LibroServicio libroServicio){
        this.libroServicio=libroServicio;
        iniciartForma();
        agregarButton.addActionListener(e -> agregarLibro());
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
    private void agregarLibro() {
        // Leer los valores del formulario
        if (LibroTexto.getText().equals("")) {
            mostrarMensaje("Ingresa el nombre del libro");
            LibroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = LibroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(precioTexto.getText());
        var existencias = Integer.parseInt(ecistenciasTexto.getText());
        var libro = new Libro(null, nombreLibro, autor, precio, existencias);
        // libro.setNombreLibro(nombreLibro);
        // libro.setAutor(autor);
        // libro.setPrecio(precio);
        // libro.setExistencias(existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agregó el libro...");
        limpiarFormulario();
        listarLibros();
    }

    private void limpiarFormulario(){
        LibroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        ecistenciasTexto.setText("");

    }
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
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