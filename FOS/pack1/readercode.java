package FOS.pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readercode{
    public static boolean login;

    public static void main(String args[]) {      
        IdandPasswords idandPasswords = new IdandPasswords();
				
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
        String filePath = "D:\\priyank\\SGSITS\\OOPS\\PROJECT\\list.txt";

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