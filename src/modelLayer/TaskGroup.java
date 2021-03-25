package modelLayer;

import java.util.ArrayList;

public class TaskGroup {
	
	private int id;
	private String name;
	private ArrayList<Task> tasks = new ArrayList<Task>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}