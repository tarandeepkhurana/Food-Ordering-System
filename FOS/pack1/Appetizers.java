package FOS.pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Appetizers extends ConcreteClass{
    
    //To print the items list
    public void List() {      
        String filePath = "C:\\Users\\taran\\OneDrive\\Documents\\Git\\Food-Ordering-System\\FOS\\pack1\\FileA.txt";

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
        sourceFilePath = "C:\\Users\\taran\\OneDrive\\Documents\\Git\\Food-Ordering-System\\FOS\\pack1\\FileA.txt";  // Path to the source file
        destinationFilePath = "C:\\Users\\taran\\OneDrive\\Documents\\Git\\Food-Ordering-System\\FOS\\pack1\\Cart.txt"; // Path to the destination file

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             RandomAccessFile raf = new RandomAccessFile(destinationFilePath,"rw");
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath, true))) {
            
            // Move the cursor to the end of the file to check if it ends with a newline
            long length = raf.length();
            if (length > 0) {
              raf.seek(length - 1);
              int lastByte = raf.read();
              if (lastByte != '\n') {
                // Add a newline only if the file doesn't already end with one
                writer.newLine();
              }
            }
            
            String line;
            while ((line = reader.readLine()) != null) {
              if (line.contains(itemCode)) {
                writer.write(line);
                writer.write("       |       " + quantity);
              }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
}


