import java.util.ArrayList;

//This general class for different types of accounts
//Include all operation and work with child classes
public class Account {
    protected int money;
    protected Client owner;

    //List Operations performed on the account
    protected ArrayList<Operation> operation_logs = new ArrayList<Operation>();

    public Account(Client owner) {
        this.owner = owner;
    }


    @Override
    public String toString() //for normal print
    {
        return this.getClass().getSimpleName();
    }


    // Start withdraw operation
    // if the condition is met, the operation will be true. otherwise, the logger will print a false
    public void withdraw(int amount) {
        if (money < amount) { //credit account havnt  any limits on withdraw.
            Operation false_withdraw = new Operation('T', false, this, amount, money);
            operation_logs.add(false_withdraw);
            false_withdraw.Print();
            return;
        }
        money -= amount;
        Operation withdraw = new Operation('W', true, this, amount, money);
        withdraw.Print();
        operation_logs.add(withdraw);

    }

    public void deposit(int amount) {
        money += amount;
        Operation deposit = new Operation('D', true, this, amount, money);
        deposit.Print();
        operation_logs.add(deposit);

    }
//transfer operation. for this need two accounts
    public void transfer(int deposit_amount, int withdraw_amount, Account account) {

        if (withdraw_amount > money) {

            Operation false_transfer = new Operation('T', false, this, withdraw_amount, money); //write in log
            operation_logs.add(false_transfer);
            false_transfer.Print();
            return;
        }

        money -= withdraw_amount;
        account.deposit(deposit_amount);
        Operation transfer = new Operation('T', true, this, withdraw_amount, money);
        transfer.Print();
        operation_logs.add(transfer);
    }
}