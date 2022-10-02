package clases;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
	private Label tituloLabel;
	private TextField numeroText;
	private Button comprobarButton;
	private VBox root;
	
	int n_aleatorio = (int) (Math.random() * 100) + 1;
	int intentos=0;
	int entrada;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		tituloLabel = new Label();
		tituloLabel.setText("Introduce un valor del 1 al 100");
		
		numeroText = new TextField();
		numeroText.setText("Introduce un valor");
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setOnAction(this::comprobarNumero);
		comprobarButton.setDefaultButton(true);
		
		root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(tituloLabel, numeroText, comprobarButton);
		root.setFillWidth(false);
		root.setSpacing(5);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void comprobarNumero(ActionEvent e) {
		try {
			entrada = Integer.parseInt(numeroText.getText());
		} catch (NumberFormatException excep) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");

			alert.showAndWait();
			
			numeroText.clear();
        }
		
		if(entrada<=0 || entrada >= 100) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");

			alert.showAndWait();
			
			numeroText.clear();
		
		}else if(entrada > n_aleatorio) {
			intentos++;
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El número es menor que " + entrada);

			alert.showAndWait();
			
			numeroText.clear();
			
		}else if(entrada < n_aleatorio) {
			intentos++;
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El número es mayor que " + entrada);

			alert.showAndWait();
			
			numeroText.clear();
		
		}else {
			intentos++;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("Has acertado en "+ intentos + " intentos. Vuelve a jugar para mejorar la puntuación");

			alert.showAndWait();
			intentos = 0;
			n_aleatorio = (int) (Math.random() * 100) + 1;
			
			numeroText.clear();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}