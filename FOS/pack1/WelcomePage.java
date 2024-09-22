package FOS.pack1;

import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class WelcomePage extends readercode {
	private String input;

   WelcomePage(String userID){
	  System.out.print("Welcome " + userID + "! Craving something delicious? We've got you covered with fresh, mouth-watering meals delivered right to your door.\nGet upto 10% discount on orders above Rs 199 or 20% discount on orders above Rs 299.\nStart your order and enjoy a delightful dining experience from the comfort of your home!\n\nEnter your choice (Type 'A' for Appetizers, 'B' for Beverages, 'D' for Desserts) - ");
      readercode.login=true;
      
      //To get the input for printing a particular menu
      Scanner sc = new Scanner(System.in);
      String input1 = sc.next();
      do {
        switch (input1) {
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
	   } while (!input1.equals("A") && !input1.equals("B") && !input1.equals("D"));

      //To get the input for a particular method(addItem(), removeItem(), seeCart(), seeAnotherMenu(), getFinalBill())
      System.out.println("Enter your choice - ");
      String input2 = sc.next();
      do {
         switch (input2) {
            case "A":
               System.out.println("Enter the item code - ");
               String input3 = sc.next();
               // addItem(input3);
               break;
            case "R":
               System.out.println("Enter the item code - ");
               String input4 = sc.next();
               // removeItem(input4);
               break;
            case "S":
               // seeCart();
               break;
            case "E":
               // seeAnotherMenu();
               break;
            case "F":
               // getFinalBill();
               break;
            default:
               System.out.println("Incorrect Response!\nEnter your choice - ");
               break;
         }
      } while (input2 != "A" || input2 != "R" || input2 != "S" || input2 != "E" || input2 != "F");
   }
}