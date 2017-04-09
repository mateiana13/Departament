package clase;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class LoadWindow {

	public Stage loadMainMenu() throws IOException {
		Stage stage = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
		Parent parent = fxmlLoader.load();
		stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Main Menu");
		return stage;
	}

	public void closeWindow(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
	
	public void createAlertWindow(String message){
		Alert alert = new Alert(AlertType.ERROR,message);
		alert.setTitle("Eroare");
		alert.setResizable(false);
		alert.initModality(Modality.APPLICATION_MODAL);
		
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		 stage.setAlwaysOnTop(true);
		 stage.toFront();
		
		alert.show();
	}

	public Stage loadInsertDepartament() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InsertDepartament.fxml"));
		Parent parent = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Insert Departament");
		backToMainMenu(stage);
		return stage;
	}

	public Stage loadViewDepartamente() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewDepartamente.fxml"));
		Parent parent = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("View Departamente");
		backToMainMenu(stage);
		return stage;
	}

	public Stage loadUpdateDepartament(Departament d) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateDepartament.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> arg0) {
				if (arg0 == UpdateDepartamenteController.class) {
					UpdateDepartamenteController updateDepartamenteController = new UpdateDepartamenteController();
					updateDepartamenteController.setDepartament(d);
					return updateDepartamenteController;
				} else {
					try {
						return arg0.newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				return arg0;
			}
		});
		Parent parent = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Update Departament");
		backToViewDepartamente(stage);
		return stage;
	}

	public Stage loadInsertAngajat(int idDepartament) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InsertAngajat.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				if (param == InsertAngajatController.class) {
					InsertAngajatController insertAngajatController = new InsertAngajatController();
					insertAngajatController.setIdDepartament(idDepartament);
					return insertAngajatController;
				} else {
					try {
						return param.newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				return param;
			}
		});
		Parent parent = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Insert Angajat");
		backToViewAngajati(stage, idDepartament);
		return stage;
	}

	public Stage loadViewAngajati(int idDepartament) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAngajati.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				if (param == ViewAngajatiController.class) {
					ViewAngajatiController viewAngajatiController = new ViewAngajatiController();
					viewAngajatiController.setIdDepartament(idDepartament);
					return viewAngajatiController;
				} else {
					try {
						return param.newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				return param;
			}
		});
		Parent parent = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("View Angajati");
		backToViewDepartamente(stage);
		return stage;
	}

	public Stage loadUpdateAngajat(Angajat angajat) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateAngajat.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				if (param == UpdateAngajatController.class) {
					UpdateAngajatController updateAngajatController = new UpdateAngajatController();
					updateAngajatController.setAngajat(angajat);
					return updateAngajatController;
				} else {
					try {
						return param.newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				return param;
			}
		});
		Parent parent = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Update Angajat");
		backToViewAngajati(stage, angajat.getIdDepartament());
		return stage;
	}

	public void backToMainMenu(Stage stage) {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					Stage stage = new Stage();
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("Main Menu");
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void backToViewDepartamente(Stage stage) throws IOException {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewDepartamente.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					Stage stage = new Stage();
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("View Departamente");
					stage.show();
					backToMainMenu(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void backToViewAngajati(Stage stage, int idDepartament) {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAngajati.fxml"));
				fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
					@Override
					public Object call(Class<?> param) {
						if (param == ViewAngajatiController.class) {
							ViewAngajatiController viewAngajatiController = new ViewAngajatiController();
							viewAngajatiController.setIdDepartament(idDepartament);
							return viewAngajatiController;
						} else {
							try {
								return param.newInstance();
							} catch (InstantiationException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
						}
						return param;
					}
				});
				try {
					Parent parent = fxmlLoader.load();
					Stage stage = new Stage();
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("View Angajati");
					stage.show();
					backToViewDepartamente(stage);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}