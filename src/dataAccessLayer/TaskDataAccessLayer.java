package dataAccessLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modelLayer.Task;

public interface TaskDataAccessLayer {
	
	Task findTaskById(int id)  throws SQLException;
	ArrayList<Task> findTasksByPartOfTitleOrDescription(String searchString)  throws SQLException;
	ArrayList<Task> findTasksByPartGroupName(String groupName)  throws SQLException;
	ArrayList<Task> getAllTasks()  throws SQLException;
	void saveTask(Task task)  throws SQLException;
	void deleteTask(Task task)  throws SQLException;
}
