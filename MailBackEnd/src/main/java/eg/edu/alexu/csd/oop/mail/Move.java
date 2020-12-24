package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Move {
    public void move(String emailName, String userEmailAddress, String oldFolder, String newFolder) {//Moves the one email from one folder to another
        String oldEmailFolder="System\\" + userEmailAddress + "\\" + oldFolder + "\\" + emailName;
        String newEmailFolder="System\\" + userEmailAddress + "\\" + newFolder + "\\" + emailName;
        String oldEmailPath = oldEmailFolder+ "\\" + emailName + ".json";
        String newEmailPath = newEmailFolder + "\\" + emailName + ".json";
        String oldEmailNamesPath = "System\\" + userEmailAddress + "\\" + oldFolder + "\\" + "emailNames.json";
        String newEmailNamesPath = "System\\" + userEmailAddress + "\\" + newFolder + "\\" + "emailNames.json";

        List<String> emailNames = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        removeEmailName(userEmailAddress, oldFolder, emailName, oldEmailNamesPath);

        //Add the emailName to the emailNames json file in the new folder
        addEmailNameWSort(userEmailAddress,newFolder,emailName,newEmailNamesPath);
        //read the email from the old folder and write it to the new folder
        moveEmail(oldEmailFolder,newEmailFolder);
    }


    //Remove the email name from the emailNames.json file in the old folder
    private void removeEmailName(String userEmailAddress, String oldFolder, String emailName, String oldEmailNamesPath) {
        List<String> emailNames = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        Load l = new Load();
        emailNames = l.loadEmailNames(userEmailAddress, oldFolder);
        //Delete the email name from the emailNames arrayList
        emailNames.remove(emailName);
        //Saving the email names arraylist after removing the emailName
        try {
            mapper.writeValue(Paths.get(oldEmailNamesPath).toFile(), emailNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Add the email name to the emailNames.json file in the new Folder and sort the emailNames.json accroding to date
    private void addEmailNameWSort(String userEmailAddress,String newFolder,String emailName,String newEmailNamesPath){
        //Save the new email name in the emailNames.json file in the new folder
        List<String> emailNames=new ArrayList<String>();
        Load l=new Load();
        emailNames = l.loadEmailNames(userEmailAddress, newFolder);
        emailNames.add(emailName);

        //Sorting the emailNames.json file
        emailNames=sortEmailNames(userEmailAddress,(ArrayList<String>) emailNames);
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(Paths.get(newEmailNamesPath).toFile(), emailNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Move the email folder from the old folder to the new folder
    private void moveEmail(String source,String destination){
        try {
            Files.move(Paths.get(source),Paths.get(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<String> sortEmailNames(String userEmailAddress,ArrayList<String> emailNames){
        //Create a new Arraylist with the dates of the emails only

        ArrayList<LocalDateTime> emailDates=new ArrayList<LocalDateTime>();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i< emailNames.size();i++){
            emailDates.add(LocalDateTime.parse(emailNames.get(i).substring(0, emailNames.get(i).indexOf(userEmailAddress)),dtf));
        }
        Queue<LocalDateTime> dates=new PriorityQueue<LocalDateTime>();
        for(int i=0;i<emailDates.size();i++){
            dates.offer(emailDates.get(i));
        }
        for(int i=0;i<emailDates.size();i++){
            emailDates.set(i,dates.poll());
        }

        ArrayList<String> names=new ArrayList<String>();
        for(int i=0;i<emailDates.size();i++){
            names.add(emailDates.get(i).format(dtf).toString()+userEmailAddress);
        }
        return names;

    }
}