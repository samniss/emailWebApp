package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@SpringBootApplication
@CrossOrigin
@RestController
public class MainClass {
   static MailBackEndApplication main=MailBackEndApplication.getInstance();

    public static void main(String args[]) {
        SpringApplication.run(MainClass.class,args);
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

    @RequestMapping({"/loadFolders"})
    public ArrayList<File> loadFolders(@RequestParam("page") int page) {
        return main.loadFolders(page);
    }

    @GetMapping({"/addFolders"})
    public boolean addFolder(@RequestParam("folderName") String  folderName) {
        return main.addFolder(folderName);
    }

    @DeleteMapping({"/deleteFolder"})
    public boolean deleteFolder(@RequestParam("folderName") String  folderName) {
        return main.deleteFolder(folderName);
    }

    @PutMapping({"/updateFolderName"})
    public boolean updateFolderName(@RequestParam("oldName") String oldName,@RequestParam("newName") String newName){
        return main.updateFolderName(oldName,newName);
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
    @RequestMapping ({"/addContact"})
    public boolean addContact(@RequestBody String contact){

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
        if(!oldName.equals(newName)) {
            return main.updateContactName(oldName, newName);
        }
        else {
            return true;//Won't do anything because the old name and the new name are the same
        }
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
    public List<Contact> loadContacts(@RequestParam ("pageNum") int page){
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

    @PostMapping("/setCurrentEmail")
    public void setCurrentEmail(@RequestParam("currentEmail")String currentEmail){
        main.setCurrentEmailName(currentEmail);
    }
    @GetMapping("/getCurrentEmail")
    public Email getCurrentEmail(){
        return main.getCurrentEmailName();
    }
}

