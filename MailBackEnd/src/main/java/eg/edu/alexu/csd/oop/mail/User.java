package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String userEmailAddress;
	private String password;
	private String birthDate;
	private String gender;
	public User(){

	}
	public User(String userName, String userEmail , String password , String gender, String dateOfBirth) {
		this.name = userName;
		this.userEmailAddress = userEmail;
		this.password = password;
		this.gender = gender;
		this.birthDate = dateOfBirth;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}


	public String getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}


}
