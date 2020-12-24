package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
@SpringBootApplication
@CrossOrigin
@RestController
public class MainClass {
    Save s = new Save();
    Load l = new Load();
    Move m = new Move();
    ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) {
        /*Move m=new Move();
        m.move("4-12-2020Abdelrahman@MAJ.com","Abdelrahman@MAJ.com","Sent","Trash");*//*
        Email mail=new Email();
        mail.setSender("Mahmoud@MAJ.com");
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern(" yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt=LocalDateTime.now();
        mail.setDate(ldt.format(dtf));
        LinkedBasedQ q=new LinkedBasedQ();
        q.enqueue("Abdelrahman@MAJ.com");
        q.enqueue("Ahmed@MAJ.com");
        mail.setReceiver(q);
        Save s=new Save();*/
        SpringApplication.run(MainClass.class,args);
    }

    @PostMapping("/saveEmail")
    public void save(@RequestParam("mail") String mailJson, @RequestParam("attachments") MultipartFile[] files) {
        Email email = new Email();
        try {
            email = mapper.readValue(mailJson, Email.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        s.saveEmail(email, files);
    }

    @RequestMapping({"/loadEmails"})
    public ArrayList<Email> loadEmails(@RequestParam("userEmailAddress") String userEmailAddress, @RequestParam("folderName") String folderName, @RequestParam("page") int page) {
        return (ArrayList<Email>) l.loadEmails(userEmailAddress, folderName, page);
    }

    //Citation from https://www.javainuse.com/spring/boot-file-download with some changes
    //Load an attachment
    @GetMapping("/downloadAttachment")

    public void download(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileName") String fileName, @RequestParam("userEmailAddress") String userEmailAddress, @RequestParam("folderName") String folderName, @RequestParam("emailName") String emailName) throws IOException {
        String path = "System\\" + userEmailAddress + "\\" + folderName + "\\" + emailName + "\\" + fileName;
        File file = new File(path);
        if (file.exists()) {
            //get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                //unknown mimetype so set the mimetype to application/octet-stream
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);

            //(Content-Disposition->Attachment)  File is downloaded as an attachment
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());


        }

    }


    @PostMapping({"/moveEmails"})
    public void moveEmails(@RequestParam("userEmailAddress") String userEmailAddress, @RequestParam("emailName") String emailName, @RequestParam("oldFolder") String oldFolder, @RequestParam("newFolder") String newFolder) {
        m.move(emailName, userEmailAddress, oldFolder, newFolder);
    }

    @DeleteMapping({"/deleteEmails"})
    public void deleteEmails(@RequestParam("userEmailAddress") String userEmailAddress, @RequestParam("emailName") String emailName, @RequestParam("oldFolder") String oldFolder) {
        m.move(emailName, userEmailAddress, oldFolder, "Trash");
    }

    }

