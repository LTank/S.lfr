package alice.web.alice;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileFetcher {

    private URL url;
    private String path = System.getProperty("user.dir")+"/";

    public FileFetcher() {
    }

    public File fileGetFromUrl(String s) {
        try{
            //getting url
            url = new URL(s);
            URLConnection conn = url.openConnection();

            //Opening a stream and inserts it into bufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            // saves the file at this name and path
            String fileName = "test.txt";
            File file = new File(path, fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            //use FileWriter to write file
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
            }

            bw.close();
            br.close();

            return file;
        }catch (Exception e){ }
        return null;
   }

}
