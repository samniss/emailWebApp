package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public class AndFilter implements IAndFilter{
    IFilter first;
    IFilter second;
    public AndFilter(IFilter first,IFilter second){
        this.first=first;
        this.second=second;
    }
    public ArrayList<Email> meetCriteria(ArrayList<Email> emails,String filterNameSender,String filterNameSubject){
        ArrayList<Email> filteredEmails=new ArrayList<Email>();
        if(filterNameSender!=null) {
            filteredEmails = first.meetCriteria(emails, filterNameSender);
        }
        if(filterNameSender==null&&filterNameSubject!=null){
            filteredEmails=second.meetCriteria(emails,filterNameSubject);
        }
        if(filterNameSender!=null&&filterNameSubject!=null) {
            filteredEmails = second.meetCriteria(filteredEmails, filterNameSubject);
        }
        return filteredEmails;
    }
}
