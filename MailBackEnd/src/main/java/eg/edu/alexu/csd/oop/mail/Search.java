package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public class Search {

    static ArrayList<Email> search(ArrayList<Email> givenList, String searchTerm){
        ArrayList<Email> outputList = new ArrayList<>();
        for (Email entryEmail : givenList) {
            if(entryEmail.getSender().contains(searchTerm)){
                outputList.add(entryEmail);
            }
            if(entryEmail.getSubject().contains(searchTerm)){
                outputList.add(entryEmail);
            }
            if(entryEmail.getContent().contains(searchTerm)){
                outputList.add(entryEmail);
            }
            if(entryEmail.getDate().contains(searchTerm)){
                outputList.add(entryEmail);
            }
            for (String attach : entryEmail.getAttachments()) {
                if(attach.contains(searchTerm)){
                    outputList.add(entryEmail);
                }
            }
        }
        return outputList;
    }
}