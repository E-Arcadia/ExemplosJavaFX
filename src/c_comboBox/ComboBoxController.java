package c_comboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ComboBoxController implements Initializable{
	private List<Tipos> listaTipos = new ArrayList<>();

    @FXML
    private ComboBox<Tipos> cbSelecaoQualquer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregaTipos();
		
	}
	
	
	private void carregaTipos() {
		listaTipos.add(new Tipos(1, "Todos"));
		listaTipos.add(new Tipos(2, "Alguns"));
		listaTipos.add(new Tipos(3, "Nenhum"));
		listaTipos.add(new Tipos(4, "Quem Sabe"));
		
		cbSelecaoQualquer.setItems(FXCollections.observableArrayList(listaTipos));
	}
    
    
}
