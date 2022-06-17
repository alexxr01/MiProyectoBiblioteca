package me.alejandro;

/**
 * Clase por la cual aplicaremos las acciones a realizar
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Serializable {
	private final String mensajeError = "Ha ocurrido algún error...";
	private Libro[] libros;

	private static final long serialVersionUID = 1L;
	// Declaracion de botones en nuestro programa
	@FXML private Button botonaniadir; // Pagina principal
	@FXML private Button botonguardar; // Pagina principal
	@FXML private Button botonlimpiarcontenido; // Pagina principal
	@FXML private Button botonregistrarnuevolibro; // Pagina vista libros

	// Declaracion de campos de textos en nuestro programa
	@FXML private TextField insertarisbn; // Pagina principal
	@FXML private TextField insertartitulo; // Pagina principal
	@FXML private TextField insertarautores; // Pagina principal
	@FXML private TextField insertareditoriales; // Pagina principal
	@FXML private TextField insertarnumerospaginas; // Pagina principal

	// Declaracion de campos de fecha en nuestro programa
	@FXML private DatePicker insertarfechaedicion; // Pagina principal

	// Declaracion de tabla para mostrar elementos
	@FXML private TableView<Libro> tablamostrarlibros; // Pagina vista libros
	@FXML private TableColumn columnamostrarisbn; // Pagina vista libros
	@FXML private TableColumn columnamostrartitulo; // Pagina vista libros
	@FXML private TableColumn columnamostrarautores; // Pagina vista libros
	ObservableList<Libro> tablaLibros; // Pagina vista libros

	private int posicionTablaLibros; // Pagina vista libros

	/*
	 * ACCIONES DE BOTONES
	 */
	@FXML
	private void aniadirLibro(ActionEvent event) {
		Libro libro = new Libro(); // Recogemos datos ↙
		libro.setISBN(insertarisbn.getText());
		libro.setTitulo(insertartitulo.getText());
		libro.setNombreAutores(insertarautores.getText());
		libro.setEditorial(null);
		libro.setNumPaginas(insertarnumerospaginas.getText());
		tablaLibros.add(libro); // Añadimos los valores
		// Borrar contenido de campos
		this.insertarisbn.clear();
		this.insertartitulo.clear();
		this.insertarautores.clear();
		this.insertareditoriales.clear();
		this.insertarnumerospaginas.clear();
	}
	@FXML
	private void guardarLibro(ActionEvent event) {
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("libros.xml");
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < this.libros.length ; i++) {
				oos.writeObject(libros[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(mensajeError);
		}
	}
	@FXML
	private void limpiarRegistro(ActionEvent event) {
		insertarisbn.clear();
		insertartitulo.clear();
		insertarautores.clear();
		insertareditoriales.clear();
		insertarnumerospaginas.clear();
	}

	public FXMLDocumentController() {

	}
	@FXML
	private void initialize() {

	}

	@FXML
	private void enviarDatos() {
		this.enviarDatos();
	}

}
