package alice.web;

import alice.web.alice.CharacterCounter;
import alice.web.alice.FileFetcher;
import alice.web.alice.WordCounter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);

		CharacterCounter c = new CharacterCounter();
		FileFetcher f = new FileFetcher();
		WordCounter w = new WordCounter();

        String exit = "exit";

        while (true){
            System.out.print("Paste URL: ");
            Scanner scan = new Scanner(System.in);
            String url = scan.next();
            if(exit.equalsIgnoreCase(url)){
                break;
            }
            c.charCount(f.fileGetFromUrl(url));
            w.wordCount(f.fileGetFromUrl(url));

        }

	}
}
