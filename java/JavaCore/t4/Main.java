public class Main {

    public static void main(String[] args) {
        
        try {
            Account account = new Account(-100);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {

            Account account2 = new Account(1000);
            try {
                account2.makeDeposit(-100);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally {

                try {
                    account2.cashWithdrawal(1500);
                }
                catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                finally{

                    DebitAccount debitAccount = new DebitAccount(1000);
                    CreditAccount creditAccount = new CreditAccount(2000);
                    try {
                        Transaction.transaction(debitAccount, creditAccount, 100);
                    }
                    catch (TransactionException e) {
                        System.out.println(e.getMessage());
                    } 
                    finally{
                        
                        try {
                            Transaction.transaction(debitAccount, creditAccount, -100);
                        }
                        catch (TransactionException e) {
                            System.out.println(e.getMessage());
                        }
                        finally{
                            try {
                                Transaction.transaction(debitAccount, creditAccount, 5000);
                            }
                            catch (TransactionException e) {
                                System.out.println(e.getMessage());
                            }
                            finally{
                                System.out.println("END!!!");
                            }
                        }

                    }
                }
            }
        } 
    }
}