package eg.edu.alexu.csd.oop.mail;

public class Email {
	private boolean Check = false;
	private String Sender;
	private String Receiver;
	private String Subject; 
	private String Date;
	private String Content; //text
	private Attachment Attachements;
	private int Priority; // using adapter design pattern
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
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
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
	public Attachment getAttachements() {
		return Attachements;
	}
	public void setAttachements(Attachment attachements) {
		Attachements = attachements;
	}
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}

}
