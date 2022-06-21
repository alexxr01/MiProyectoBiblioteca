package me.alejandro.recursos;

/**
 * Clase por la cual aplicaremos las acciones a realizar
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import me.alejandro.Libro;

public class FXMLDocumentController implements Serializable {
	private String localizacionArchivoXMLLibros = "/me/alejandro/recursos/almacenamiento/libros.xml";
	private final String mensajeError = "Ha ocurrido algún error...";

	private static final long serialVersionUID = 1L;
	// Declaracion de botones en nuestro programa
	@FXML private Button botonaniadir; // Pagina principal
	@FXML private Button botonsalir; // Pagina principal
	@FXML private Button botonlimpiarcontenido; // Pagina principal
	@FXML private Button botonregistrarnuevolibro; // Pagina vista libros

	// Declaracion de campos de textos en nuestro programa
	@FXML private TextField insertarisbn; // Pagina principal
	@FXML private TextField insertartitulo; // Pagina principal
	@FXML private TextField insertarautores; // Pagina principal
	@FXML private TextField insertarnumerospaginas; // Pagina principal

	// Declaracion de campos de fecha en nuestro programa
	@FXML private DatePicker insertarfechaedicion; // Pagina principal

	// Declaracion de tabla para mostrar elementos
	@FXML private TableView<Libro> tablamostrarlibros; // Pagina vista libros
	@FXML private TableColumn<Libro, String> columnamostrarisbn; // Pagina vista libros
	@FXML private TableColumn<Libro, String> columnamostrartitulo; // Pagina vista libros
	@FXML private TableColumn<Libro, String> columnamostrarautores; // Pagina vista libros
	ObservableList<Libro> tablaLibros; // Pagina vista libros

	/*
	 * ACCIONES DE BOTONES
	 */
	@FXML
	private void aniadirLibro(ActionEvent event) {
		Libro libro = new Libro(); // Recogemos datos ↙
		libro.setISBN(insertarisbn.getText());
		libro.setTitulo(insertartitulo.getText());
		libro.setNombreAutores(insertarautores.getText());
		libro.setFechaEdicion(insertarfechaedicion.getValue());
		libro.setNumPaginas(insertarnumerospaginas.getAnchor());
		tablaLibros.add(libro); // Añadimos los valores
		botonaniadir.setDisable(false);
	}

	/*	NO UTILIZADO
	@FXML
	private void guardarLibro(ActionEvent event) {
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("/me/alejandro/recursos/libros.xml");
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < this.libros.length ; i++) {
				oos.writeObject(libros[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(mensajeError);
		}
	} */
	
	@FXML
	private void accionBotonSalir() {
	    Stage stage = (Stage) botonsalir.getScene().getWindow();
	    stage.close();
	}
	@FXML
	private void limpiarRegistro() {
		this.insertarisbn.clear();
		this.insertartitulo.clear();
		this.insertarautores.clear();
		this.insertarnumerospaginas.clear();
	}

	/*
	 * INICIALIZACIÓN DE TABLAS
	 */
	private void tablaLibros() throws ParserConfigurationException, SAXException, IOException {
		
		columnamostrarisbn.setCellValueFactory(new PropertyValueFactory<Libro,String>("ISBN"));
		columnamostrartitulo.setCellValueFactory(new PropertyValueFactory<Libro,String>("titulo"));
		columnamostrarautores.setCellValueFactory(new PropertyValueFactory<Libro,String>("nombreAutores"));
		 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document documento = builder.parse(localizacionArchivoXMLLibros);
		documento.getDocumentElement().normalize();
		ObservableList<Libro> lista = FXCollections.observableArrayList();
		NodeList nodeList = documento.getElementsByTagName("libro");
		Libro libro = new Libro();
		
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			System.out.println("\nElemento actual: " +
					nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				
				// Mostrar ISBN
				libro.setISBN(element.getElementsByTagName("isbn")
						.item(0)
						.getTextContent());
				System.out.println(element.getElementsByTagName("isbn")
						.item(0)
						.getTextContent());
				// Mostrar Titulos
				libro.setTitulo(element.getElementsByTagName("titulo")
						.item(0)
						.getTextContent());
				System.out.println(element.getElementsByTagName("titulo")
						.item(0)
						.getTextContent());
				// Mostrar Autores
				libro.setNombreAutores(element.getElementsByTagName("autores")
						.item(0)
						.getTextContent());
				System.out.println(element.getElementsByTagName("autores")
						.item(0)
						.getTextContent());
			}
			lista.add(libro);
		}
		tablamostrarlibros.setItems(lista);

	}
	
	@FXML
	private void initialize() {
		try {
			this.tablaLibros();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			System.out.println(mensajeError);
		}
	}

}
