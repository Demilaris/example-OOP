import java.util.Date;
import java.util.ArrayList;

//This class store information about clients and their accounts
public class Bank {

    private String name;
    private int sum_of_money;

    private ArrayList<Client> clients;
    private ArrayList<Account> bank_accounts;



    public String getName() {
        return name;
    } //return bank name

    public Bank(String name) {
        this.name = name;
        this.clients = new ArrayList<Client>(); //list of bank's clients
        this.bank_accounts = new ArrayList<Account>(); //list of all accounts in bank
        this.sum_of_money = 0;
    }


    public int total_amount_money() //calculate total money from all client's accounts
    {
        for (int i = 0; i < clients.size(); ++i) {
            sum_of_money = clients.get(i).amount_of_money_of_accounts();
        }

        return sum_of_money;
    }

    public void add_new_client(Client client) //add new client
    {
        clients.add(client);
    }


        // init and print some clients with their accounts
    public void list_of_clients() {
        var client1 = new Client("Lera", new Date(1998, 06, 18), 'F', Loyalty.REGULAR);
        var client2 = new Client("Stasy", new Date(1996, 10, 16), 'F', Loyalty.GOLDEN_CARD);
        var client3 = new Client("Jhon", new Date(1997, 07, 19), 'F', Loyalty.VIP);

        //add new clients
        add_new_client(client1);
        add_new_client(client2);
        add_new_client(client3);

        //add accaunts for clients
        client1.add_account(new BusinessAccount(client1));
        client1.add_account(new SavingAccount(client1));
        client2.add_account(new CreditAccount(client2));
        client3.add_account(new DebitAccount(client3));
    //print all clients with their attributes
        for (int i = 0; i < clients.size(); ++i) {
            System.out.println("Name: " + clients.get(i).getName() + " Gender:" + clients.get(i).getGender() + " Date of birth: " + clients.get(i).getBirthday() + " Loyality type: " + clients.get(i).getLoyalty_type() + " Number of accounts: " + clients.get(i).amount_of_accounts());//hj
        }
    }

    //print all accounts with owner in bank
    public void list_of_accounts() {
        for (Client c:clients
             ) {
            System.out.println("Owner: "+ c.getName() +" Accounts: " +c.getAccounts());
        }
    }
    //print logs after operation
    public void list_of_transaction()
    {
        System.out.println("Deposit operation : ");
        var client1_account1  = clients.get(0).get_account_ID(0);
        var client1_account2 = clients.get(0).get_account_ID(1);
        client1_account1.deposit(120);

        System.out.println("Withdraw operation : ");
        client1_account1.withdraw(50000);
        var client2_account1 = clients.get(1).get_account_ID(0);
        client2_account1.withdraw(5000);


        System.out.println("Transfer operation : ");
        client1_account1.transfer(50,50,client1_account2);
    }
}


