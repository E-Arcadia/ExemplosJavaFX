package ProgressBar;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class InicialController implements javafx.fxml.Initializable {
	@FXML
	private Button btn_ArquivoCSV;
	@FXML
	private Button btn_ArquivoJSON;
	@FXML
	private Button btn_Converter;
	@FXML
	private ProgressBar PrB_Proecesso;
	@FXML
	private TextArea txtA_Status;

	private File fileCSV;
	private File fileJSON;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn_Converter.setDisable(true);
//		txtA_Status.setWrapText(true);

	}

	@FXML //////////////////////////////////////////
	private void ArquivoCSV(ActionEvent event) {
		btn_Converter.setDisable(true);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Arquivo CSV para conversão");
		fileCSV = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
		if (fileCSV != null)
			txtA_Status.appendText("\nARQUIVO DE ORIGEM: " + fileCSV.toString());
		verificaSeArquivosSelecionados();
	}

	@FXML //////////////////////////////////////////
	private void ArquivoJSON(ActionEvent event) {
		btn_Converter.setDisable(true);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Arquivo JSON para salvar");
		fileJSON = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
		if (fileJSON != null)
			txtA_Status.appendText("\nARQUIVO DE DESTINO: " + fileJSON.toString());
		verificaSeArquivosSelecionados();

	}

	@FXML
	private void Converter(ActionEvent event) {

		btn_Converter.setDisable(true);

		Task task = new Task<Void>() {
			@Override
			public Void call() {
				final int max = 100000000;
				int centena = 0;
				for (int i = 1; i <= max; i++) {
					if (isCancelled()) {
						break;
					}
					updateProgress(i, max);

					if (i % 100 == 0) {
						updateMessage("Processados: " + ++centena);
					}
				}
				return null;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				updateMessage("Done!");
			}

			@Override
			protected void cancelled() {
				super.cancelled();
				updateMessage("Cancelled!");
			}

			@Override
			protected void failed() {
				super.failed();
				updateMessage("Failed!");
			}
		};

		task.messageProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> obs, String oldMessage, String newMessage) {
				txtA_Status.setText(task.getMessage());
			}
		});

		PrB_Proecesso.progressProperty().bind(task.progressProperty());
		new Thread(task).start();

	}

	public void verificaSeArquivosSelecionados() {
		if (fileCSV != null & fileJSON != null) {
			btn_Converter.setDisable(false);
		}
	}

}
