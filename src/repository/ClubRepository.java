package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.DatabaseConnection;
import model.Club;

public class ClubRepository extends MainRepository {
	
	public ClubRepository(DatabaseConnection databaseConnection) {
		super(databaseConnection);
	}

	public List<Club> getClubByName(String name) {
		List<Club> clubList = new ArrayList<Club>();
		
		try {
			resultSet = statement.executeQuery("SELECT * FROM clubmanager.Club WHERE name = '"+name+"';");
			while(resultSet.next()){
				Club club = new Club();
				club.setIdClub(Integer.parseInt(resultSet.getString("idClub")));
				club.setIdCategory(Integer.parseInt(resultSet.getString("idCategory")));
				club.setName(resultSet.getString("name"));
				club.setTeacher(resultSet.getString("teacher"));
				club.setLocation(resultSet.getString("location"));
				clubList.add(club);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return clubList;
	}
	
	
	
}
