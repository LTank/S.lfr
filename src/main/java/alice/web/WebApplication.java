package alice.web;

import alice.web.alice.CharacterCounter;
import alice.web.alice.FileFetcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		CharacterCounter c = new CharacterCounter();
        FileFetcher f = new FileFetcher();

		f.fileCharScan();

	}
}
