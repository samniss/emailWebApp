package eg.edu.alexu.csd.oop.mail;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestSaveLoad {
    @Test
    public void test1(){
        User user=mock(User.class);
        Save s=new Save();
        Load l=new Load();
        s.saveUserData(user);
    }
}
