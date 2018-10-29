package i_novasTelas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {
// testeJFX.PrincipalController

	@FXML
	private Button btSair;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btSair.setOnMouseClicked((MouseEvent e) -> {
			fechar();
		});

		btSair.setOnKeyPressed((KeyEvent e) -> {
			if (e.getCode() == KeyCode.ENTER)
				fechar();
		});
	}

	private void fechar() {
		System.out.println("Sair");
		Principal.getPrimaryStage().close();
	}

	@FXML
	void abreListView(ActionEvent event) {
		g_listView.Principal listView = new g_listView.Principal();
		listView.start(new Stage());
//		fechar();
		
	}

}
