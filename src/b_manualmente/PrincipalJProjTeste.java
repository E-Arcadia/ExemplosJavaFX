package b_manualmente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//b_manualmente.FXMLTelaPrincipal.fxml
public class PrincipalJProjTeste extends Application{

	public static void main(String[] args) {
		System.out.println("Olá mundo!!!");
		launch(args);
//		new AbreTela().start(primaryStage);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = FXMLLoader.load(getClass().getResource("FXMLTelaPrincipal.fxml"));
		Scene scene = new Scene(pane);
		
		primaryStage.setTitle("Tela de Teste");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
