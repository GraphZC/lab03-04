package ku.cs.lab03.controllers;

import javafx.beans.binding.DoubleExpression;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.lab03.models.Student;
import ku.cs.lab03.models.StudentList;
import ku.cs.lab03.services.FXRouter;
import ku.cs.lab03.services.StudentHardCodeDatasource;

import java.io.IOException;

public class StudentListController {
	@FXML
	private ListView<Student> studentListView;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label errorLabel;
	@FXML
	private TextField giveScoreTextField;
	private StudentList studentList;
	private Student selectedStudent;

	@FXML
	public void initialize() {
		clearStudentInfo();
		StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
		studentList = datasource.readData();
		showList(studentList);
		studentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
			@Override
			public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
				if (newValue == null) {
					clearStudentInfo();
					selectedStudent = null;
				} else {
					showStudentInfo(newValue);
					selectedStudent = newValue;
				}
			}
		});
	}

	private void showList(StudentList studentList) {
		studentListView.getItems().clear();
		studentListView.getItems().addAll(studentList.getStudents());
	}

	private void clearStudentInfo() {
		idLabel.setText("");
		nameLabel.setText("");
		scoreLabel.setText("");
		errorLabel.setText("");
	}

	private void showStudentInfo(Student student) {
		idLabel.setText(student.getId());
		nameLabel.setText(student.getName());
		scoreLabel.setText(String.format("%.2f", student.getScore()));
	}

	@FXML
	protected void onBackButtonClick() {
		try {
			FXRouter.goTo("hello");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@FXML
	protected void onGiveScoreButtonClick() {
		if (selectedStudent != null) {
			String scoreText = giveScoreTextField.getText();
			String errorMessage = "";
			try {
				double score = Double.parseDouble(scoreText);
				studentList.giveScoreToId(selectedStudent.getId(), score);
				showStudentInfo(selectedStudent);
			} catch (NumberFormatException e) {
				errorMessage = "Please insert number value";
				errorLabel.setText(errorMessage);
			} finally {
				if (errorMessage.isEmpty()) {
					giveScoreTextField.setText("");
				}
			}

		} else {
			giveScoreTextField.setText("");
			errorLabel.setText("");
		}
	}
}
