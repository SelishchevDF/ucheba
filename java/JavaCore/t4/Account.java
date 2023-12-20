

public class Account {
    
    private int account;


    //constructor
    public Account(int account) throws IllegalArgumentException{
        if (account < 0) throw new IllegalArgumentException("account cannot be less than 0");
        this.account = account;
    }


    //getter
    public int getAccount() {
        return account;
    }



    //methods
    public void makeDeposit(int deposit) throws IllegalArgumentException{
        if (deposit < 0) throw new IllegalArgumentException("deposit cannot be less than 0");
        this.account += deposit;
    }

    public void cashWithdrawal(int cash) throws InsufficientFundsException{
        if ((account - cash) < 0) throw new InsufficientFundsException("cannot withdraw more than the account balance");

    }

    

}
