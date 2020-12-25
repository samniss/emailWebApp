package eg.edu.alexu.csd.oop.mail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Folder {
	private String name;
	private List<Email> e = new ArrayList<>();    // general
	////////////////////////
	private File system=new File("System");
	private File UserFile=new File("System/UserName.txt");
	private File num=new File("System/num.txt");
	private String UserName;
	private String PassWord;
	private String path="";
	//////////////////////
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
	/////////////////////////////////////////////////
	public void setPath(String p) {
		this.path= p;
	}
	public boolean checkExistUsername(String username) {
		system.mkdir();
		if(username==null)
			return false;
		for(File f:system.listFiles()) {
			if(f.getName().toLowerCase(Locale.ROOT).equals((username.toLowerCase(Locale.ROOT)))){
				return true;
			}
		}
		return false;
	}
	public boolean checkPassword(String userName, String password) {
		//JSON parser object to parse read file
		Load l=new Load();
		User u=l.loadUserInfo(userName);
		if (u.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	////////////////////////////////////////////////////

/* 	
 	AddEmail(user email, folder)
RemoveEmail(user email, folder)
*/  
  //email functions

}
