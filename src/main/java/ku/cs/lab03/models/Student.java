package ku.cs.lab03.models;

public class Student {
	private String id;
	private String name;
	private double score;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.score = 0;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getScore() {
		return score;
	}

	public void changeName(String name) {
		name = name.trim();
		if (!name.isEmpty())
			this.name = name;
	}

	public void addScore(double score) {
		if (score > 0) {
			this.score += score;
		}
	}

	public String grade() {
		return "F";
	}

	public boolean isId(String id) {
		return this.id.equals(id);
	}

	@Override
	public String toString() {
		return String.format("[%s] %s", id, name);
	}
}
