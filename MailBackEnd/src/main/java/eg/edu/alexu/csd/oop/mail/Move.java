package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        updateEmailNames(userEmailAddress, oldFolder, emailName, oldEmailNamesPath);

        //Add the emailName to the emailNames json file in the new folder
        //TODO Assume that the email dates are sorted by the time they move in the new Folder
        saveNamesWithSorting(userEmailAddress,newFolder,emailName,newEmailNamesPath);
        //read the email from the old folder and write it to the new folder
        copyEmail(oldEmailPath,newEmailPath,newEmailFolder);
        //Delete the email from the old folder
        deleteEmail(oldEmailFolder,oldEmailPath);
    }

    private void updateEmailNames(String userEmailAddress, String oldFolder, String emailName, String oldEmailNamesPath) {
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
    private void saveNamesWithSorting(String userEmailAddress,String newFolder,String emailName,String newEmailNamesPath){
        List<String> emailNames=new ArrayList<String>();
        Load l=new Load();
        emailNames = l.loadEmailNames(userEmailAddress, newFolder);
        emailNames.add(emailName);
        Queue<String> q = new PriorityQueue<>();
        for (int i = 0; i < emailNames.size(); i++) {
            q.offer(emailNames.get(i));
        }
        for (int i = 0; i < emailNames.size(); i++) {
            emailNames.set(i, q.poll());
        }
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(Paths.get(newEmailNamesPath).toFile(), emailNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void copyEmail(String oldEmailPath,String newEmailPath,String newEmailFolder){
        Email oldEmail = null;
        ObjectMapper mapper=new ObjectMapper();
        //Create folder for the email in the new Emails folder(inbox,trash,sent,draft,etc)
        File f=new File(newEmailFolder);
        f.mkdir();
        try {
            oldEmail = mapper.readValue(Paths.get(oldEmailPath).toFile(), Email.class);
            mapper.writeValue(Paths.get(newEmailPath).toFile(), oldEmail);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void deleteEmail(String oldEmailFolder,String oldEmailPath){
        File folder = new File(oldEmailFolder);
        File email=new File(oldEmailPath)
        if (f.delete()) {
            System.out.println("The file has been deleted successfully");
        } else {
            System.out.println("Couldn't delete the file");
        }
    }

    //Citation from https://www.baeldung.com/java-copy-directory
    public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation)
            throws IOException {
        Files.walk(Paths.get(sourceDirectoryLocation))
                .forEach(source -> {
                    Path destination = Paths.get(destinationDirectoryLocation, source.toString()
                            .substring(sourceDirectoryLocation.length()));

                    try {
                        Paths..(source, destination);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}