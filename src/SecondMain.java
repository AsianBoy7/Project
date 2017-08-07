import main.DatabaseConnection;
import model.Club;
import repository.ClubRepository;

public class SecondMain {
	
	
	public static void main(String[] args){
		DatabaseConnection databaseConnection = new DatabaseConnection();
		databaseConnection.connect();
		ClubRepository clubRepository = new ClubRepository(databaseConnection);
		Club clubbb = clubRepository.getClubByName("Football").get(0);
		System.out.println(clubbb.getTeacher());
	}
	

}
