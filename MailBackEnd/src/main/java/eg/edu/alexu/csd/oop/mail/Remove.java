package eg.edu.alexu.csd.oop.mail;

import java.io.File;
import java.util.ArrayList;

public class Remove {
    /***
     *
     * @param userEmails
     * The ArrayList of the emails in the (folderName) of (userEmailAddress)
     * @param folderName
     * The folder which contains the email
     * @param Date
     * The date at which the email was sent
     * @param senderEmailAddress
     * The email of the sender of the email
     * @param userEmailAddress
     * The email of the user who want to delete the email (could be the sender or the receiver)
     */
    public void Remove (ArrayList<Email> userEmails,String folderName, String Date, String senderEmailAddress, String userEmailAddress){
        for(int i=0;i<userEmails.size();i++) {//loop on the userEmails to remove the email from it
            if(userEmails.get(i).getSender().equalsIgnoreCase(senderEmailAddress)&&userEmails.get(i).getDate().equalsIgnoreCase(Date)){
                userEmails.remove(i);
                break;
            }
        }
        String emailName=Date+senderEmailAddress+".json";
        String emailFullPath="System\\"+userEmailAddress+"\\"+folderName+"\\"+emailName;
        File emailFile=new File(emailFullPath);
        if(emailFile.delete()){
            System.out.println("The email "+ emailName+" Has been deleted successfully");
        }
        else {
            System.out.println("The email" + emailName+ " Could not be deleted");
        }
    }
}
