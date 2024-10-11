package FOS.pack1;

public class Main {
    public static void main(String[] args) {
        IdandPasswords idandPasswords = new IdandPasswords();
        LoginPage login = new LoginPage(idandPasswords.getLoginInfo());
        ConcreteClass user = new ConcreteClass();
        user.processUserSelection(login.userID);
    }
}
