package me.alejandro;

/**
 * Ejecución del programa y propiedades relacionadas
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejecucion extends Application {
	
	@Override
	public void start(Stage ventana) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/me/alejandro/ventana/miproyectobiblioteca.fxml"));
		
		Scene scene = new Scene(root);
		
		ventana.setTitle("Programa Biblioteca");
		
		ventana.setMinHeight(100);
		ventana.setMinWidth(200);
		
		ventana.setResizable(false); // Para indicar que no se puede redimencionar
		
		// Mostrar ventana
		ventana.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
