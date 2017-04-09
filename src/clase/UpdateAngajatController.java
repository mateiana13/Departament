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

public class UpdateAngajatController implements Initializable {

	private LoadWindow loadWindow = new LoadWindow();

	private DatabaseHelper databaseHelper = new DatabaseHelper();

	private Angajat angajat;

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tfSalariuAngajat;

	@FXML
	private TextField tfNumeAngajat;

	@FXML
	private TextField tfPrenumeAngajt;

	@FXML
	private TextField tfFunctieAngajat;

	@FXML
	private Button btnUpdateAngajat;

	@FXML
	void updateAngajat(ActionEvent event) throws SQLException, IOException {
		loadWindow.closeWindow(event);
		try{
			update(createAngajat());
		}
		catch (Exception e){
			loadWindow.createAlertWindow("Date Incorecte");
		}
		Stage stage = loadWindow.loadViewAngajati(getAngajat().getIdDepartament());
		stage.show();
	}

	@FXML
	void initialize() {
		assert tfSalariuAngajat != null : "fx:id=\"tfSalariuAngajat\" was not injected: check your FXML file 'UpdateAngajat.fxml'.";
		assert tfNumeAngajat != null : "fx:id=\"tfNumeAngajat\" was not injected: check your FXML file 'UpdateAngajat.fxml'.";
		assert tfPrenumeAngajt != null : "fx:id=\"tfPrenumeAngajt\" was not injected: check your FXML file 'UpdateAngajat.fxml'.";
		assert tfFunctieAngajat != null : "fx:id=\"tfFunctieAngajat\" was not injected: check your FXML file 'UpdateAngajat.fxml'.";
		assert btnUpdateAngajat != null : "fx:id=\"btnUpdateAngajat\" was not injected: check your FXML file 'UpdateAngajat.fxml'.";

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fillForm(getAngajat());
	}

	public Angajat createAngajat() throws Exception {
		Angajat angajat = new Angajat();
		String numeAngajat = tfNumeAngajat.getText();
		String prenumeAngajat = tfPrenumeAngajt.getText();
		double salariuAngajat = Double.parseDouble(tfSalariuAngajat.getText().toString());
		String cnpAngajat = getAngajat().getCnpAngajat();
		String functieAngajat = tfFunctieAngajat.getText();
		angajat.setNumeAngajat(numeAngajat);
		angajat.setPrenumeAngajat(prenumeAngajat);
		angajat.setSalariuAngajat(salariuAngajat);
		angajat.setCnpAngajat(cnpAngajat);
		angajat.setFunctieAngajat(functieAngajat);
		return angajat;
	}

	public void update(Angajat angajat) throws SQLException,Exception {
		databaseHelper.updateAngajat(angajat.getCnpAngajat(), angajat.getNumeAngajat(), angajat.getPrenumeAngajat(),
				angajat.getSalariuAngajat(), angajat.getFunctieAngajat());
	}

	public void fillForm(Angajat angajat) {
		tfNumeAngajat.setText(angajat.getNumeAngajat());
		tfPrenumeAngajt.setText(angajat.getPrenumeAngajat());
		tfSalariuAngajat.setText(angajat.getSalariuAngajat() + "");
		tfFunctieAngajat.setText(angajat.getFunctieAngajat());
	}
}