package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootApplication
@CrossOrigin
@RestController
public class MailBackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(MailBackEndApplication.class, args);
	}
	App app=new App();
	@GetMapping("/checkValidAddress")
	public boolean checkValidAddress(@RequestParam(value = "email",defaultValue = "") String mail){
		return app.checkValidAddress(mail);
	}
	@GetMapping("/signIn")
	public boolean signIn(@RequestParam(value = "email",defaultValue = "") String mail, @RequestParam(value = "password",defaultValue = "") String passwoed){
		return app.signIn(mail,passwoed);
	}
	@RequestMapping("/signUp")
	public boolean signUp(@RequestBody String shapeJson) throws JSONException {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<?, ?> map = null;
		try {
			map = objectMapper.readValue(shapeJson,Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return app.signUp((String)map.get("username"),(String)map.get("address"),(String)map.get("password"),(String)map.get("birthDate"),(String)map.get("gender"));
	}
}
