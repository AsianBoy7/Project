import java.util.List;

import main.DatabaseConnection;
import model.Club;
import model.Schedule;
import repository.ClubRepository;
import repository.ScheduleRepository;

public class SecondMain {
	
	
	public static void main(String[] args){
		DatabaseConnection databaseConnection = new DatabaseConnection();
		databaseConnection.connect();
		ScheduleRepository scheduleRepository = new ScheduleRepository(databaseConnection);
		List<Schedule> scheduleList = scheduleRepository.getClubSchedule(1);
		System.out.println(scheduleList.get(0).getTime());
		
		Schedule schedule = new Schedule();
		schedule.setIdClub(1);
		schedule.setTime("Adventure Time");
		scheduleRepository.addSchedule(schedule);
		
		ClubRepository clubRepository = new ClubRepository(databaseConnection);
//		Club club = new Club();
//		club.setCategory("Music");
//		club.setDescription("Blah blah");
//		club.setLocation("Asshole");
//		club.setName("Fuck you");
//		club.setTeacher("Truck Driver");
//		clubRepository.addClub(club);
		
		//List<Club> clubList = clubRepository.getClubsByTeacher("Truck Driver");
		//System.out.println(clubList.get(0).getName());
		System.out.println(clubRepository.getClubByName("Football").getDescription());
	}
	

}
