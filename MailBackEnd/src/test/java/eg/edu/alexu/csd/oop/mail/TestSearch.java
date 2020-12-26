package eg.edu.alexu.csd.oop.mail;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.*;
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSearch {
    MailBackEndApplication m =MailBackEndApplication.getInstance();
    @Test
    public void Test(){//Test searching
        //We tested all searches in one function so that we don't instantiate the email objects several times
        ArrayList<Email> emails=new ArrayList<Email>();
        Email e=new Email();
        e.setSender("Mahmoud@MAJ.com");
        e.setContent("hello");
        e.setSubject("Testing");
        e.setDate("15-15-2015");
        Email e2=new Email();
        e2.setContent("We love Mahmoud");
        e2.setSender("me@MAJ.com");
        e2.setSubject("Testing 2");
        e2.setDate("12-12-2012");
        ArrayList<String> attachment1=new ArrayList<String>();
        attachment1.add("white.jpg");
        attachment1.add("red.jgp");
        e2.setAttachments(attachment1);
        Email e3=new Email();
        e3.setContent("Ahmed is good");
        e3.setSender("NoOne@MAJ.com");
        e3.setSubject("Nothing");
        e3.setDate("12-12-2012");
        ArrayList<String> attachments2=new ArrayList<String>();
        attachments2.add("Hello.pdf");
        attachments2.add("white.jpg");
        e3.setAttachments(attachments2);
        emails.add(e);
        emails.add(e2);
        emails.add(e3);
        m.setMails(emails);


        ArrayList<Email> searchedMahmoud=m.searchEmailBack("Mahmoud");
        assertEquals("Mahmoud@MAJ.com",searchedMahmoud.get(0).getSender());
        assertEquals("We love Mahmoud",searchedMahmoud.get(1).getContent());



        ArrayList<Email> searchedTesting=m.searchEmailBack("Testing");
        assertEquals("Testing",searchedTesting.get(0).getSubject());
        assertEquals("Testing 2",searchedTesting.get(1).getSubject());



        ArrayList<Email> searchedWhite=m.searchEmailBack("white.jpg");
        assertEquals("me@MAJ.com",searchedWhite.get(0).getSender());
        assertEquals("NoOne@MAJ.com",searchedWhite.get(1).getSender());



        ArrayList<Email> searched12=m.searchEmailBack("12-12-2012");
        assertEquals("me@MAJ.com",searched12.get(0).getSender());
        assertEquals("NoOne@MAJ.com",searched12.get(1).getSender());
    }
}
