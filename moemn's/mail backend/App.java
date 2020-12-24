package eg.edu.alexu.csd.oop.mail;

import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; // import the ArrayList class

public class App {
    private Folder folder;
    private ArrayList<Folder> foldersInsidMe=new ArrayList<Folder>(); // Create an ArrayList object
    private ArrayList<Email> emailsInsidMe=new ArrayList<Email>(); // Create an ArrayList object
    public App(){
        folder=new Folder();
        folder.setPath("System");
    }
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
    public boolean signUp(String name, String address, String password, String birthDate, String gender) throws JSONException {
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
            JSONObject userDetails = new JSONObject();
            userDetails.put("name", name);
            userDetails.put("address", address);
            userDetails.put("password", password);
            userDetails.put("birthDate", birthDate);
            userDetails.put("gender", gender);
            JSONArray contactList = new JSONArray();
            userDetails.put("contacts",contactList);
            try (FileWriter file = new FileWriter("System/"+"/"+address+"/"+"userInfo.json")) {
                file.write(userDetails.toJSONString());
                file.flush();

            } catch (IOException e) {
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
    /*public static void main(String[] args) {
        App app=new App();
        System.out.println(app.signIn("momen","123456"));
    }*/
}
