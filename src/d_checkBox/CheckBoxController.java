package d_checkBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class CheckBoxController {
	
    @FXML
    private CheckBox checkBoxPodeFazer;

    @FXML
    private CheckBox checkBoxVerificarAntes;

    @FXML
    private Button btVerifica;

    @FXML
    void realizaVerificacao(ActionEvent event) {
    	System.out.println(checkBoxPodeFazer.selectedProperty().getValue());
    	System.out.println(checkBoxVerificarAntes.selectedProperty().getValue());

    }
}
