package repository;

import java.sql.ResultSet;
import java.sql.Statement;

import main.DatabaseConnection;

public class MainRepository {
	private DatabaseConnection databaseConnection;
	protected Statement statement;
	protected ResultSet resultSet;
	
	public MainRepository(DatabaseConnection databaseConnection){
		this.databaseConnection = databaseConnection;
		statement = databaseConnection.getStatement();
	}
	
	public DatabaseConnection getDatabaseConnection() {
		return databaseConnection;
	}

	public void setDatabaseConnection(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
}
