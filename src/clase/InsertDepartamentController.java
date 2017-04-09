package clase;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InsertDepartamentController implements Initializable {

	private DatabaseHelper databaseHelper = new DatabaseHelper();

	private LoadWindow loadWindow = new LoadWindow();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tfDenumireDepartament;

	@FXML
	private TextField tfNumarAngajati;

	@FXML
	private Button btnInsertDepartament;

	@FXML
	void insertDepartament(ActionEvent event) throws SQLException, IOException {
		loadWindow.closeWindow(event);
		try{
			insert();
		}
		catch (Exception e) {
			loadWindow.createAlertWindow("Date Incorecte");
		}
		Stage stage = loadWindow.loadMainMenu();
		stage.show();
	}

	@FXML
	void initialize() {
		assert tfDenumireDepartament != null : "fx:id=\"tfDenumireDepartament\" was not injected: check your FXML file 'InsertDepartament.fxml'.";
		assert tfNumarAngajati != null : "fx:id=\"tfNumarAngajati\" was not injected: check your FXML file 'InsertDepartament.fxml'.";
		assert btnInsertDepartament != null : "fx:id=\"btnInsertDepartament\" was not injected: check your FXML file 'InsertDepartament.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void insert() throws SQLException,Exception {
		Departament departament = new Departament();
		String denumireDepartament = tfDenumireDepartament.getText();
		int numarAngajati = Integer.parseInt(tfNumarAngajati.getText().toString());
		departament.setDenumireDepartament(denumireDepartament);
		departament.setNumarAngajati(numarAngajati);
		databaseHelper.insertDepartament(departament);
	}
}