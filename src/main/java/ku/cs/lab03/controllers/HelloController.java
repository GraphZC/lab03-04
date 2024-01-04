package ku.cs.lab03.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.lab03.services.FXRouter;

import java.io.IOException;

public class HelloController {
	@FXML
	private Label welcomeText;

	@FXML
	protected void onHelloButtonClick() {
		try {
			FXRouter.goTo("student-list");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}