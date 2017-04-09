package clase;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ViewAngajatiController implements Initializable {

	private LoadWindow loadWindow = new LoadWindow();

	private DatabaseHelper databaseHelper = new DatabaseHelper();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ListView<Angajat> lvAngajati;

	@FXML
	private Button bttDelteAngajat;

	@FXML
	private Button btnInsertAngajat;

	@FXML
	private Button btnUpdateAngajat;

	private int idDepartament;

	public int getIdDepartament() {
		return idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	@FXML
	void deleteAngajat(ActionEvent event) throws SQLException {
		Angajat angajat = lvAngajati.getSelectionModel().getSelectedItem();
		databaseHelper.deleteAngajat(angajat.getNumeAngajat());
		lvAngajati.getItems().remove(angajat);
	}

	@FXML
	void updateAngajat(ActionEvent event) throws IOException {
		loadWindow.closeWindow(event);
		Angajat angajat = lvAngajati.getSelectionModel().getSelectedItem();
		Stage stage = loadWindow.loadUpdateAngajat(angajat);
		stage.show();
	}

	@FXML
	void insertAngajat(ActionEvent event) throws IOException {
		loadWindow.closeWindow(event);
		Stage stage = loadWindow.loadInsertAngajat(idDepartament);
		stage.show();
	}

	@FXML
	void initialize() {
		assert lvAngajati != null : "fx:id=\"lvAngajati\" was not injected: check your FXML file 'ViewAngajati.fxml'.";
		assert bttDelteAngajat != null : "fx:id=\"bttDelteAngajat\" was not injected: check your FXML file 'ViewAngajati.fxml'.";
		assert btnInsertAngajat != null : "fx:id=\"btnInsertAngajat\" was not injected: check your FXML file 'ViewAngajati.fxml'.";
		assert btnUpdateAngajat != null : "fx:id=\"btnUpdateAngajat\" was not injected: check your FXML file 'ViewAngajati.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			List<Angajat> listaAngajati = getAngajati(getIdDepartament());
			System.out.println(listaAngajati);
			fillForm(listaAngajati);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Angajat> getAngajati(int idDepartament) throws SQLException {
		List<Angajat> listaAngajati = new ArrayList<Angajat>();
		listaAngajati = databaseHelper.getAngajati(getIdDepartament());
		return listaAngajati;
	}

	public void fillForm(List<Angajat> listaAngajati) throws Exception {
		lvAngajati.getItems().addAll(listaAngajati);
	}
}