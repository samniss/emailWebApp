package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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


    /*
   This following function is used to store the name of the emails json files of each user folder
   For example in the inbox folder there will be a json file which stores the name of each email json file in that folder
    */
    /**
     *
     * @param email The email to be saved
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





    public void saveEmail(Email email,MultipartFile[] files){//Save one email
        if(email.isDraft()){
            saveEmailAsDraft(email,files);
        }
        else {
            saveEmailAsSent(email,files);
        }

    }
    private void save(Email email,String userEmailAddress,String folderName,MultipartFile[] files){
        String saveName= email.getDate()+email.getSender();//The name of the json file on pc
        String emailFolder="System\\"+userEmailAddress+"\\"+folderName+"\\"+saveName;
        File f=new File(emailFolder);
        f.mkdir();
        String savePath=emailFolder+"\\"+saveName+".json"; //The path to which the email will be saved
        ObjectMapper om=new ObjectMapper();
        try {
            om.writeValue(Paths.get(savePath).toFile(),email);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("=====================");
            System.out.println("Cannot Save email");
            System.out.println("=====================");
        }
        saveEmailNames(userEmailAddress,email.getSender(),email.getDate(),folderName);
        saveAttachments(files,userEmailAddress,folderName,saveName);
    }

    /**
     *
     * @param email The draft email to be saved
     */
    private void saveEmailAsDraft(Email email,MultipartFile[] files){
        save(email,email.getSender(),"Draft",files);
    }

    /**
     *
     * @param email The composed email to be sent
     */
    private void saveEmailAsSent(Email email,MultipartFile[] files){
        saveForSender(email,files);
        saveForReceivers(email,files);
    }

    /**
     *
     * @param email The email which will be saved in the Sent folder of the sender
     */
    private void saveForSender(Email email,MultipartFile[] files){
        save(email,email.getSender(),"Sent",files);
    }

    /**
     *
     * @param email The email which will be saved in the Inbox folder of the receivers
     */
    private void saveForReceivers(Email email,MultipartFile[] files){
        String receiverEmailAddress;
        LinkedBasedQ receivers=new LinkedBasedQ();
        receivers=receivers.copy(email.getReceiver());
        int size= receivers.size();

        for(int i=0;i< size;i++) {
            receiverEmailAddress=(String)receivers.dequeue();
            save(email,receiverEmailAddress,"Inbox",files);
        }
    }
    private void saveAttachment(MultipartFile file,String userEmailAddress,String folderName,String emailName){
        String currentDirectory=System.getProperty("user.dir");
        String filePath=currentDirectory+"\\"+"System\\"+userEmailAddress+"\\"+folderName+"\\"+emailName+"\\"+file.getOriginalFilename();
        File f=new File(filePath);
        try {
            f.createNewFile();
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void saveAttachments(MultipartFile [] files,String userEmailAddress,String folderName,String emailName){
       if(files!=null) {
           for (int i = 0; i < files.length; i++) {
               saveAttachment(files[i], userEmailAddress, folderName, emailName);
           }
       }
    }
    public void createNewUser(String userEmailAddress){
        String path="System\\"+userEmailAddress;
        String [] folderNames={"Inbox","Draft","Trash","Sent"};
        File f=new File(path);
        f.mkdir();
        ObjectMapper mapper=new ObjectMapper();
        for(int i=0;i<4;i++){
            String folder=path+"\\"+folderNames[i];
            File newFolder=new File(folder);
            newFolder.mkdir();
            try {
                mapper.writeValue(Paths.get(folder+"\\"+"emailNames.json").toFile(),new ArrayList<>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
