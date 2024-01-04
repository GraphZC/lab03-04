package ku.cs.lab03.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.lab03.models.Student;

public class StudentController {
	@FXML
	private Label nameLabel;

	@FXML
	public void initialize() {
		Student student = new Student("6410401078", "Tanaroeg");
		showStudent(student);
	}

	private void showStudent(Student student) {
		nameLabel.setText(student.getName());
	}
}
