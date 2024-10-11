package FOS.pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Beverages extends ConcreteClass{
    
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

    //To add item in the cart
    public void addItem(String itemCode, int quantity) {
        sourceFilePath = "C:\\Users\\taran\\OneDrive\\Documents\\Java\\FOS\\pack1\\FileB.txt";  // Path to the source file
        destinationFilePath = "C:\\Users\\taran\\OneDrive\\Documents\\Git\\Food-Ordering-System\\FOS\\pack1\\Cart.txt"; // Path to the destination file

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedReader destReader = new BufferedReader(new FileReader(destinationFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath, true))) {
            
            int existingLineCount = 0;
            while (destReader.readLine() != null) {
                existingLineCount++; 
            }

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (lineNumber > existingLineCount && line.contains(itemCode)) {
                    writer.write(line);
                    writer.write("       |       " + quantity);
                    writer.newLine(); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
