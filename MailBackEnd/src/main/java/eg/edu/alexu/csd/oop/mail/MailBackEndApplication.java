package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
	private String currentEmailName="";


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

	public boolean save( String mailJson, MultipartFile[] attachments,ArrayList<String> receivers) {
		Email email = new Email();
		ObjectMapper mapper=new ObjectMapper();
		try {
			email = mapper.readValue(mailJson, Email.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		boolean right=true;
		for(int i=0;i<receivers.size();i++){
			right=folder.checkExistUsername(receivers.get(i));
			if(right==false){
				break;
			}
		}
		if(right==true) {
			ArrayListToQ ad = new ArrayListToQAdapter(new ArrayListToQAdaptee());
			email.setReceiver(ad.changeToQ(receivers));
			email.setDate(email.millisToDate(email.getDate()));
			email.setSender(userEmailAddress);


			s.saveEmail(email, attachments);
		}
		return right;
	}

	public ArrayList<Email> loadEmails(int page) {
		return (ArrayList<Email>) l.loadEmails(userEmailAddress, folderName, page);
	}

	public ArrayList<File> loadFolders(int page) {
		return (ArrayList<File>) l.loadFolders(userEmailAddress, page);
	}

	//return success if the contact is a new contact and  it has been saved
	public boolean addFolder(String folderName) {
		if (!l.checkExistFolderInUserFolder(userEmailAddress,folderName)){
			File newFolder = new File("System/" + userEmailAddress + "/"+folderName);
			newFolder.mkdir();
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deleteFolder(String folderName){
		if (l.checkExistFolderInUserFolder(userEmailAddress,folderName)){
			File theFolder = new File("System/" + userEmailAddress + "/"+folderName);
			theFolder.delete();
			return true;
		}
		return false;
	}
	public boolean updateFolderName(String oldName,String newName){
		if (l.checkExistFolderInUserFolder(userEmailAddress,oldName)){
			File folder = new File("System/" + userEmailAddress + "/"+oldName);
			File folder2 = new File("System/" + userEmailAddress + "/"+newName);
			if (folder2.exists()) {
				return false;
			}
			// Rename file (or directory)
			boolean success = folder.renameTo(folder2);
			return success;
		}
		else {
			return false;
		}
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
		if(check1==true) {
			boolean check2 = folder.checkPassword(email, password);
			if (check1 == true && check2 == true)
				return true;
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean signUp(String name, String address, String password, String birthDate, String gender){
		if (name!=null&&address!=null&&password!=null&&birthDate!=null&&gender!=null) {
			if (name!=""&&address!=""&&password!=""&&birthDate!=""&&gender!="") {
				if (new Folder().checkExistUsername(address)) {

					return false;//that name is existing
				} else {
					File user = new File("System/" + "/" + address);
					File Draft = new File("System/" + address + "/Draft");
					File Inbox = new File("System/" + address + "/Inbox");
					File Sent = new File("System/" + address + "/Sent");
					File Trash = new File("System/" + address + "/Trash");
					user.mkdir();
					Draft.mkdir();
					Inbox.mkdir();
					Sent.mkdir();
					Trash.mkdir();
					User u = new User(name, address, password, gender, birthDate);
					Save s = new Save();
					s.saveUserData(u);
					ObjectMapper om = new ObjectMapper();
					try {
						om.writeValue(Paths.get("System/" + address + "\\contacts.json").toFile(), new ArrayList<Contact>());
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						om.writeValue(Paths.get("System/" + address + "/Draft" + "\\emailNames.json").toFile(), new ArrayList<String>());
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						om.writeValue(Paths.get("System/" + address + "/Inbox" + "\\emailNames.json").toFile(), new ArrayList<String>());
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						om.writeValue(Paths.get("System/" + address + "/Sent" + "\\emailNames.json").toFile(), new ArrayList<String>());
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						om.writeValue(Paths.get("System/" + address + "/Trash" + "\\emailNames.json").toFile(), new ArrayList<String>());
					} catch (IOException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean checkValidAddress(String address){
		if (address!=null) {
			if (address.contains("@")) {
				String[] splited = address.split("@");
				if (splited.length == 2) {
					if (splited[1].equals("MAJ.com")) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			return false;
		}
		else {
			return false;
		}
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
	public List<Contact> loadContacts(int page){
		int start=(page-1)*10;
		int end=(page*10)-1;
		ArrayList<Contact> contacts=(ArrayList<Contact>)l.loadContacts(userEmailAddress);
		if(start>contacts.size()-1){
			return null;//Page is empty
		}
		else if (start<=contacts.size()-1 &&end>contacts.size()-1){
			end=contacts.size()-1;
		}
		List<Contact> part=new ArrayList<Contact>();
		for(int i=start;i<=end;i++){
			part.add(contacts.get(i));
		}
		return part;
	}
	public Email getCurrentEmailName() {
		for (int i=0;i<emailsInsidMe.size();i++){
			if ((emailsInsidMe.get(i).getDate()+emailsInsidMe.get(i).getSender()).equals(currentEmailName)){
				return emailsInsidMe.get(i);
			}
		}
		return null;
	}

	public void setCurrentEmailName(String c) {
		this.currentEmailName = c;
		System.out.println(this.currentEmailName);
	}

	public ArrayList<Email> searchEmailBack(String searchKey){
		return Search.search(emailsInsidMe, searchKey);
	}
	public ArrayList<Email> sortEmailBack(String sortKey){
		ArrayList<Email> copy=new ArrayList<Email>();
		for(int i=0;i<emailsInsidMe.size();i++){
			copy.add(emailsInsidMe.get(i));
		}
		if(sortKey.equals("Priority")){
			return Sort.getEmailsSortedByPriority(copy);
		}else if(sortKey.equals("Subject")){
			return Sort.getEmailsSortedBySubject(copy);
		}else if(sortKey.equals("Sender")){
			return Sort.getEmailsSortedBySender(copy);
		}else {
			return Sort.getEmailsSortedByDate(copy);
		}
	}
}
