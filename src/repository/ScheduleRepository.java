package repository;

import java.sql.SQLException;

import main.DatabaseConnection;
import model.Schedule;

public class ScheduleRepository extends MainRepository {

	public ScheduleRepository(DatabaseConnection databaseConnection) {
		super(databaseConnection);

	}

	public Schedule getClubSchedule(int idClub) {
		Schedule schedule = new Schedule();
		try {
			resultSet = statement
					.executeQuery("Select * From ClubManager.schedule WHERE idClub = "
							+ idClub + ";");
			resultSet.next();

			schedule.setIdClub(Integer.parseInt(resultSet.getString("idClub")));
			schedule.setTime(resultSet.getString("time"));
			schedule.setIdSchedule(Integer.parseInt(resultSet
					.getString("idSchedule")));

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return schedule;
	}

	public void addSchedule(Schedule schedule) {
		try {
			statement.executeUpdate("INSERT INTO schedule VALUES ("
					+ schedule.getIdSchedule() + ", " + schedule.getIdClub()
					+ ", '" + schedule.getTime() + "');");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
