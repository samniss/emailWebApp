package eg.edu.alexu.csd.oop.mail;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Load {
    public User loadUserInfo(String userEmailAddress){
        String path="System\\"+userEmailAddress+"\\"+"Info.json";
        ObjectMapper om =new ObjectMapper();
        User user= null;
        try {
            user = om.readValue(Paths.get(path).toFile(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("=====================");
            System.out.println("Cannot read user info");
            System.out.println("=====================");
        }
        return user;
    }
    public List<Email> loadEmails(String userEmailAddress, String folderName,int pageNumber){//Loads  emails from a specific folder
        String path="System\\"+userEmailAddress+"\\"+folderName;
        List<String> emailNames=loadEmailNames(userEmailAddress,folderName);//This list contains the names of the emails json files
        List<Email> emails=new ArrayList<Email>();
        String emailName;
        String emailPath;
        ObjectMapper mapper=new ObjectMapper();
        int start=(pageNumber-1)*10;
        int end=(pageNumber*10)-1;
        if(start>emailNames.size()-1){
            return null;//Page is empty
        }
        else if (start<=emailNames.size()-1 &&end>emailNames.size()-1){
            end=emailNames.size()-1;
        }
        for(int i=start;i<=end;i++){//Load emails
            emailName=emailNames.get(i);
            emailPath=path+"\\"+emailName+"\\"+emailName+".json";
            try {
                emails.add(mapper.readValue(Paths.get(emailPath).toFile(),Email.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return emails;
    }

    public List<String> loadEmailNames(String userEmailAddress,String folderName){
        List<String> emailNames=new ArrayList<String>();
        String path="System\\"+userEmailAddress+"\\"+folderName;
        String emailNamesPath=path+"\\"+"emailNames.json";//emailNames.json contains the names of the emails json files in the folder
        ObjectMapper mapper=new ObjectMapper();
        try {
            emailNames =mapper.readValue(Paths.get(emailNamesPath).toFile(),ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emailNames;
    }
    public List<Contact> loadContacts(String userEmailAddress){
        String path="System\\"+userEmailAddress+"\\contacts.json";
        ObjectMapper mapper=new ObjectMapper();
        List<Contact> contacts=new ArrayList<Contact>();
        try {
             contacts=(ArrayList<Contact>)mapper.readValue(Paths.get(path).toFile(),ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<contacts.size();i++){
            contacts.set(i,mapper.convertValue(contacts.get(i),Contact.class));
        }
        return contacts;
    }
}
