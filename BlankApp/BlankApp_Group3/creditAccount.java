/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   creditAccount.java
   
   The purpose of this class is to define the data for a creditAccount object.
   This is a subclass that extends the abstract Account.java superclass.  
*/

public class creditAccount extends Account {
   private double cashback;   //the cashback rate associated with the account
   
   /*
      Create a creditAccount object through a constructor with 4 parameters. 
      The constructor calls the Account superclass and sends the arguments. 
      @param routingNumber The bank routing number.
      @param accountNumber The bank account number. 
      @param accountName The name of the bank account. 
      @param balance The balance of the bank account. 
   */    
   public creditAccount(String routingNumber, String accountNumber, String bankName, double balance) {
      super(routingNumber, accountNumber, bankName, balance);
   }
   
   /*
      Create an Account object through a constructor with 5 parameters. 
      The constructor is chained to the above constructor and sends the arguments. 
      @param routingNumber The bank routing number.
      @param accountNumber The bank account number. 
      @param accountName The name of the bank account. 
      @param balance The balance of the bank account. 
      @param cashback The cashback rate associated with the credit account. 
   */    
   public creditAccount(String routingNumber, String accountNumber, String bankName, double balance, double cashback) {
      this(routingNumber, accountNumber, bankName, balance);
      this.cashback = cashback;
   }
   
   /*
      Get the cashback rate.
      @return cashback The cashback rate of the credit account.    
   */   
   public double getCashback() { 
      return this.cashback; 
   }
   
   /*
      Set the cashback rate.
      @return cashback The cashback rate of the credit account.    
   */   
   public void setCashback(double cashback) {
      this.cashback = cashback;
   }
   
   /* 
      Return a string representation of the creditAccount object.
      @return String String Representation of the creditAccount object. 
   */    
   public String toString() {
      return "CREDIT ACCOUNT\n" + super.toString() + "          Cashback: " + String.format("$%.2f", this.cashback);
   }
   
}