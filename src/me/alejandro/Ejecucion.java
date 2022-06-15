package me.alejandro;

/**
 * Ejecución del programa y propiedades relacionadas
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ejecucion extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Ejecucion.class.getResource("/ventana/miproyectobiblioteca.fxml"));
			Pane ventana = (Pane) loader.load();
			
			// Mostrar la ventana con algunas características al gusto
			Scene scene = new Scene(ventana);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Hay algún error...");
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
