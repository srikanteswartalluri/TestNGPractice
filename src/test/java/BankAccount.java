public class BankAccount{
    private int accountNumber;
    private String name;
    private double balance;
    private boolean isActive;

    public BankAccount(int accountNumber,String name,double balance,boolean isActive){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.isActive = isActive;
    }

    public void withdraw(double amount) throws InsufficientBalanceException{
        if(balance>amount){
            balance = balance-amount;
        }else{
            throw new InsufficientBalanceException();
        }
    }

    public void deposit(double amount){
        balance = balance+amount;
    }

    public double getBalance(){
        return balance;
    }
}