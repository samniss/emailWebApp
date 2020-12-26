package eg.edu.alexu.csd.oop.mail;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@CrossOrigin
@RestController
public class MainClass {
   static MailBackEndApplication main=MailBackEndApplication.getInstance();

    public static void main(String args[]) {
        long timeInMillis = 1567109422*1000L;
        Instant instant = Instant.ofEpochMilli(timeInMillis);
        LocalDateTime date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(date.format(dtf));
    }
    @GetMapping("/checkValidAddress")
    public boolean checkValidAddress(@RequestParam(value = "email",defaultValue = "") String mail){
        return main.checkValidAddress(mail);
    }
    @GetMapping("/signIn")
    public boolean signIn(@RequestParam(value = "email",defaultValue = "") String mail, @RequestParam(value = "password",defaultValue = "") String passwoed){
        main.setUserEmailAddress(mail);
        return main.signIn(mail,passwoed);
    }
    @RequestMapping("/signUp")
    public boolean signUp(@RequestBody String shapeJson) {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<?, ?> map = null;
        try {
            map = objectMapper.readValue(shapeJson,Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        main.setUserEmailAddress((String)map.get("address"));
        return main.signUp((String)map.get("username"),(String)map.get("address"),(String)map.get("password"),(String)map.get("birthDate"),(String)map.get("gender"));
    }
    @PostMapping("/saveEmail")
    public void save(@RequestParam("mail") String mailJson, @RequestParam("attachments") MultipartFile[] attachments,@RequestParam("receivers") ArrayList<String> receivers) {

        main.save(mailJson,attachments,receivers);
    }

    @RequestMapping({"/loadEmails"})
    public ArrayList<Email> loadEmails(@RequestParam("page") int page,@RequestParam("folderName") String folderName) {
        main.setFolderName(folderName);
        main.setMails(main.loadEmails(page));
        return main.getMails();
    }

    @GetMapping("/downloadAttachment")
    public void download(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileName") String fileName, @RequestParam("emailName") String emailName) {
        main.download(request,response,fileName,emailName);
    }


    @PostMapping({"/moveEmails"})
    public void moveEmails(@RequestParam("emailNames") ArrayList<String> emailNames, @RequestParam("newFolder") String newFolder) {
        main.moveEmails(emailNames,newFolder);
    }

    @DeleteMapping({"/deleteEmails"})
    public void deleteEmails(@RequestParam("emailNames") ArrayList<String> emailNames) {
        main.deleteEmails(emailNames);
    }
    @PostMapping ({"/addContact"})
    public boolean addContact(@RequestParam("contact") String contact){

        ObjectMapper mapper=new ObjectMapper();
        Contact cont=null;
        try {
             cont=mapper.readValue(contact,Contact.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return main.addContact(cont);
    }
    @DeleteMapping({"/deleteContact"})
    public void deleteContact(@RequestParam("contactName") String contactName){
        main.deleteContact(contactName);
    }
    @PutMapping({"/updateContactName"})
    public boolean updateContactName(@RequestParam("oldName") String oldName,@RequestParam("newName") String newName){
        return main.updateContactName(oldName,newName);
    }
    @PutMapping({"/updateContactEmail"})
    public boolean updateContactEmail(@RequestParam("contactName") String contactName,@RequestParam("oldEmailAddress")String oldEmailAddress,@RequestParam("newEmailAddress") String newEmailAddress){
       return  main.updateContactEmail(contactName,oldEmailAddress,newEmailAddress);
    }
    @GetMapping({"/filterEmails"})
    public ArrayList<Email> filterEmails(String filterNameSender,String filterNameSubject){
        return main.filterBoth(filterNameSender, filterNameSubject);
    }
    @GetMapping("/loadContacts")
    public List<Contact> loadContacts(int page){
        return main.loadContacts(page);
    }
    @GetMapping("/searcher")
    public ArrayList<Email> searchEmails(@RequestParam("searchKey")String searchKey){
        return main.searchEmailBack(searchKey);
    }
    @GetMapping("/sorter")
    public ArrayList<Email> sortEmails(@RequestParam("sortKey")String sortKey){
        return main.sortEmailBack(sortKey);
    }
    }

