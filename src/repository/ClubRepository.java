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

	public Club getClubByName(String name) {
		Club club = new Club();
		try {
			resultSet = statement
					.executeQuery("SELECT * FROM clubmanager.club WHERE name = '"+name+"';");
			resultSet.next();
			club.setIdClub(Integer.parseInt(resultSet.getString("idClub")));
			club.setCategory(resultSet.getString("category"));
			club.setName(resultSet.getString("name"));
			club.setTeacher(resultSet.getString("teacher"));
			club.setLocation(resultSet.getString("location"));
			club.setDescription(resultSet.getString("description"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return club;
	}

	public List<Club> getClubsByTeacher(String teacher) {
		List<Club> clubList = new ArrayList<Club>();

		try {
			resultSet = statement.executeQuery("SELECT * FROM clubmanager.club WHERE teacher = '"
							+ teacher + "';");
			while (resultSet.next()) {
				Club club = new Club();
				club.setIdClub(Integer.parseInt(resultSet.getString("idClub")));
				club.setCategory(resultSet.getString("category"));
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

	public List<Club> getClubsByCategory(String category) {
		List<Club> clubList = new ArrayList<Club>();

		try {
			resultSet = statement
					.executeQuery("SELECT * FROM clubmanager.club WHERE category = '"
							+ category + "';");
			while (resultSet.next()) {
				Club club = new Club();
				club.setIdClub(Integer.parseInt(resultSet.getString("idClub")));
				club.setCategory(resultSet.getString("category"));
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

	public void addClub(Club club) {
		int idClub = club.getIdClub();
		String name = club.getName();
		String teacher = club.getTeacher();
		String category = club.getCategory();
		String location = club.getLocation();
		String description = club.getDescription();

		try {
			statement.executeUpdate("INSERT INTO club values (" + idClub + ",'"
					+ name + "', '" + teacher + "', '" + category + "', '"
					+ location + "', '" + description + "');");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
