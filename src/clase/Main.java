package clase;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private LoadWindow loadWindow = new LoadWindow();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage = loadWindow.loadMainMenu();
		primaryStage.show();
	}
}