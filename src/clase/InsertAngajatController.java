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

public class InsertAngajatController implements Initializable {

	private LoadWindow loadWindow = new LoadWindow();

	private DatabaseHelper databaseHelper = new DatabaseHelper();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tfPrenumeAngajat;

	@FXML
	private TextField tfSalariuAngajat;

	@FXML
	private TextField tfNumeAngajat;

	@FXML
	private TextField tfCnpAngajat;

	@FXML
	private TextField tfFunctieAngajat;

	@FXML
	private Button btnInsertAngajat;

	private int idDepartament;

	public int getIdDepartament() {
		return idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	@FXML
	void insertAngajat(ActionEvent event) throws SQLException, IOException {
		loadWindow.closeWindow(event);
		try {
			databaseHelper.insertAngajat(getIdDepartament(), createAngajat());
		}
		catch (Exception e) {
			loadWindow.createAlertWindow("Date Incorecte");
		}
		Stage stage = loadWindow.loadViewAngajati(getIdDepartament());
		stage.show();
	}

	@FXML
	void initialize() {
		assert tfPrenumeAngajat != null : "fx:id=\"tfPrenumeAngajat\" was not injected: check your FXML file 'InsertAngajat.fxml'.";
		assert tfSalariuAngajat != null : "fx:id=\"tfSalariuAngajat\" was not injected: check your FXML file 'InsertAngajat.fxml'.";
		assert tfNumeAngajat != null : "fx:id=\"tfNumeAngajat\" was not injected: check your FXML file 'InsertAngajat.fxml'.";
		assert tfCnpAngajat != null : "fx:id=\"tfCnpAngajat\" was not injected: check your FXML file 'InsertAngajat.fxml'.";
		assert tfFunctieAngajat != null : "fx:id=\"tfFunctieAngajat\" was not injected: check your FXML file 'InsertAngajat.fxml'.";
		assert btnInsertAngajat != null : "fx:id=\"btnInsertAngajat\" was not injected: check your FXML file 'InsertAngajat.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public Angajat createAngajat() throws Exception {
		Angajat angajat = new Angajat();
		String numeAngajat = tfNumeAngajat.getText();
		String prenumeAngajat = tfPrenumeAngajat.getText();
		double salariuAngajat = Double.parseDouble(tfSalariuAngajat.getText().toString());		
		String cnpAngajat = tfCnpAngajat.getText();
		String functieAngajat = tfFunctieAngajat.getText();
		angajat.setNumeAngajat(numeAngajat);
		angajat.setPrenumeAngajat(prenumeAngajat);
		angajat.setSalariuAngajat(salariuAngajat);
		angajat.setCnpAngajat(cnpAngajat);
		angajat.setFunctieAngajat(functieAngajat);
		return angajat;
	}
}