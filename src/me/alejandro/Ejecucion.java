package me.alejandro;

import java.io.IOException;

/**
 * Ejecución del programa y propiedades relacionadas
 * @author Alejandro Ruiz Bonillo
 * @version 1.0
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Ejecucion extends Application {
	private String titulo, version;
	{
		// Propidades básicas del programa
		titulo = "Programa Biblioteca";
		version = "1.3.10";
	}
	
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Ejecucion.class.getResource("/me/alejandro/recursos/miproyectobiblioteca.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		
		// Titulo, icono y redimensionable
		stage.setTitle(titulo + " - " + "v" + version);
		Image iconoVentana = new Image("/me/alejandro/recursos/icono.png");
		stage.getIcons().add(iconoVentana);
		stage.setResizable(false);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		System.out.println("El programa se está ejecutando...");
		launch();
		System.out.println("\n\nHa salido del programa exitosamente.\nVuelva pronto!");
	}

}
