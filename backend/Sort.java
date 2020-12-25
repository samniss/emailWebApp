package eg.edu.alexu.csd.oop.mail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    // Sort sortType(String sortCriteria){
    //     if(sortCriteria.equals("subject"))return new SortSubject();
    //     if(sortCriteria.equals("sender"))return new SortSender();
    //     return new SortDate();   
    // }

    public static Comparator<Email> subjectComparator = new Comparator<Email>(){
        @Override
        public int compare(Email firstEmail,Email secondEmail){
            return firstEmail.getSubject().compareTo(secondEmail.getSubject());
        }
    };

    public static Comparator<Email> senderComparator = new Comparator<Email>(){
        @Override
        public int compare(Email firstEmail,Email secondEmail){
            return firstEmail.getSender().compareTo(secondEmail.getSender());
        }
    };

    public static Comparator<Email> priorityComparator = new Comparator<Email>(){
        @Override
        public int compare(Email firstEmail,Email secondEmail){
            return (secondEmail.getPriority() < firstEmail.getPriority() ? -1 :
            (secondEmail.getPriority() == firstEmail.getPriority()) ? 0 : 1);
        }
    };

    public static Comparator<Email> dateComparator = new Comparator<Email>(){
        @Override
        public int compare(Email firstEmail,Email secondEmail){
            DateTimeFormatter dtf= DateTimeFormatter.ofPattern(" yyyy-MM-dd HH:mm:ss");
            LocalDateTime firstEmailLDT = LocalDateTime.parse(firstEmail.getDate(), dtf);
            LocalDateTime secondEmailLDT = LocalDateTime.parse(secondEmail.getDate(), dtf);
            return firstEmailLDT.compareTo(secondEmailLDT);
        }
    };

    public ArrayList<Email> getEmailsSortedBySubject(ArrayList<Email> givenEmails){
        Collections.sort(givenEmails, subjectComparator);
        return givenEmails;
    }

    public ArrayList<Email> getEmailsSortedBySender(ArrayList<Email> givenEmails){
        Collections.sort(givenEmails, senderComparator);
        return givenEmails;
    }

    public ArrayList<Email> getEmailsSortedByPriority(ArrayList<Email> givenEmails){
        Collections.sort(givenEmails, priorityComparator);
        return givenEmails;
    }




    

    public static void main(String[] args) {
        ArrayList<Email> trial = new ArrayList<Email>();
        trial.add(new Email("hey", "first try", "whatever", "i hope it works"));
        trial.add(new Email("hello", "troiseme trial", "whatev", "i really do"));
        trial.add(new Email("bonjour", "second try", "this is 2012", "i am dead"));
        Sort sortingClass = new Sort();
        sortingClass.getEmailsSortedBySubject(trial);
        ArrayList<Email> trial2 = Search.search(trial, "hey");
        for (Email email : trial) {
            System.out.println(email.toString());
        }
        for (Email email : trial2) {
            System.out.println(email.toString());
        }
    }
    
}
