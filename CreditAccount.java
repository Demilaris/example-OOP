public class CreditAccount extends Account {
    public CreditAccount(Client owner) {
        super(owner);
    }
    // Credit account  override transfer and withdraw method for loyalty clients ( without any check)
    // Allows clients to go into negative balance
    @Override
    public void withdraw(int amount) {

        money -= amount;
        Operation withdraw = new Operation('W', true, this, amount, money);
        withdraw.Print();
        operation_logs.add(withdraw);

    }

    @Override
    public void transfer(int deposit_amount, int withdraw_amount, Account account) {

        money -= withdraw_amount;
        account.deposit(deposit_amount);
        Operation transfer = new Operation('T', true, this, withdraw_amount, money);
        transfer.Print();
        operation_logs.add(transfer);
    }


}
