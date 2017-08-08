package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.DatabaseConnection;
import model.Schedule;

public class ScheduleRepository extends MainRepository {

	public ScheduleRepository(DatabaseConnection databaseConnection) {
		super(databaseConnection);

	}

	public List<Schedule> getClubSchedule(int idClub) {
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		try {
			resultSet = statement
					.executeQuery("Select * From ClubManager.schedule WHERE idClub = "
							+ idClub + ";");
			while (resultSet.next()) {
				Schedule schedule = new Schedule();
				schedule.setIdClub(Integer.parseInt(resultSet
						.getString("idClub")));
				schedule.setTime(resultSet.getString("time"));
				schedule.setIdSchedule(Integer.parseInt(resultSet
						.getString("idSchedule")));
				scheduleList.add(schedule);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return scheduleList;
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
