package e_radioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {
	// e_radioButton.Controller

    @FXML
    private ToggleGroup grupo;

    @FXML
    void verificaRadioButton(ActionEvent event) {
    	RadioButton radioButton = (RadioButton) grupo.getSelectedToggle();
    	System.out.println(radioButton.getText());
    }
    
}
