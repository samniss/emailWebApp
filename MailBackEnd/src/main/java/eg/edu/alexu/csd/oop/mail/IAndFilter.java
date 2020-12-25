package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public interface IAndFilter {
    public ArrayList<Email> meetCriteria(ArrayList<Email> emails, String filterNameSender,String filterNameSubject);
}
