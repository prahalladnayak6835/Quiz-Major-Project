package pd.example.demo.major.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
//spring:
//		data:
//		mongodb:
//		uri : mongodb+srv://prahalladnayak2060:1234@cluster0.nfzfkzh.mongodb.net/?retryWrites=true&w=majority
//		database : Major
