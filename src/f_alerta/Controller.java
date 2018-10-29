package f_alerta;

import java.util.ArrayList;
import java.util.List;

import c_comboBox.Tipos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

public class Controller {
	// f_alerta.Controller

    @FXML
    void verificaAlerta(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Titulo");
    	alert.setHeaderText("Texto de Cabeçalho");
    	alert.setContentText("Texto de Conteúdo");
    	alert.show();
    }

    @FXML
    void verificaAlerta01(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION,"Verificou?",ButtonType.OK);
    	alert.showAndWait().ifPresent(response -> {
    	     if (response == ButtonType.OK) {
    	         System.out.println("OK precionado!!!");
    	     }
    	 });
    }
    
    @FXML
    void textImputDialog(ActionEvent event){
    	TextInputDialog textInputDialog = new TextInputDialog("Digite seu nome: ");
    	textInputDialog.showAndWait().ifPresent(retorno -> {
    		System.out.println(retorno);
    	});
    }
    
    @FXML
    void choiceDialog(ActionEvent event){
    	List<Tipos> listaTipos = new ArrayList<>();
    	Tipos tipo = new Tipos(1, "Todos");
    	listaTipos.add(tipo);
		listaTipos.add(new Tipos(2, "Alguns"));
		listaTipos.add(new Tipos(3, "Nenhum"));
		listaTipos.add(new Tipos(4, "Quem Sabe"));
		
		ChoiceDialog<Tipos> choiseDialog = new ChoiceDialog<Tipos>(tipo,listaTipos);
		choiseDialog.showAndWait().ifPresent(retorno -> {
    		System.out.println(retorno);
    	});
    }
}
