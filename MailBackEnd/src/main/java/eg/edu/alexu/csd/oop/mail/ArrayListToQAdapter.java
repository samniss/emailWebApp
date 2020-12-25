package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public class ArrayListToQAdapter implements ArrayListToQ {
    ArrayListToQAdaptee adaptee;
    public ArrayListToQAdapter (ArrayListToQAdaptee a){
        this .adaptee=a;
    }
    public LinkedBasedQ changeToQ(ArrayList<String> receivers){
        return adaptee.changeToQ(receivers);
    }
}
