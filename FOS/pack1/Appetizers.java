package FOS.pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Appetizers {
    
    //To print the items list
    public void List() {      
        String filePath = "D:\\priyank\\SGSITS\\OOPS\\PROJECT\\Food-Ordering-System\\FOS\\pack1\\FileA.txt";

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


