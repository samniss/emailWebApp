package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Save {

    /***
     *
     * @param user
     * The user object which contains the user data (name,password,email address,gender,etc)
     */
    public void saveUserData(User user){//Saves the user name,password,email address,gender,etc
        String savePath="System\\"+user.getUserEmailAddress()+"\\Info.json";
        ObjectMapper om=new ObjectMapper();
        try {
            om.writeValue(Paths.get(savePath).toFile(),user);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param email The email to be saved
     */
    public void saveEmail(Email email){//Save one email
        if(email.isDraft()){
            saveEmailAsDraft(email);
        }
        else {
            saveEmailAsSent(email);
        }

    }


   /*
   This following function is used to store the name of the emails json files of each user folder
   For example in the inbox folder there will be a json file which stores the name of each email json file in that folder
    */

    /**
     *
     * @param userEmailAddress The email Address of the user for whom the email name is saved(Sender or receiver)
     * @param sender The Email address of the sender of the email
     * @param date   The date on which the email was sent
     * @param folderName The folderName in which the email is saved ie(Inbox,Trash,Sent,etc)
     */
    private void saveEmailNames(String userEmailAddress,String sender,String date,String folderName){
        String emailName=date+sender;
        ObjectMapper om=new ObjectMapper();
        List<String> emailNames=new ArrayList<>();
        String savePath="System\\"+userEmailAddress+"\\"+folderName+"\\"+"emailNames.json";
        try{
            emailNames=om.readValue(Paths.get(savePath).toFile(),ArrayList.class);

        }catch(IOException e){//The file is not found and so we will create it
        }

            try{
                emailNames.add(emailName);//we save the email name as linked list instead of String because later we will need to store
                //other email names

                om.writeValue(Paths.get(savePath).toFile(), emailNames);
            }catch(IOException e1){
                e1.printStackTrace();
            }



    }

    /**
     *
     * @param email The draft email to be saved
     */
    private void saveEmailAsDraft(Email email){
        String saveName= email.getDate()+email.getSender();//The name of the json file on pc
        String savePath="System\\"+email.getSender()+"\\"+"Draft"+"\\"+saveName+"\\"+saveName+".json"; //The path to which the email will be saved
        ObjectMapper om=new ObjectMapper();
        try {
            om.writeValue(Paths.get(savePath).toFile(),email);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("=====================");
            System.out.println("Cannot Save The  Draft email");
            System.out.println("=====================");
        }
        saveEmailNames(email.getSender(),email.getSender(),email.getDate(),"Draft");
    }

    /**
     *
     * @param email The composed email to be sent
     */
    private void saveEmailAsSent(Email email){
        saveForSender(email);
        saveForReceivers(email);
    }

    /**
     *
     * @param email The email which will be saved in the Sent folder of the sender
     */
    private void saveForSender(Email email){
        String saveName= email.getDate()+email.getSender();//The name of the json file on pc
        String savePath="System\\"+email.getSender()+"\\"+"Sent"+"\\"+saveName+"\\"+saveName+".json"; //The path to which the email will be saved
        ObjectMapper om=new ObjectMapper();
        try {
            om.writeValue(Paths.get(savePath).toFile(),email);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("=====================");
            System.out.println("Cannot Save The  Draft email");
            System.out.println("=====================");
        }
        saveEmailNames(email.getSender(),email.getSender(),email.getDate(),"Sent");
    }

    /**
     *
     * @param email The email which will be saved in the Inbox folder of the receivers
     */
    private void saveForReceivers(Email email){
        String saveName= email.getDate()+email.getSender();//The name of the json file on pc
        String receiverEmailAddress;
        LinkedBasedQ receivers=email.getReceiver();//The queue of the receivers of the email
        for(int i=0;i< receivers.size();i++) {
            receiverEmailAddress=(String)receivers.dequeue();
            String savePath = "System\\" + receiverEmailAddress + "\\" + "Inbox" + "\\" + saveName + "\\" + saveName + ".json"; //The path to which the email will be saved
            ObjectMapper om = new ObjectMapper();
            try {
                om.writeValue(Paths.get(savePath).toFile(), email);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("=====================");
                System.out.println("Cannot Save The  Draft email");
                System.out.println("=====================");
            }
            saveEmailNames(receiverEmailAddress,email.getSender(),email.getDate(),"Inbox");
            receivers.enqueue(receiverEmailAddress);

        }
        for(int j=0;j<receivers.size();j++){//Return the order of the queue
            Object x=receivers.dequeue();
            receivers.enqueue(x);
        }
    }


}
