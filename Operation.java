public class Operation {

    private char type;
    private boolean status;
    private Account account;
    private int operation_money;
    private int total_money;
   // This class only used for logging and print some data about operations

    public Operation(char type, boolean status, Account account, int operation_money, int total_money) {
        this.type = type;
        this.status = status;
        this.account = account;
        this.operation_money = operation_money;
        this.total_money = total_money;
    }
//print the log
    public void Print() {
        System.out.println("Operation char:" + type + " Status: "+status+ " Total money: " + total_money);
    }

}
