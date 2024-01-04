package ku.cs.lab03;

import javafx.application.Application;
import javafx.stage.Stage;
import ku.cs.lab03.services.FXRouter;

import java.io.IOException;

public class HelloApplication extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		final double WIDTH = 800;
		final double HEIGHT = 600;

		FXRouter.bind(this, stage, "6410401078 - Lab03", WIDTH, HEIGHT);
		configRoute();
		FXRouter.goTo("hello");
	}

	private static void configRoute() {
		final String VIEW_PATH = "ku/cs/lab03/views/";

		FXRouter.when("hello", VIEW_PATH + "hello-view.fxml");
		FXRouter.when("student", VIEW_PATH + "student.fxml");
		FXRouter.when("student-list", VIEW_PATH + "student-list.fxml");
	}

	public static void main(String[] args) {
		launch();
	}
}