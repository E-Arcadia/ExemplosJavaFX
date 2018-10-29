package a_application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InicialController {
    @FXML
    private Button btMostra;

    @FXML
    private TextField tfEntrada;

    @FXML
    private Label lbMensagem;

    @FXML
    private void mostra(ActionEvent event) {
    	lbMensagem.setText("Olá "+ tfEntrada.getText());

    }
	
}


