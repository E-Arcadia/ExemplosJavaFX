package TesteJFX;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("FXMLInicial.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}


}
