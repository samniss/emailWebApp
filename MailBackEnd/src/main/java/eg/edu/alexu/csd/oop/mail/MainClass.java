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
import java.util.*;
@SpringBootApplication
@CrossOrigin
@RestController
public class MainClass {
    public static void main(String args[]) {
        Save s=new Save();
        Load l=new Load();
        Move m=new Move();
        Email mail=new Email();
        ObjectMapper mapper=new ObjectMapper();
        mail.setSender("Abdelrahman@MAJ.com");
        mail.setDate("1-12-2020");
        LinkedBasedQ q=new LinkedBasedQ();
        q.enqueue("Ahmed@MAJ.com");
        q.enqueue("Mahmoud@MAJ.com");
        String emailName=mail.getDate()+mail.getSender();
        m.move(emailName,mail.getSender(),"Sent","Trash");


    }

    @RequestMapping({"save"})
    public String savings(@RequestParam("files") MultipartFile[] files,@RequestParam("userEmailAddress") String userEmailAddress,@RequestParam("folderName") String folderName,@RequestParam("emailName") String emailName){
        Save s=new Save();
        s.saveAttachments(files,userEmailAddress,folderName,emailName);
        return "Success";
    }


    @PostMapping({"/test"})

    public String test(@RequestBody MultipartFile[] files ){

//        for(int i=0;i<files.size();i++) {
//            String fileName = "C:\\Users\\AboodKG\\New folder\\Documents\\Desktop" + "\\" + files.get(i).getOriginalFilename();
//            File f = new File(fileName);
//            try {
//                files.get(i).transferTo(f);
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("===============================");
//                System.out.println("Couldn't Transfer");
//                System.out.println("===============================");
//            }
//        }
        return "Success";
    }

    //Citation from https://www.javainuse.com/spring/boot-file-download with some changes
    @RequestMapping("/download")

    public void download(HttpServletRequest request, HttpServletResponse response,@RequestParam("fileName") String fileName,@RequestParam("userEmailAddress") String userEmailAddress,@RequestParam("folderName") String folderName,@RequestParam("emailName") String emailName) throws IOException {
        String path="System\\"+userEmailAddress+"\\"+folderName+"\\"+emailName+"\\"+fileName;
        File file = new File(path);
        if (file.exists()) {
            //get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                //unknown mimetype so set the mimetype to application/octet-stream
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);

            /**
             * In a regular HTTP response, the Content-Disposition response header is a
             * header indicating if the content is expected to be displayed inline in the
             * browser, that is, as a Web page or as part of a Web page, or as an
             * attachment, that is downloaded and saved locally.
             *
             */

            /**
             * Here we have mentioned it to show inline
             */
            //response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            //Here we have mentioned it to show as attachment
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());


        }

    }

}
