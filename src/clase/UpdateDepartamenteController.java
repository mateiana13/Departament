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

public class UpdateDepartamenteController implements Initializable {

	private LoadWindow loadWindow = new LoadWindow();

	private DatabaseHelper databaseHelper = new DatabaseHelper();
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tfDenumireDepartament;

	@FXML
	private TextField tfNumarAngajati;

	@FXML
	private Button btnUpdateDepartament;

	private Departament departament;

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	@FXML
	void modifyDepartament(ActionEvent event) throws SQLException, IOException {
		try {
			updateDepartament();
			loadWindow.closeWindow(event);
		}
		catch (Exception e){
			loadWindow.createAlertWindow("Date Incorecte");
		}
		Stage stage = loadWindow.loadViewDepartamente();
		stage.show();
	}

	@FXML
	void initialize() {
		assert tfDenumireDepartament != null : "fx:id=\"tfDenumireDepartament\" was not injected: check your FXML file 'UpdateDepartament.fxml'.";
		assert tfNumarAngajati != null : "fx:id=\"tfNumarAngajati\" was not injected: check your FXML file 'UpdateDepartament.fxml'.";
		assert btnUpdateDepartament != null : "fx:id=\"btnUpdateDepartament\" was not injected: check your FXML file 'UpdateDepartament.fxml'.";
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fillForm();
	}

	public void fillForm() {
		tfDenumireDepartament.setText(departament.getDenumireDepartament());
		tfNumarAngajati.setText(departament.getNumarAngajati() + "");
	}

	public void updateDepartament() throws SQLException,Exception {
		String denumireDepartamentNou = tfDenumireDepartament.getText();
		int numarAngajatiNou = Integer.parseInt(tfNumarAngajati.getText());
		databaseHelper.updateDepartament(departament.getIdDepartament(), denumireDepartamentNou, numarAngajatiNou);
	}
}