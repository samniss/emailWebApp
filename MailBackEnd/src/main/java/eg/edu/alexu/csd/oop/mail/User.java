package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String userEmailAddress;
	private String password;
	private static List<User> contacts = new ArrayList<>();  // [arrayOfReadOnlyInterfaces]  //(~ read only interface + composite design pattern) 
	private String birthDate;
	private String gender;
	List<Folder> f = new ArrayList<>();
	public User(String userName, String userEmail , String password , String gender, String dateOfBirth) {
		this.name = userName;
		this.userEmailAddress = userEmail;
		this.password = password;
		this.gender = gender;
		this.birthDate = dateOfBirth;
	}
	
	public static void addContact(String contactName, String contactEmailAddress) {
		contacts.add(new User(contactName , contactEmailAddress, null, null, null));
		
	} 

}