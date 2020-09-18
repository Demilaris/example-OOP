public class BusinessAccount extends Account {
    public BusinessAccount(Client owner) {
        super(owner);
    }

    // Business account only override transfer method for loyalty clients
    @Override
    public void transfer(int deposit_amount, int withdraw_amount, Account account) {

        if (this.owner.getLoyalty_type() == Loyalty.GOLDEN_CARD)
            withdraw_amount *= 1.01;
        else if (this.owner.getLoyalty_type() == Loyalty.REGULAR)
            withdraw_amount *= 1.02;


        super.transfer(deposit_amount, withdraw_amount, account);
    }
}
