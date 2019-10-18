import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //https://api.agify.io/?name=michael
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a first name:");
        String name = input.nextLine();
        URL url = new URL("https://api.agify.io/?name=" + name);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("Accept", "text/html");
        conn.addRequestProperty("Accept-Language", "en-US");
        conn.addRequestProperty("User-Agent", "Mozilla/5.0");
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
}
