package me.alejandro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorDOM {
	private Document documento;
	
	public static void main(String[] args) {
		
	}
	
	public GeneradorDOM() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		documento = builder.newDocument();
	}
	
	public void generarDocumento() {
		Element libros = documento.createElement("libros");
		documento.appendChild(libros);
		Element libro = documento.createElement("libro");
		documento.appendChild(libro);
	}
	
	public void generarXML() throws IOException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		
		Source source = new DOMSource(documento);
		File archivo = new File("/me/alejandro/almacenamiento/testXML.xml");
		FileWriter escribir = new FileWriter(archivo);
		PrintWriter lectura = new PrintWriter(escribir);
		Result result = new StreamResult(lectura);
		
		transformer.transform(source, result);
		
	}

}
