package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public class FilterSubject implements IFilter{
    public ArrayList<Email> meetCriteria(ArrayList<Email> emails,String filterName){
        ArrayList<Email> filteredEmails=new ArrayList<>();
        if(filterName != null){
            for(int i=0;i<emails.size();i++) {
                if(emails.get(i).getSubject().equals(filterName)) {
                    filteredEmails.add(emails.get(i));
                }
            }
        }
        return filteredEmails;
    }
}
