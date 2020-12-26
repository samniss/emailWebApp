package eg.edu.alexu.csd.oop.mail;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSort {
    MailBackEndApplication m =MailBackEndApplication.getInstance();
    @Test
    public void Test(){


        //We tested all sortings in one function so that we don't instantiate the email objects several times
        ArrayList<Email> emails=new ArrayList<Email>();
        Email e=new Email();
        e.setSender("Mahmoud@MAJ.com");
        e.setContent("hello");
        e.setSubject("Testing");
        e.setDate("2020-08-15 15-12-03");//yyyy-MM-dd HH-mm-ss
        e.setPriority(3);
        Email e2=new Email();
        e2.setContent("We love Mahmoud");
        e2.setSender("Me@MAJ.com");
        e2.setSubject("Testing 2");
        e2.setDate("2020-08-15 13-12-03");
        e2.setPriority(1);
        Email e3=new Email();
        e3.setContent("Ahmed is good");
        e3.setSender("None@MAJ.com");
        e3.setSubject("Nothing");
        e3.setDate("2020-08-14 15-12-03");
        e3.setPriority(2);
        emails.add(e);
        emails.add(e2);
        emails.add(e3);
        m.setMails(emails);
        ArrayList<Email> sortedSender=m.sortEmailBack("Sender");
        ArrayList<Email> sortedSubject=m.sortEmailBack("Subject");
        ArrayList<Email> sortedPriority=m.sortEmailBack("Priority");
        ArrayList<Email> sortedDate=m.sortEmailBack("Date");


        assertEquals(e.getSender(),sortedSender.get(0).getSender());
        assertEquals(e2.getSender(),sortedSender.get(1).getSender());
        assertEquals(e3.getSender(),sortedSender.get(2).getSender());

        assertEquals(e3.getSubject(),sortedSubject.get(0).getSubject());
        assertEquals(e.getSubject(),sortedSubject.get(1).getSubject());
        assertEquals(e2.getSubject(),sortedSubject.get(2).getSubject());
        //Priority 1>2>3>...
        assertEquals(e2.getPriority(),sortedPriority.get(0).getPriority());
        assertEquals(e3.getPriority(),sortedPriority.get(1).getPriority());
        assertEquals(e.getPriority(),sortedPriority.get(2).getPriority());

        assertEquals(e3.getDate(),sortedDate.get(0).getDate());
        assertEquals(e2.getDate(),sortedDate.get(1).getDate());
        assertEquals(e.getDate(),sortedDate.get(2).getDate());



    }
}
