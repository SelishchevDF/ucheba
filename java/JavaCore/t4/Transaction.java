import java.util.Random;

public class Transaction {
    
    public static void transaction (Account sorce, Account dest, int summ) throws TransactionException {
        
        try {
            if (new Random().nextInt(2) == 0) throw new TransactionException("it is RANDOM!");
            sorce.cashWithdrawal(summ);
            dest.makeDeposit(summ);
            System.out.println("Transaction completed");
        } catch (Exception e) {
            throw new TransactionException("Transaction not completed: " + e.getMessage());
        }
    }
}
