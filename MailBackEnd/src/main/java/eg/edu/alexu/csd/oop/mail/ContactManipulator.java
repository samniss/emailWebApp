package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ContactManipulator {
    private void saveContactsList(ArrayList<Contact>contacts,String userEmailAddress){
        String path="System\\"+userEmailAddress+"\\contacts.json";
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(Paths.get(path).toFile(),contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean updateContactName(String oldName,String newName,String userEmailAddress){
        Load l=new Load();
        ArrayList<Contact>contacts=(ArrayList<Contact>)l.loadContacts(userEmailAddress);
        Contact contact=new Contact();
        //check if the new Name already exists
        contact.setName(newName);
        boolean exist=contact.checkContactName(contacts);
        if(exist==false) {
            for (int i = 0; i < contacts.size(); i++) {
                if (oldName.equals(contacts.get(i).getName())) {
                    contacts.get(i).setName(newName);
                    break;
                }
            }
            saveContactsList(contacts, userEmailAddress);
            return true;
        }
        return false;//The new name already  exists
    }
    public boolean updateContactEmail(String contactName,String oldEmailAddress,String newEmailAddress,String userEmailAddress){
        Load l=new Load();
        ArrayList<Contact> contacts=(ArrayList<Contact>)l.loadContacts(userEmailAddress);
        Contact contact =new Contact();
        ArrayList<String> emailAddresses=new ArrayList<>();
        emailAddresses.add(newEmailAddress);
        contact.setEmailAddresses(emailAddresses);
        boolean exist=contact.checkContactEmailExist();
        if(exist==true) {
            boolean br = false;
            for (int i = 0; i < contacts.size() && !br; i++) {
                if (contactName.equals(contacts.get(i).getName())) {
                    ArrayList<String> emails = contacts.get(i).getEmailAddresses();
                    for (int j = 0; i < emails.size(); j++) {
                        if (oldEmailAddress.equals(emails.get(j))) {
                            emails.set(j, newEmailAddress);
                            br = true;
                            break;
                        }
                    }
                }
            }
            saveContactsList(contacts, userEmailAddress);
            return true;
        }
        return false;
    }

    public void deleteContact(String contactName,String userEmailAddress){
        Load l=new Load();
        ArrayList<Contact> contacts=(ArrayList<Contact>)l.loadContacts(userEmailAddress);
        for(int i=0;i<contacts.size();i++){
            if(contactName.equals(contacts.get(i).getName())){
                contacts.remove(i);
            }
        }
        //save the arraylist after removing
        ObjectMapper mapper=new ObjectMapper();
        String path="System\\"+userEmailAddress+"\\contacts.json";
        try {
            mapper.writeValue(Paths.get(path).toFile(),contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
