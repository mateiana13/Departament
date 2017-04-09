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

public class ViewDepartamenteController implements Initializable {

	private DatabaseHelper databaseHelper = new DatabaseHelper();

	private LoadWindow loadWindow = new LoadWindow();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnViewAngajati;

	@FXML
	private Button btnDeleteDepartament;

	@FXML
	private Button btnUpdateDepartament;

	@FXML
	private ListView<Departament> lvDepartamente;

	@FXML
	void viewAngajati(ActionEvent event) throws IOException {
		loadWindow.closeWindow(event);
		int idDepartament = 0;
		try{
			idDepartament = lvDepartamente.getSelectionModel().getSelectedItem().getIdDepartament();
		}
		catch (Exception e)
		{
			loadWindow.createAlertWindow("Selecteaza un Departament");
		}
		Stage stage = loadWindow.loadViewAngajati(idDepartament);
		stage.show();
	}

	@FXML
	void deleteDepartament(ActionEvent event) throws SQLException {
		int idDepartament = lvDepartamente.getSelectionModel().getSelectedItem().getIdDepartament();
		removeListViewItem();
		removeDepartament(idDepartament);
	}

	@FXML
	void updateDepartament(ActionEvent event) throws IOException {
		loadWindow.closeWindow(event);
		Departament departament = lvDepartamente.getSelectionModel().getSelectedItem();
		Stage stage = loadWindow.loadUpdateDepartament(departament);
		stage.show();
	}

	@FXML
	void initialize() {
		assert btnViewAngajati != null : "fx:id=\"btnViewAngajati\" was not injected: check your FXML file 'ViewDepartamente.fxml'.";
		assert btnDeleteDepartament != null : "fx:id=\"btnDeleteDepartament\" was not injected: check your FXML file 'ViewDepartamente.fxml'.";
		assert btnUpdateDepartament != null : "fx:id=\"btnUpdateDepartament\" was not injected: check your FXML file 'ViewDepartamente.fxml'.";
		assert lvDepartamente != null : "fx:id=\"lvDepartamente\" was not injected: check your FXML file 'ViewDepartamente.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			List<Departament> listaDepartamente = getDepartamente();
			fillListView(listaDepartamente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Departament> getDepartamente() throws SQLException {
		List<Departament> listaDepartamente = new ArrayList<Departament>();
		listaDepartamente = databaseHelper.getDepartamente();
		return listaDepartamente;
	}

	public void fillListView(List<Departament> listaDepartamente) {
		lvDepartamente.getItems().addAll(listaDepartamente);
	}

	public void removeDepartament(int idDepartament) throws SQLException {
		databaseHelper.deleteDepartament(idDepartament);
	}

	public void removeListViewItem() {
		Departament temp = lvDepartamente.getSelectionModel().getSelectedItem();
		lvDepartamente.getItems().remove(temp);
	}
}