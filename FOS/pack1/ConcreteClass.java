package FOS.pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class ConcreteClass extends AbstractClass {
    private Scanner sc = new Scanner(System.in);
    public int quantity;
    public String itemCode;
    public String menuSelect;
    public String sourceFilePath;
    public String destinationFilePath;
    public static double bill = 0;
    
    public Hashtable<String, Integer> hashtable = new Hashtable<>() {{
        put("0A", 120); put("1A", 120); put("2A", 150); put("3A", 180); put("4A", 200); put("5A", 200); put("6A", 220); put("7A", 250); put("8A", 300); put("9A", 350);
        put("0B", 160); put("1B", 170); put("2B", 170); put("3B", 170); put("4B", 170); put("5B", 170); put("6B", 180); put("7B", 180); put("8B", 190); put("9B", 200);
        put("0D", 80); put("1D", 90); put("2D", 100); put("3D", 130); put("4D", 140); put("5D", 160); put("6D", 170); put("7D", 220); put("8D", 300); put("9D", 550);
    }};
    
    public void addItem(String itemCode, int quantity) {
        //is overrided in the Appetizers, Beverages and Desserts class
    }
    //To process what the user wants to do
    public void processUserSelection() {
        String input2;
        do {
          System.out.print("Type 'A' to add item in your cart\nType 'R' to remove item from your cart\nType 'S' to see you cart\nType 'E' to see another menu\nType 'F' to get the final bill\n\n");
          System.out.print("Enter your choice - ");
          input2 = sc.next();
          switch (input2) {
            case "A":
               char input;
               do {
                 System.out.println("Enter the item code - ");
                 itemCode = sc.next();
                 System.out.println("Enter the quantity - ");
                 quantity = sc.nextInt();
                 this.executeSpecificAddItem();
                 System.out.println("To add more items, press 'Y'\nTo exit, press 'N'");
                 input = sc.next().charAt(0);
               } while (input == 'Y');
               break;
            case "R":
               System.out.println("Enter the item code - ");
               itemCode = sc.next();
               // removeItem(input4);
               break;
            case "S":
               // seeCart();
               break;
            case "E":
               // seeMenu();
               break;
            case "F":
               // getFinalBill();
               break;
            default:
               System.out.println("Incorrect Response!\nEnter your choice - ");
               break;
          }
        } while (input2 != "F");
        sc.close();
    }

    //To see menu
    public void seeMenu() {
        System.out.println("Enter your choice (Type 'A' for Appetizers, 'B' for Beverages, 'D' for Desserts) - ");
        Scanner sc = new Scanner(System.in);
        menuSelect = sc.next();
        do {
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
               System.out.print("Incorrect Response!\nEnter your choice (Type 'A' for Appetizers, 'B' for Beverages, 'D' for Desserts) - ");
               break;
          }
	    } while (!menuSelect.equals("A") && !menuSelect.equals("B") && !menuSelect.equals("D"));
        sc.close();
    }
    
    //To execute specific addItem method
    public void executeSpecificAddItem() {
       bill += (hashtable.get(itemCode) * quantity);
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
}
