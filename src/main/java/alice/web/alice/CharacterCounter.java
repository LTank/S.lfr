package alice.web.alice;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.io.File;
import java.util.Scanner;

public class CharacterCounter {

    public CharacterCounter() {
    }

    public Multiset<String> charCount(File file){
        try {
            Multiset<String> cSet = HashMultiset.create();
            if (file.isFile()){
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter("");
                while(scanner.hasNext()) {
                    String san = scanner.next().toLowerCase();
                    san = san.replaceAll("[^a-z]","");
                    if(!san.equals("")){
                        cSet.add(san);
                    }
                }
                System.out.println(cSet);
                scanner.close();
                file.delete();
                return cSet;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
