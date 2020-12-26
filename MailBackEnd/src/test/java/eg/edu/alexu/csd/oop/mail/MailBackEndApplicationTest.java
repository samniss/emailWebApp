package eg.edu.alexu.csd.oop.mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailBackEndApplicationTest {

    @Test
    void getInstance() {
        //the MailBackEndApplication m is null
        MailBackEndApplication m =null;
        assertNull(m);
        //make m instance of MailBackEndApplication
        m =MailBackEndApplication.getInstance();
        //m is not null because it is instance of the MailBackEndApplication
        assertNotNull(m);
        //the MailBackEndApplication n is null
        MailBackEndApplication n =null;
        assertNull(n);
        //make n instance of MailBackEndApplication
        n =MailBackEndApplication.getInstance();
        //n is not null because it is instance of the MailBackEndApplication
        assertNotNull(n);
        //m and n are equal because they are the same instance of the MailBackEndApplication
        assertEquals(m,n);
    }

    @Test
    void save() {

    }

    @Test
    void loadEmails() {
    }

    @Test
    void download() {
    }

    @Test
    void moveEmails() {
    }

    @Test
    void deleteEmails() {
    }

    @Test
    void setMails() {
    }

    @Test
    void getMails() {
    }

    @Test
    void signIn() {
        MailBackEndApplication m =MailBackEndApplication.getInstance();
        //firstly we need to sign up to get folder of the user
        m.signUp("momen","momen@MAJ.com","123456","2000-4-20","male");
        //at first time the sign up will return true because the user address wasn't existing
        //after that when it is called it wiil return false because it is not valid to creat an existing user address
        //right password
        assertTrue(m.signIn("momen@MAJ.com","123456"));
        //wrong password
        assertFalse(m.signIn("momen@MAJ.com","1234"));
        //right address
        assertTrue(m.signIn("momen@MAJ.com","123456"));
        //wrong address
        assertFalse(m.signIn("momeno@MAJ.com","1234"));
        //null address
        assertFalse(m.signIn(null,"123456"));
        //null password
        assertFalse(m.signIn("momeno@MAJ.com",null));
        //empty address
        assertFalse(m.signIn("","123456"));
        //empty password
        assertFalse(m.signIn("momeno@MAJ.com",""));
    }

    @Test
    void signUp() {
        MailBackEndApplication m =MailBackEndApplication.getInstance();
        //firstly we need to sign up to get folder of the user
        m.signUp("momen","momen@MAJ.com","123456","2000-4-20","male");
        //at first time the sign up will return true because the user address wasn't existing
        //after that when it is called it wiil return false because it is not valid to creat an existing user address
        assertFalse(m.signUp("momen","momen@MAJ.com","123456","2000-4-20","male"));
        //null name
        assertFalse(m.signUp(null,"momen@MAJ.com","123456","2000-4-20","male"));
        //null address
        assertFalse(m.signUp("momen",null,"123456","2000-4-20","male"));
        //null password
        assertFalse(m.signUp("momen","momen@MAJ.com",null,"2000-4-20","male"));
        //null birthDate
        assertFalse(m.signUp("momen","momen@MAJ.com","123456",null,"male"));
        //null gender
        assertFalse(m.signUp("momen","momen@MAJ.com","123456","2000-4-20",null));
        //no name
        assertFalse(m.signUp("","momen@MAJ.com","123456","2000-4-20","male"));
        //no address
        assertFalse(m.signUp("momen","","123456","2000-4-20","male"));
        //no password
        assertFalse(m.signUp("momen","momen@MAJ.com","","2000-4-20","male"));
        //no birthDate
        assertFalse(m.signUp("momen","momen@MAJ.com","123456","","male"));
        //no gender
        assertFalse(m.signUp("momen","momen@MAJ.com","123456","2000-4-20",""));
        //note:we make sure that the email syntax is right using the method checkValidEmail by calling it
        // in the front end so it was not important to call it inside the sig up

    }

    @Test
    void checkValidAddress() {
        MailBackEndApplication m =MailBackEndApplication.getInstance();
        //true syntax
        assertTrue(m.checkValidAddress("momen@MAJ.com"));
        //wrong syntax no @
        assertFalse(m.checkValidAddress("momenMAJ.com"));
        //wrong syntax not @ MAJ
        assertFalse(m.checkValidAddress("momen@mail.com"));
        //wrong syntax no .com
        assertFalse(m.checkValidAddress("momen@mail"));
        //wrong syntax no .
        assertFalse(m.checkValidAddress("momen@mailcom"));
        //wrong syntax no com
        assertFalse(m.checkValidAddress("momen@mail."));
        //null input
        assertFalse(m.checkValidAddress(null));
        //no input
        assertFalse(m.checkValidAddress(""));
    }
}