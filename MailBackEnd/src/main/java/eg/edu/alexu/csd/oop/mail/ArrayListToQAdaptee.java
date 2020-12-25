package eg.edu.alexu.csd.oop.mail;

import java.util.ArrayList;

public class ArrayListToQAdaptee {
    public LinkedBasedQ changeToQ(ArrayList<String> receivers){
        LinkedBasedQ receiversQ=new LinkedBasedQ();
        for(int i=0;i<receivers.size();i++){
            receiversQ.enqueue(receivers.get(i));
        }
        return receiversQ;
    }
}
