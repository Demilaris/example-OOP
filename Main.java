import javax.naming.Name;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("My Bank");
        bank.list_of_clients();
        bank.list_of_accounts();
        bank.list_of_transaction();
    }


}
