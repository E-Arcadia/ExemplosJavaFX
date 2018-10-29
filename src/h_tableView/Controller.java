package h_tableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
// h_tableView.Controller

	@FXML
	private TableView<Tipos> table;

	@FXML
	private TableColumn<Tipos, Integer> colID;

	@FXML
	private TableColumn<Tipos, String> colDescricao;

	private List<Tipos> listaTipos = new ArrayList<>();
	private Tipos itemSelecionado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		carregaTipos();
		atualizaTabela();

		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tipos>() {

			@Override
			public void changed(ObservableValue<? extends Tipos> observable, Tipos oldValue, Tipos newValue) {
				itemSelecionado = newValue;
			}
		});
	}

	private void atualizaTabela() {
//		ObservableList<Tipos> observableList = FXCollections.observableArrayList(listaTipos);
//		table.setItems(observableList);
		table.setItems(FXCollections.observableArrayList(listaTipos));
	}

	private void carregaTipos() {
		listaTipos.add(new Tipos(1, "Todos"));
		listaTipos.add(new Tipos(2, "Alguns"));
		listaTipos.add(new Tipos(3, "Nenhum"));
		listaTipos.add(new Tipos(4, "Quem Sabe"));
	}

	public void excluir() {
		if (itemSelecionado != null) {
			listaTipos.remove(itemSelecionado);
			atualizaTabela();
			(new Alert(AlertType.INFORMATION, "Excluído com Sucesso!", ButtonType.OK)).show();
		} else {
			(new Alert(AlertType.WARNING, "Selecione um Tipo para Excluir.", ButtonType.OK)).show();
		}
	}

	public void restauraTipos() {
		if (listaTipos != null)
			listaTipos.clear();
		carregaTipos();
		atualizaTabela();
	}
	
	public void adicionaTipos() {
		carregaTipos();
		atualizaTabela();
	}

}
