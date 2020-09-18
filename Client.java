import java.util.ArrayList;
import java.util.Date;


//this is the value type defined by a set of named constants dor loyalty clients
enum Loyalty {
    VIP,
    GOLDEN_CARD,
    REGULAR
}

public class Client {

    private String name;
    private Date birthday;
    private char gender;
    private Loyalty loyalty_type;
    private int amount_money_from_all_accounts;
    private int amount_of_accounts;


    private ArrayList<Account> accounts = new ArrayList<Account>();//
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public Date getBirthday() {
        return birthday;
    }

    public char getGender() {
        return gender;
    }

    public Loyalty getLoyalty_type() {
        return loyalty_type;
    } //prop

    public String getName() {
        return name;
    }

    public Client(String name, Date birthday, char gender, Loyalty loyalty_type) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.loyalty_type = loyalty_type;
    }

    public void add_account(Account account)//create new account for client
    {
        accounts.add(account);
    }

    public int amount_of_accounts() {
        return accounts.size();
    }
    public Account get_account_ID(int index)
    {
        return accounts.get(index);
    }

    //calculate money from all clients accounts
    public int amount_of_money_of_accounts() {
        int sum_of_money = 0;
        for (int i = 0; i < accounts.size(); ++i)

            sum_of_money += accounts.get(i).money;


        return sum_of_money;
    }


}

