package FOS.pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Beverages extends Menu {
    
     //To print the items list
    public void List() {      
        String filePath = "C:\\Users\\taran\\OneDrive\\Documents\\Java\\FOS\\pack1\\FileB.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
