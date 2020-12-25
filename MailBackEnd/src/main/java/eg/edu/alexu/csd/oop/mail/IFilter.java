package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public interface IFilter {
public ArrayList<Email> meetCriteria(ArrayList<Email> emails,String filterName);
}
