package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private List<Email> e = new ArrayList<>();    // general
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public static void AddFolder(String userEmail, String folderName) {
		
	}
	
	public static Folder RemoveFolder(String userEmail, String folderName) {
		return null;
		
	}
	
	public static void RenameFolder(String userEmail,String folderName){
		
	}
	
	public static Email[] MoveEmail(String oldFolderName , String newFolderName , String[] ArrayListOfEmailsNames){
		return null;
		
	}

    //folder functions

/* 	
 	AddEmail(user email, folder)
RemoveEmail(user email, folder)
*/  
  //email functions

}
