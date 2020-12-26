package eg.edu.alexu.csd.oop.mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FolderTest {

    @Test
    void addFolder() {
    }

    @Test
    void removeFolder() {
    }

    @Test
    void renameFolder() {
    }

    @Test
    void moveEmail() {
    }

    @Test
    void setPath() {
    }

    @Test
    void checkExistUsername() {
        Folder f =new Folder();
        MailBackEndApplication m =MailBackEndApplication.getInstance();
        //to make sure that "momen@MAJ.com" is existing in the system folder
        //firstly we need to sign up to get folder of the user
        m.signUp("momen","momen@MAJ.com","123456","2000-4-20","male");
        //at first time the sign up will return true because the user address wasn't existing
        //after that when it is called it wiil return false because it is not valid to creat an existing user address
        //right user address
        assertTrue(f.checkExistUsername("momen@MAJ.com"));
        //wrong user address
        assertFalse(f.checkExistUsername("mome@MAJ.com"));
        //wrong syntax no @
        assertFalse(f.checkExistUsername("momenMAJ.com"));
        //wrong syntax not @ MAJ
        assertFalse(f.checkExistUsername("momen@mail.com"));
        //wrong syntax no .com
        assertFalse(f.checkExistUsername("momen@mail"));
        //wrong syntax no .
        assertFalse(f.checkExistUsername("momen@mailcom"));
        //wrong syntax no com
        assertFalse(f.checkExistUsername("momen@mail."));
        //null input
        assertFalse(f.checkExistUsername(null));
        //no input
        assertFalse(f.checkExistUsername(""));
    }

    @Test
    void checkPassword() {
        Folder f =new Folder();
        MailBackEndApplication m =MailBackEndApplication.getInstance();
        //to make sure that "momen@MAJ.com" is existing in the system folder
        //firstly we need to sign up to get folder of the user
        m.signUp("momen","momen@MAJ.com","123456","2000-4-20","male");
        //at first time the sign up will return true because the user address wasn't existing
        //after that when it is called it wiil return false because it is not valid to creat an existing user address
        //right password
        assertTrue(f.checkPassword("momen@MAJ.com","123456"));
        //wrong password
        assertFalse(f.checkPassword("momen@MAJ.com","1234"));
        //right address
        assertTrue(f.checkPassword("momen@MAJ.com","123456"));
        //no need to check wrong address because that was implemented in the method checkValidUserName
        //null address
        assertFalse(f.checkPassword(null,"123456"));
        //null password
        assertFalse(f.checkPassword("momeno@MAJ.com",null));
        //empty address
        assertFalse(f.checkPassword("","123456"));
        //empty password
        assertFalse(f.checkPassword("momeno@MAJ.com",""));
    }
}