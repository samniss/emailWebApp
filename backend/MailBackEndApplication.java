package eg.edu.alexu.csd.oop.mail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//Singleton and Facade design pattern
public class MailBackEndApplication {
	private static MailBackEndApplication instance=null;
	private Save s=new Save();
	private Load l=new Load();
	private Move m=new Move();
	private ContactManipulator cm=new ContactManipulator();
	private FilterSender fsend=new FilterSender();
	private FilterSubject fsub=new FilterSubject();
	private AndFilter af=new AndFilter(fsend,fsub);
	private String userEmailAddress="";

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	private String folderName="Inbox";
	////////////////////////////////////////////////
	private Folder folder;
	private ArrayList<Folder> foldersInsidMe=new ArrayList<Folder>(); // Create an ArrayList object
	private ArrayList<Email> emailsInsidMe=new ArrayList<Email>(); // Create an ArrayList object
	//////////////////////////////////////////////////////
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}



	private MailBackEndApplication(){
		folder=new Folder();
		folder.setPath("System");
	}
	//Singleton
	public static synchronized MailBackEndApplication getInstance(){
		if(instance==null){
			instance=new MailBackEndApplication();
		}
		return instance;
}

	public void save( String mailJson, MultipartFile[] attachments,ArrayList<String> receivers) {
		Email email = new Email();
		ObjectMapper mapper=new ObjectMapper();
		try {
			email = mapper.readValue(mailJson, Email.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		ArrayListToQ ad=new ArrayListToQAdapter(new ArrayListToQAdaptee());
		email.setReceiver(ad.changeToQ(receivers));
		email.setDate(email.millisToDate(email.getDate()));
		email.setSender(userEmailAddress);
		s.saveEmail(email, attachments);
	}

	public ArrayList<Email> loadEmails(int page) {
		return (ArrayList<Email>) l.loadEmails(userEmailAddress, folderName, page);
	}

	//Citation from https://www.javainuse.com/spring/boot-file-download with some changes
	//Load an attachment
	public void download(HttpServletRequest request, HttpServletResponse response, String fileName,String emailName)  {
		String path = "System\\" + userEmailAddress + "\\" + folderName + "\\" + emailName + "\\" + fileName;
		File file = new File(path);
		if (file.exists()) {
			//get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				//unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);

			//(Content-Disposition->Attachment)  File is downloaded as an attachment
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
			response.setContentLength((int) file.length());

			InputStream inputStream = null;
			try {
				inputStream = new BufferedInputStream(new FileInputStream(file));
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


		}

	}

	public void moveEmails( ArrayList<String> emailNames, String newFolder) {
		m.moveEmails(emailNames, userEmailAddress, folderName, newFolder);
	}

	public void deleteEmails( ArrayList<String> emailNames) {
		m.moveEmails(emailNames, userEmailAddress, folderName, "Trash");
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * set the array linked mails
	 * @param m should be array list of mails
	 */
	public void setMails(ArrayList<Email> m){
		if (m!=null) {
			for(int i=0;i<m.size();i++){
				emailsInsidMe.add(m.get(i));
			}
		}
		else emailsInsidMe=new ArrayList<Email>();//empty emails
	}
	/**
	 * get the array linked of mails
	 */
	public ArrayList<Email> getMails(){
		return this.emailsInsidMe;
	}
	///////////need to be written//////////////////////////////////
	public boolean signIn(String email, String password) {
		boolean check1=folder.checkExistUsername(email);
		boolean check2=folder.checkPassword(email,password);
		if(check1==true && check2==true)
			return true;
		else {
			return false;
		}
	}
	public boolean signUp(String name, String address, String password, String birthDate, String gender){
		if(new Folder().checkExistUsername(address)) {

			return false;//that name is existing
		}
		else {
			File user=new File("System/"+"/"+address);
			File Contact=new File("System/"+address+"/Contact");
			File Draft=new File("System/"+address+"/Draft");
			File Inbox=new File("System/"+address+"/Inbox");
			File Sent=new File("System/"+address+"/Sent");
			File Trash=new File("System/"+address+"/Trash");
			user.mkdir();
			Contact.mkdir();
			Draft.mkdir();
			Inbox.mkdir();
			Sent.mkdir();
			Trash.mkdir();
			User u=new User(name,address,password,gender,birthDate);
			Save s=new Save();
			s.saveUserData(u);
			ObjectMapper om=new ObjectMapper();
			try {
				om.writeValue(Paths.get("System/"+address+"/Contact"+"\\emailNames.json").toFile(),new ArrayList<Contact>());
			}catch(IOException e){
				e.printStackTrace();
			}
			try {
				om.writeValue(Paths.get("System/"+address+"/Draft"+"\\emailNames.json").toFile(),new ArrayList<String>());
			}catch(IOException e){
				e.printStackTrace();
			}
			try {
				om.writeValue(Paths.get("System/"+address+"/Inbox"+"\\emailNames.json").toFile(),new ArrayList<String>());
			}catch(IOException e){
				e.printStackTrace();
			}
			try {
				om.writeValue(Paths.get("System/"+address+"/Sent"+"\\emailNames.json").toFile(),new ArrayList<String>());
			}catch(IOException e){
				e.printStackTrace();
			}
			try {
				om.writeValue(Paths.get("System/"+address+"/Trash"+"\\emailNames.json").toFile(),new ArrayList<String>());
			}catch(IOException e){
				e.printStackTrace();
			}
			return true;
		}
	}
	public boolean checkValidAddress(String address){
		if (address.contains("@")){
			String[] splited =address.split("@");
			if (splited.length==2){
				if (splited[1].contains(".com")){
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return false;
	}
	//return success if the contact is a new contact and  it has been saved
	public boolean addContact(Contact contact) {
		//load contacts and check if the contact already exists
		ArrayList<Contact> contacts = (ArrayList<Contact>) l.loadContacts(userEmailAddress);
		boolean exist = contact.checkContactName(contacts);

		if (exist == false) {//if there is no other contact with the same name
			exist=contact.checkContactEmailExist();
			if(exist==true) {//if the email addresses of the contact exists
				s.saveContact(contact, userEmailAddress);
				return true;
			}
		}
		return false;
	}
	public void deleteContact(String contactName){
		cm.deleteContact(contactName,userEmailAddress);
	}
	public boolean updateContactName(String oldName,String newName){
		return cm.updateContactName(oldName,newName,userEmailAddress);
	}
	public boolean updateContactEmail(String contactName,String oldEmailAddress,String newEmailAddress){
		return cm.updateContactEmail(contactName,oldEmailAddress,newEmailAddress,userEmailAddress);
	}
	public ArrayList<Email> filterSender(String filterName){
		return fsend.meetCriteria(emailsInsidMe,filterName);
	}
	public ArrayList<Email> filterSubject(String filterName){
		return fsub.meetCriteria(emailsInsidMe,filterName);
	}
	public ArrayList<Email> filterBoth(String filterNameSender,String filterNameSubject){
		return af.meetCriteria(emailsInsidMe,filterNameSender,filterNameSubject);
	}
	public ArrayList<Email> searchEmailBack(String searchKey){
		return Search.search(emailsInsidMe, searchKey);
	}
	public ArrayList<Email> sortEmailBack(String sortKey){
		if(sortKey.equals("Priority")){
			return Sort.getEmailsSortedByPriority(emailsInsidMe);
		}else if(sortKey.equals("Subject")){
			return Sort.getEmailsSortedBySubject(emailsInsidMe);
		}else if(sortKey.equals("Sender")){
			return Sort.getEmailsSortedBySender(emailsInsidMe);
		}else {
			return Sort.getEmailsSortedByDate(emailsInsidMe);
		}
	}
}