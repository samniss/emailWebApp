package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;
//Classes that implement this interface will do one function which is changing an arrayList of receivers to A queue of receivers
public interface ArrayListToQ {
    LinkedBasedQ changeToQ(ArrayList<String> receivers);
}
