package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<String> emailAddresses=new ArrayList<String>();
    //Constructor for saving and loading
    public Contact(){

    }
    public Contact(String name,ArrayList<String> emailAddresses){
        this.name=name;
        this.emailAddresses=emailAddresses;
    }
    public String getName() {
        return name;
    }

    public ArrayList<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddresses(ArrayList<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    //Returns true if the arraylist contains a contact that has the same name as the current contact
    public boolean checkContactName(ArrayList<Contact> contacts){
        boolean exist=false;
        for(int i=0;i<contacts.size();i++){
            if(this.name.equals(contacts.get(i).name)){
                exist=true;
                break;
            }
        }
        return exist;
    }
    public boolean checkContactEmailExist(){
        Folder f=new Folder();
        ArrayList<String> emailAddresses=this.getEmailAddresses();
        boolean exist=true;
        for(int i=0;i<this.emailAddresses.size();i++){
           if( !f.checkExistUsername(emailAddresses.get(i))){
               exist=false;
               break;
           }
        }
        return exist;
    }
}
