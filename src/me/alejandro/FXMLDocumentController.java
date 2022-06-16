package me.alejandro;

import java.io.Serializable;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * Controlador de FXML para el programa
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Declaracion de botones en nuestro programa
	@FXML private Button botonaniadir;
	@FXML private Button botonguardar;
	@FXML private Button botonlimpiarcontenido;
	@FXML private Button registrarunlibro;
	
	// Declaracion de campos de textos en nuestro programa
	@FXML private TextField insertarisbn;
	@FXML private TextField insertartitulo;
	@FXML private TextField insertarautores;
	@FXML private TextField insertareditoriales;
	@FXML private TextField insertarnumerospaginas;
	
	// Declaracion de campos de fecha en nuestro programa
	@FXML private DatePicker insertarfechaedicion;
	
	// Declaracion de tabla para mostrar elementos
	@FXML private TableView<Libro> tablamostrarlibros;
	@FXML private TableColumn columnamostrarisbn;
	@FXML private TableColumn columnamostrartitulo;
	@FXML private TableColumn columnamostrarautores;
	ObservableList<Libro> libros;
	
	private int posicionTablaLibros;
	
	/*
	 * ACCIONES DE BOTONES
	 */
	@FXML
	private void aniadirLibro(ActionEvent event) {
		insertarisbn.setText("");
		insertartitulo.setText("");
		insertarautores.setText("");
		insertareditoriales.setText("");
		insertarnumerospaginas.setText("");
	}
	@FXML
	private void guardarLibro(ActionEvent event) {
		Libro libro = new Libro();
		libro.setISBN(insertarisbn.getText());
		libro.setTitulo(insertartitulo.getText());
		libro.setNombreAutores(insertarautores.getText());
		libro.setEditorial(null);
		libro.setNumPaginas(insertarnumerospaginas.getText());
		libros.add(libro);
	}
	@FXML
	private void limpiarRegistro(ActionEvent event) {
		
	}
	
	private void iniciarTablaLibros() {
		
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
