package clase;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

	private LoadWindow loadWindow = new LoadWindow();

	private DatabaseHelper databaseHelper = new DatabaseHelper();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnInserDepartament;

	@FXML
	private Button btnCreateDatabase;

	@FXML
	private Button btnViewDepartamente;

	@FXML
	private Button btnDeleteDatabase;

	@FXML
	private Button btnExit;

	@FXML
	void createDatabase(ActionEvent event) throws SQLException {
		databaseHelper.createDatabase();
	}

	@FXML
	void insertDepartament(ActionEvent event) throws IOException {
		loadWindow.closeWindow(event);
		Stage stage = loadWindow.loadInsertDepartament();
		stage.show();
	}

	@FXML
	void viewDepartamente(ActionEvent event) throws IOException {
		loadWindow.closeWindow(event);
		Stage stage = loadWindow.loadViewDepartamente();
		stage.show();
	}

	@FXML
	void deleteDatabase(ActionEvent event) throws SQLException {
		databaseHelper.deleteDatabase();
	}

	@FXML
	void exit(ActionEvent event) {
		loadWindow.closeWindow(event);
	}

	@FXML
	void initialize() {
		assert btnInserDepartament != null : "fx:id=\"btnInserDepartament\" was not injected: check your FXML file 'MainMenu.fxml'.";
		assert btnCreateDatabase != null : "fx:id=\"btnCreateDatabase\" was not injected: check your FXML file 'MainMenu.fxml'.";
		assert btnViewDepartamente != null : "fx:id=\"btnViewDepartamente\" was not injected: check your FXML file 'MainMenu.fxml'.";
		assert btnDeleteDatabase != null : "fx:id=\"btnDeleteDatabase\" was not injected: check your FXML file 'MainMenu.fxml'.";
		assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'MainMenu.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}