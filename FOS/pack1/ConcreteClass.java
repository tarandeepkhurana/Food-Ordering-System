package FOS.pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class ConcreteClass extends AbstractClass {
   private Scanner sc = new Scanner(System.in);
   public int quantity;
   public String itemCode;
   public String menuSelect;
   public String sourceFilePath;
   public String destinationFilePath;
   public static double billAmount = 0;
    
   public Hashtable<String, Integer> hashtable = new Hashtable<>() {{
      put("0A", 120); put("1A", 120); put("2A", 150); put("3A", 180); put("4A", 200); put("5A", 200); put("6A", 220); put("7A", 250); put("8A", 300); put("9A", 350);
      put("0B", 160); put("1B", 170); put("2B", 170); put("3B", 170); put("4B", 170); put("5B", 170); put("6B", 180); put("7B", 180); put("8B", 190); put("9B", 200);
      put("0D", 80); put("1D", 90); put("2D", 100); put("3D", 130); put("4D", 140); put("5D", 160); put("6D", 170); put("7D", 220); put("8D", 300); put("9D", 550);
   }};
    
   public Hashtable<String, Integer> cart = new Hashtable<>();

   public void addItem(String itemCode, int quantity) {
      //is overrided in the Appetizers, Beverages and Desserts class
   }

   //To process what the user wants to do
   public void processUserSelection() {
      String input2;
      do {
         System.out.print("Type 'A' to add item in your cart\nType 'R' to remove item from your cart\nType 'S' to see you cart\nType 'M' to see menu\nType 'F' to get the final bill\n\n");
         System.out.print("Enter your choice - ");
         input2 = sc.next();
         System.out.println("\n");
         switch (input2) {
            case "A":
               char input;
               do {
                 System.out.println("Enter the item code - ");
                 itemCode = sc.next();
                 System.out.println("Enter the quantity - ");
                 quantity = sc.nextInt();
                 cart.put(itemCode, quantity);
                 this.executeSpecificAddItem();
                 System.out.println("To add more items, press 'Y'\nTo exit, press 'N'");
                 input = sc.next().charAt(0);
               } while (input == 'Y');
               break;
            case "R":
               System.out.println("Enter the item code - ");
               itemCode = sc.next();
               System.out.println("Enter the quantity - ");
               quantity = sc.nextInt();
               int quantityRemaining = cart.get(itemCode) - quantity;
               if (quantityRemaining == 0) {
                  this.removeItem(itemCode, quantity);
               } else {
                  this.removeItem(itemCode, quantity);
                  if(itemCode.charAt(1) == 'A'){
                     Appetizers app = new Appetizers();
                     app.addItem(itemCode, quantityRemaining);
                  } else if(itemCode.charAt(1) == 'B') {
                     Beverages bev = new Beverages();
                     bev.addItem(itemCode, quantityRemaining);
                  } else {
                     Desserts des = new Desserts();
                     des.addItem(itemCode, quantityRemaining);
                  }
               }
               break;
            case "S":
               this.seeCart();
               this.Bill();
               break;
            case "M":
               this.seeMenu();
               break;
            case "F":
               this.seeCart();
               this.Bill("Final");
               break;
            default:
               System.out.println("Incorrect Response!\nEnter your choice - ");
               break;
          }
        } while (!input2.equals("F"));
    }

    //To see menu
    public void seeMenu() {
        do {
         System.out.print("Enter your choice (Type 'A' for Appetizers, 'B' for Beverages, 'D' for Desserts) - ");
         menuSelect = sc.next();
         switch (menuSelect) {
            case "A":
               Appetizers objA = new Appetizers();
               objA.List();
               break;
            case "B":
               Beverages objB = new Beverages();
               objB.List();
               break;
            case "D":
               Desserts objD = new Desserts();
               objD.List();
               break;
            default:
               System.out.print("Incorrect Response!\n");
               break;
          }
	    } while (!menuSelect.equals("A") && !menuSelect.equals("B") && !menuSelect.equals("D"));
   }
    
    //To execute specific addItem method
    public void executeSpecificAddItem() {
       billAmount += (hashtable.get(itemCode) * quantity);
       switch (menuSelect) {
        case "A":
            Appetizers app = new Appetizers();
            app.addItem(itemCode, quantity);
            break;
        case "B":
            Beverages bev = new Beverages();
            bev.addItem(itemCode, quantity);
            break;
        case "D":
            Desserts des = new Desserts();
            des.addItem(itemCode, quantity);
            break;
        default:
            break;
       }
   }
   
   //To remove item from the cart
   public void removeItem(String itemCode, int quantity) {
      billAmount -= (hashtable.get(itemCode) * quantity);
      String filePath = "C:\\Users\\taran\\OneDrive\\Java Programs\\com\\pack1\\cart.txt";

      try {
         // Read all lines from the file
         Path path = Paths.get(filePath);
         List<String> lines = Files.readAllLines(path);

         // Create a new list to store lines that do not contain the substring
         List<String> updatedLines = new ArrayList<>();

         // Iterate through the lines and add lines that do not contain the substring
         for (String line : lines) {
            if (!line.contains(itemCode)) {
               updatedLines.add(line);
            }
         }

         // Write the updated lines back to the file
         Files.write(path, updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
   }

   //To see cart
   public void seeCart(){
      String filePath = "C:\\Users\\taran\\OneDrive\\Documents\\Git\\Food-Ordering-System\\FOS\\pack1\\Cart.txt";
  
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

   //Current bill
   public void Bill() {
      System.out.println("Your current bill amount - Rs " + billAmount + "\n\n");
   }

   //Final bill
   public void Bill(String userID) {
      double discount = 0;
      double gstAmount = 0.18 * billAmount;
      int platformFee = 6;
      double finalBillAmount;

      if (billAmount > 199 && billAmount < 299) {
         discount = 0.1 * billAmount;
      } else if (billAmount > 299) {
         discount = 0.2 * billAmount;
      }

      finalBillAmount = billAmount + gstAmount + platformFee - discount;
      
      System.out.println("Item total                  Rs " + billAmount + 
                       "\nGST charges                 Rs " + gstAmount + 
                       "\nPlatform Fee                Rs " + platformFee + 
                       "\nDiscount                    Rs " + discount +
                       "\nGrand total                 Rs " + finalBillAmount + 
                       "\n\nThank you for your order! We hope you enjoy your meal!");
   }
}

