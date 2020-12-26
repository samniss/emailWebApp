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
public class TestSaveLoad {
    Save s=new Save();
    Load l=new Load();
    MailBackEndApplication m =MailBackEndApplication.getInstance();

    /************
     *
     * VERY VERY IMPORTANT

    To run the tests there shouldn't be email Addresses similar to those used in the tests or the signUp function will produce error
    The tests should run once or the signUp function will produce error because of signing up with existing email address

     */
    @Test
    public void TestA(){//save and load test 1
        //signup contains saveUserData so we won't test it separately
        //First we signUp to make the folders of the user
        //We create a new User
        m.signUp("Saad","Saad@MAJ.com","123456","2000-4-20","male");
        m.signUp("momen","momen@MAJ.com","123456","2000-4-20","male");
        User momen=l.loadUserInfo("momen@MAJ.com");
        assertEquals("momen",momen.getName());
        assertEquals("momen@MAJ.com",momen.getUserEmailAddress());
        assertEquals("123456",momen.getPassword());
        assertEquals("2000-4-20",momen.getBirthDate());
        assertEquals("male",momen.getGender());
    }
    @Test
    public void TestB(){//save and load test 2
        //First we signUp to make the folders of the user
        m.signUp("Abdelrahman","Abdelrahman@MAJ.com","246810","2000-2-15","male");
        User Abdelrahman=l.loadUserInfo("Abdelrahman@MAJ.com");
        assertEquals("Abdelrahman",Abdelrahman.getName());
        assertEquals("Abdelrahman@MAJ.com",Abdelrahman.getUserEmailAddress());
        assertEquals("246810",Abdelrahman.getPassword());
        assertEquals("2000-2-15",Abdelrahman.getBirthDate());
        assertEquals("male",Abdelrahman.getGender());
    }
    @Test
    public void TestC(){//save and load test 3
        //First we signUp to make the folders of the user
        m.signUp("Mohamed","Mohamed@MAJ.com","24681012","2000-3-17","male");
        User Mohamed=l.loadUserInfo("Mohamed@MAJ.com");
        assertEquals("Mohamed",Mohamed.getName());
        assertEquals("Mohamed@MAJ.com",Mohamed.getUserEmailAddress());
        assertEquals("24681012",Mohamed.getPassword());
        assertEquals("2000-3-17",Mohamed.getBirthDate());
        assertEquals("male",Mohamed.getGender());
    }

    /////m.addContact will call s.saveContact so we are testing both of the functions
    @Test
    public void TestD(){//test save contact
        m.setUserEmailAddress("Abdelrahman@MAJ.com");//Set the user from whom the contact will be added
        Contact contact =new Contact();
        contact.setName("Mohamed");
        ArrayList<String> emailAddresses=new ArrayList<String>();
        emailAddresses.add("Mohamed@MAJ.com");
        emailAddresses.add("momen@MAJ.com");
        contact.setEmailAddresses(emailAddresses);

        boolean saved=m.addContact(contact);
        assertTrue(saved);
        ArrayList<Contact> contacts=(ArrayList<Contact>)m.loadContacts(1);
        assertEquals("Mohamed",contacts.get(0).getName());
        assertEquals("Mohamed@MAJ.com",contacts.get(0).getEmailAddresses().get(0));
        assertEquals("momen@MAJ.com",contacts.get(0).getEmailAddresses().get(1));
    }
    @Test

    public void TestE(){
        //test save contact 2
        //trying to save contact for whom  one of the emails doesn't exist
        m.setUserEmailAddress("Abdelrahman@MAJ.com");//Set the user from whom the contact will be added
        Contact contact =new Contact();
        contact.setName("Mohamed");
        ArrayList<String> emailAddresses=new ArrayList<String>();
        emailAddresses.add("Mohamed@MAJ.com");
        emailAddresses.add("Ali@MAJ.com");//Ali@MAJ.com doesn't exist
        contact.setEmailAddresses(emailAddresses);
        boolean save= m.addContact(contact);
        assertFalse(save);
    }

    @Test
    public void TestF(){//Testing changing the name of contact
        m.setUserEmailAddress("Abdelrahman@MAJ.com");//Setting the email address of the user who has the contacts
      boolean right=  m.updateContactName("Mohamed","Mahmoud");
      assertTrue(right);//check if the name of the contact has been updated successfully
    }
    @Test
    public void TestG(){//Testing change the name of the contact but the new name already exists
        m.setUserEmailAddress("Abdelrahman@MAJ.com");
        //Make a new Contact called ahmed
        Contact contact =new Contact();
        contact.setName("Ahmed");
        ArrayList<String> emailAddresses=new ArrayList<String>();
        emailAddresses.add("Mohamed@MAJ.com");
        emailAddresses.add("momen@MAJ.com");
        contact.setEmailAddresses(emailAddresses);
        m.addContact(contact);

        //Try to update the contact whose name is Mahmoud with the new name Ahmed
        boolean right=  m.updateContactName("Mahmoud","Ahmed");
        assertFalse(right);//check if the name of the contact has been updated successfully
    }
    @Test
    public void TestH(){//Testing update the email address of the contact
        m.setUserEmailAddress("Abdelrahman@MAJ.com");
        //We create a new User
        m.signUp("Saad","Saad@MAJ.com","123456","2000-4-20","male");
       boolean right= m.updateContactEmail("Mahmoud","momen@MAJ.com","Saad@MAJ.com");
        assertTrue(right);
    }
    @Test
    public void TestI(){//Test updating the email address of the contact but the new email doesn't exist
        m.setUserEmailAddress("Abdelrahman@MAJ.com");
        boolean right=m.updateContactEmail("Mahmoud","Mohamed@MAJ.com","Ali@MAJ.com");
        assertFalse(right);

    }
    //cannot test m.save because it requires json object so we are testing s.saveEmail which is called by m.save
    @Test
    public void TestK(){//test saving and loading  email
        //Create a new Email and save it
        m.setUserEmailAddress("Abdelrahman@MAJ.com");//Set the user from whom the contact will be added
        m.setFolderName("Sent");
        Email email =new Email();
        email.setSender("Abdelrahman@MAJ.com");
        email.setSubject("Testing");
        email.setContent("Tests");
        email.setDraft(false);
        email.setPriority(0);
        email.setAttachments(null);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime ldt= LocalDateTime.now();
        email.setDate(ldt.format(dtf));
        LinkedBasedQ q=new LinkedBasedQ();
        q.enqueue("momen@MAJ.com");
        q.enqueue("Mohamed@MAJ.com");
        email.setReceiver(q);
        s.saveEmail(email,null);
        ArrayList<Email> emails=m.loadEmails(1);
        //load the email and test if it was saved correctly
        assertEquals("Abdelrahman@MAJ.com",emails.get(0).getSender());
        assertEquals("Testing",emails.get(0).getSubject());
        assertEquals("Tests",emails.get(0).getContent());
        assertEquals(0,emails.get(0).getPriority());
        assertEquals(null,emails.get(0).getAttachments());
        assertFalse(emails.get(0).isDraft());
        assertEquals("momen@MAJ.com",(String)emails.get(0).getReceiver().dequeue());
        assertEquals("Mohamed@MAJ.com",(String)emails.get(0).getReceiver().dequeue());
    }


}
