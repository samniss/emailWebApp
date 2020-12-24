package eg.edu.alexu.csd.oop.mail;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("System/"+"/"+userName+"/"+"userInfo.json")){
			//Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONObject userDetails = (JSONObject) obj;
			//System.out.println(userDetails);
			if (userDetails.get("password").equals(password)){
				return true;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
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
