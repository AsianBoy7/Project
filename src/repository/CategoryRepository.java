package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import main.DatabaseConnection;

public class CategoryRepository extends MainRepository{
	
	public CategoryRepository(DatabaseConnection databaseConnection) {
		super(databaseConnection);
		// TODO Auto-generated constructor stub
	}

	private Statement statement;
	private ResultSet resultSet;
	
	public List<Category> getAllCategories(){
		List<Category> categoryList= new ArrayList<Category>();
		try {
			resultSet=statement.executeQuery("Select * From ClubManager.Category;");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return categoryList;
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
