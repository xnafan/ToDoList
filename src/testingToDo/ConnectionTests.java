package testingToDo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import dataAccessLayer.TaskDataAccessLayerMsSql;
import modelLayer.Task;

class ConnectionTests {

	@Test
	void test() {
		TaskDataAccessLayerMsSql DAL_layer = TaskDataAccessLayerMsSql.getInstance();
		try {
			Task task = DAL_layer.findTaskById(1);
			Assert.assertEquals(task.getId(), 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
