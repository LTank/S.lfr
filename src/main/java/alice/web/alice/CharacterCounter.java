package alice.web.alice;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.io.File;
import java.util.Scanner;

public class CharacterCounter {

    private String path = System.getProperty("user.dir")+"/";

    public CharacterCounter() {
    }

    public Multiset<String> charCount(){
        try {
            Multiset<String> cSet = HashMultiset.create();
            File file =new File(path + "AliceInWonderland.txt");
            if (file.isFile()){
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter("");
                while(scanner.hasNext()) {
                    String san = scanner.next().toLowerCase();
                    san = san.replaceAll("[^a-z]","");
                    cSet.add(san);
                }
                scanner.close();
                return cSet;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
