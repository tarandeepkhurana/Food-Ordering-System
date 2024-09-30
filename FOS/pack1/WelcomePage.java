package FOS.pack1;

import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class WelcomePage extends readercode {
	private String input;

   WelcomePage(String userID){
	  System.out.print("Welcome " + userID + "! Craving something delicious? We've got you covered with fresh, mouth-watering meals delivered right to your door.\nGet upto 10% discount on orders above Rs 199 or 20% discount on orders above Rs 299.\nStart your order and enjoy a delightful dining experience from the comfort of your home!\n\n");
      readercode.login=true;
      }
}