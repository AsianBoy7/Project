package main;
import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/clubmanager?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1é2ö3ó";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DatabaseConnection() {
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            setStatement(connection.createStatement());
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Connection not established!");
        	System.out.println(e.getMessage());
        }
    }

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
