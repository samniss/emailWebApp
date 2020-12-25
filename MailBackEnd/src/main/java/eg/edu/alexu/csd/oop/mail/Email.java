package eg.edu.alexu.csd.oop.mail;



import java.util.ArrayList;
public class Email {
	private boolean Check = false;
	private String Sender;
	private LinkedBasedQ Receiver=new LinkedBasedQ();//Number of receivers won't exceed 1000
	private String Subject; 
	private String Date;
	private String Content; //text
	private boolean Draft;//A boolean which indicates if the email is saved as draft
	private int Priority; // using adapter design pattern

	private ArrayList<String> attachments=new ArrayList<String>();

	public Email(){

	}
	public ArrayList<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<String> attachments) {
		this.attachments = attachments;
	}



	public boolean isDraft() {
		return Draft;
	}

	public void setDraft(boolean draft) {
		Draft = draft;
	}

	public boolean isCheck() {
		return Check;
	}
	public void setCheck(boolean check) {
		Check = check;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}

	public String getSubject() {
		return Subject;
	}



	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}

	public LinkedBasedQ getReceiver() {
		return Receiver;
	}
	public void setReceiver(LinkedBasedQ receiver) {
		Receiver = receiver;
	}
	public void show(){
		System.out.println("Sender : " + this.getSender());
		if(this.getReceiver()!=null){
			System.out.println("Receivers : ");
			this.getReceiver().show();
		}
		else {
			System.out.println("Receivers : " + "null");
		}
		System.out.println("Subject : " + this.getSubject());
		System.out.println("Date : " + this.getDate());
		System.out.println("Content : " + this.getContent());
		System.out.println("Priority : " + this.getPriority());
		System.out.println("Attachments : ");
		if(this.getAttachments().size()!=0){
			for(int i=0;i<attachments.size();i++){
			System.out.println(attachments.get(i));
			}
		}
		else {
			System.out.println("null");
		}


	}
}
