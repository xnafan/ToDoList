package dataAccessLayer;

import java.util.ArrayList;
import java.util.Properties;

import modelLayer.Task;

import java.sql.*;

public class TaskDataAccessLayerMsSql implements TaskDataAccessLayer {

	//private variables
		private Connection connection;
		private static final String FIND_TASK_BY_ID = "SELECT ID, Title, Description, Done, TaskGroupId FROM Task WHERE ID = ?";
		private static final String FIND_ALL_TASKS = "SELECT ID, Title, Description, Done, TaskGroupId FROM Task";
		private PreparedStatement psFindTaskById, psFindAllTasks;

		//Singleton implementation
	private static TaskDataAccessLayerMsSql instance;
	public static TaskDataAccessLayerMsSql getInstance() {		
		if(instance == null) {instance = new TaskDataAccessLayerMsSql();}
		return instance;	
		}
	private TaskDataAccessLayerMsSql() {
		
		
		   // Create a variable for the connection string.
       // String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";

        try  {
        	connection = DataBaseConnectionSql.getInstance().getConnection();
        	psFindTaskById = connection.prepareStatement(FIND_TASK_BY_ID);
        	psFindAllTasks = connection.prepareStatement(FIND_ALL_TASKS);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
				
	};
	
	
	
	
	
	
	public Task findTaskById(int id) throws SQLException {
		Task foundTask = null;
		psFindTaskById.setString(1, Integer.toString(id));
		ResultSet resultSet = psFindTaskById.executeQuery();
		
		if(resultSet.next())
		{
			foundTask = convertResultSetToTask(resultSet);
		}
		
		return foundTask;
	}

	private Task convertResultSetToTask(ResultSet resultSet) throws SQLException
	{
		return new Task(resultSet.getInt("id"), resultSet.getString("Title"), resultSet.getString("Description"), resultSet.getBoolean("Done"));		
	}

	public ArrayList<Task> getAllTasks() throws SQLException	{
		
		ArrayList<Task> foundTasks = new ArrayList<Task>();
		
		ResultSet resultSet = psFindAllTasks.executeQuery();
		
		while(resultSet.next())
		{
			foundTasks.add(convertResultSetToTask(resultSet));
		}
		
		return foundTasks;
	}
	
	public void saveTask(Task task)  throws SQLException	{
		// TODO Auto-generated method stub

	}

	public void deleteTask(Task task)  throws SQLException	{
		// TODO Auto-generated method stub

	}

	public ArrayList<Task> findTasksByPartOfTitleOrDescription(String searchString)  throws SQLException	{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Task> findTasksByPartGroupName(String groupName)  throws SQLException	{
		// TODO Auto-generated method stub
		return null;
	}
}
