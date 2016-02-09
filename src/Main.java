import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        URL url;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br;
        BufferedWriter bw;
        String line;
        File file;

        try {
            file = new File("C:\\Users\\YB\\Desktop\\URL.txt");
            url = new URL("http://ua.korrespondent.net/");
            is = url.openStream();
            os = new FileOutputStream(file);
            br = new BufferedReader(new InputStreamReader(is));
            bw = new BufferedWriter(new OutputStreamWriter(os));
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
                System.out.println(line);
            }
            is.close();
            os.flush();
            os.close();
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
            }
        }
    }
}
