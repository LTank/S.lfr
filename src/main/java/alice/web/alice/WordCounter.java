package alice.web.alice;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {

    Pattern pattern = Pattern.compile("[^\\p{Alpha}']+");

    public WordCounter() {
    }

    public Multiset<String> wordCount(File file) {
        try {
            Multiset<String> wSet = HashMultiset.create();
            if(file.isFile()){
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()){
                    scanner.useDelimiter(pattern);
                    String san = scanner.next();
                    if(!san.equals("")){
                        wSet.add(san);
                    }
                }
                for (String type : Multisets.copyHighestCountFirst(wSet).elementSet()) {
                    System.out.println(type + ": " + wSet.count(type));
                }
                file.delete();
                return wSet;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
