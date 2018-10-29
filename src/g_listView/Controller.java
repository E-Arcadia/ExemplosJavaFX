package g_listView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class Controller implements Initializable {
	// g_listView.Controller

	private List<Tipos> listaTipos = new ArrayList<>();
	@FXML
	private ListView<Tipos> lvTipos;

	private void carregaTipos() {
		listaTipos.add(new Tipos(1, "Todos"));
		listaTipos.add(new Tipos(2, "Alguns"));
		listaTipos.add(new Tipos(3, "Nenhum"));
		listaTipos.add(new Tipos(4, "Quem Sabe"));

		lvTipos.setItems(FXCollections.observableArrayList(listaTipos));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregaTipos();
		
		lvTipos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tipos>() {
			
			@Override
			public void changed(ObservableValue<? extends Tipos> arg0, Tipos old_val, Tipos new_val) {
				System.out.println("Novo: "+ new_val);				
				System.out.println("Old: "+ old_val);
			}
		});
	}

}
