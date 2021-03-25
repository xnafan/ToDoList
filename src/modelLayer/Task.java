package modelLayer;

public class Task {
	
	private int id;
	private String title;
	private String description;
	private Boolean done;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Task(int id, String title, String description, Boolean done) {
		setId(id);
		setTitle(title);
		setDescription(description);
		setDone(done);
	}
}