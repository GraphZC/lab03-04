package ku.cs.lab03.models;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> students;

	public StudentList() {
		students = new ArrayList<>();
	}

	public void addNewStudent(String id, String name) {
		id = id.trim();
		name = name.trim();

		// Check id and name is not null
		if (!id.isEmpty() && !name.isEmpty()) {
			Student exist = findStudentById(id);
			if (exist == null)  {
				Student student = new Student(id, name);
				students.add(student);
			}
		}
	}

	public Student findStudentById(String id) {
		for (Student student : students) {
			if (id.equals(student.getId())) {
				return student;
			}
		}
		return null;
	}

	public void giveScoreToId(String id, double score) {
		Student student = findStudentById(id);

		if (student != null) {
			student.addScore(score);
		}
	}

	public String viewGradeOfId(String id) {
		Student student = findStudentById(id);

		if (student != null) {
			return student.grade();
		}

		return null;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
}
