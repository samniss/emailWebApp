package eg.edu.alexu.csd.oop.mail;

import java.util.List;

public class Main {
	//~ (Singelton design pattern)
	
	//check whether the user has entered a correct email and password or not
  	
	//List<User> u = new ArrayList<>();
	String userName ,userEmail ,  password ,  gender,  dateOfBirth;
	User u = new User(userName, userEmail , password , gender,dateOfBirth);

}
