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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private  JTextField idTexto;
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
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });
        modificarButton.addActionListener(e-> modificarLibro());

        eliminarButton.addActionListener(e-> eliminarLibro());
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

    private void cargarLibroSeleccionado() {
        // Obtenemos el índice de la fila seleccionada
        int filaSeleccionada = tablaLibros.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtenemos los valores de las columnas y los asignamos a los componentes correspondientes
            String idLibro = tablaLibros.getModel().getValueAt(filaSeleccionada, 0).toString();
            idTexto.setText(idLibro);

            String nombreLibro = tablaLibros.getModel().getValueAt(filaSeleccionada, 1).toString();
            LibroTexto.setText(nombreLibro);

            String autor = tablaLibros.getModel().getValueAt(filaSeleccionada, 2).toString();
            autorTexto.setText(autor);

            String precio = tablaLibros.getModel().getValueAt(filaSeleccionada, 3).toString();
            precioTexto.setText(precio);

            String existencias = tablaLibros.getModel().getValueAt(filaSeleccionada, 4).toString();
            ecistenciasTexto.setText(existencias);
        }
    }
    private void modificarLibro() {
        if (idTexto.getText().isEmpty()) {
            mostrarMensaje("Debes seleccionar un registro en la tabla");
        } else {
            if (LibroTexto.getText().isEmpty()) {
                mostrarMensaje("Digite el nombre del libro");
                LibroTexto.requestFocusInWindow();
                return;
            }

            // Llenamos el objeto Libro a actualizar
            int idLibro = Integer.parseInt(idTexto.getText());
            String nombreLibro = LibroTexto.getText();
            String autor = autorTexto.getText();
            double precio = Double.parseDouble(precioTexto.getText());
            int existencias = Integer.parseInt(ecistenciasTexto.getText());

            Libro libro = new Libro(idLibro, nombreLibro, autor, precio, existencias);
            libroServicio.guardarLibro(libro); // Asumiendo que existe un método actualizarLibro en el servicio
            mostrarMensaje("Se modificó el libro...");
            limpiarFormulario();
            listarLibros();
        }
    }
private void eliminarLibro(){
        var renglon=tablaLibros.getSelectedRow();
        if(renglon!=-1){
            String idLibro=tablaLibros.getModel().getValueAt(renglon,0).toString();
            var libro=new Libro();
            libro.setIdLibre(Integer.parseInt(idLibro));
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro "+idLibro+" ELIMINADO");
            limpiarFormulario();
            listarLibros();
        }
        else {
            mostrarMensaje("No se ha seleccionado ningun libro de la tabla a eliminar");
        }
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
        idTexto=new JTextField("");
        idTexto.setVisible(false);
        this.tableModeloLibros = new DefaultTableModel(0, 5){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabecera = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tableModeloLibros.setColumnIdentifiers(cabecera); // Cambié "serColumnIdentifiers" a "setColumnIdentifiers"
        // Instanciar el objeto de JTable
        this.tablaLibros = new JTable(this.tableModeloLibros); // Usé "this.tableModeloLibros" en lugar de "tablaModeloLibros"
        //Evitamos que se seleccionen varios registros
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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