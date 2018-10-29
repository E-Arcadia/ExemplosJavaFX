package TesteJFX;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class InicialController implements Initializable {
// TesteJFX.InicialController
	@FXML
	private ListView<Painel> listView;
	@FXML
	private BorderPane borderPane;

	private ArrayList<Painel> listaDePaineis = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		criaDadosListView();

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Painel>() {
			@Override
			public void changed(ObservableValue<? extends Painel> arg0, Painel arg1, Painel arg2) {
				Pane pane = carregaFXML(arg2.FXML);
				borderPane.setCenter(pane);
			}
		});
	}

	public void trataMenu(ActionEvent event) {
		String menuClicado = ((MenuItem) event.getSource()).getText();
//		System.out.println(menuClicado);
		for (Painel painel : listaDePaineis) {
			if (painel.identificacao.equals(menuClicado))
				borderPane.setCenter(carregaFXML(painel.FXML));
		}
	}

	public void sair() {
		Main.getPrimaryStage().close();
	}

	// Trata o conteúdo do CENTRO
	// ===========================

	private Pane carregaFXML(String fxml) {
		try {
			return FXMLLoader.load(getClass().getResource(fxml));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Trata o conteúdo do ListView
	// ============================

	private void criaDadosListView() {
		listaDePaineis.add(new Painel("Application", "/a_application/FXMLInicial.fxml"));
		listaDePaineis.add(new Painel("Manualmente", "/b_manualmente/FXMLTelaPrincipal.fxml"));
		listaDePaineis.add(new Painel("Combo Box", "/c_comboBox/FXMLComboBox.fxml"));
		listaDePaineis.add(new Painel("Check Box", "/d_checkBox/FXMLCheckBox.fxml"));
		listaDePaineis.add(new Painel("Radio Button", "/e_radioButton/FXML.fxml"));
		listaDePaineis.add(new Painel("Alertas", "/f_alerta/FXML.fxml"));
		listaDePaineis.add(new Painel("List View", "/g_listView/FXML.fxml"));
		listaDePaineis.add(new Painel("Table View", "/h_tableView/FXML.fxml"));
//		listaDePaineis.add(new Painel("Nova Tela","/i_novasTelas/FXML.fxml"));

		listView.setItems(FXCollections.observableArrayList(listaDePaineis));
	}

	// @Descrição: Class ENTIDADE para cada página
	private class Painel {
		private String identificacao;
		private String FXML;

		public Painel(String identificacao, String fXML) {
			super();
			this.identificacao = identificacao;
			FXML = fXML;
		}

		@Override
		public String toString() {
			return identificacao;
		}

	}
}
