package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
@SpringBootApplication
@CrossOrigin
@RestController
public class MainClass {
    public static void main(String args[]){
        ObjectMapper mapper=new ObjectMapper();
        ArrayList<String> s=new ArrayList<String>();
        try {
            s=mapper.readValue(Paths.get("Testing.json").toFile(),ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s.size());
    }
    @RequestMapping({"/test"})

    public void test(@RequestBody String attachmentJson ){
        ObjectMapper mapper=new ObjectMapper();
        File f=null;
        try {
            f=mapper.readValue(attachmentJson,File.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("===============================");
            System.out.println("Couldn't change it");
            System.out.println("===============================");
        }

        try {
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===============================");
            System.out.println("Cannot read it m8");
            System.out.println("===============================");
        }
    }

}
