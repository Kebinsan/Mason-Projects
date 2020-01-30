/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   checkingAccount.java
   
   The purpose of this class is to define the data for a checkingAccount object.
   This is a subclass that extends the abstract Account.java superclass.  
*/
public class checkingAccount extends Account {

   /*
      Create an checkingAccount object through a constructor with 4 parameters. 
      The constructor calls the Account superclass and sends the arguments. 
      @param routingNumber The bank routing number.
      @param accountNumber The bank account number. 
      @param accountName The name of the bank account. 
      @param balance The balance of the bank account. 
   */   
   public checkingAccount(String routingNumber, String accountNumber, String bankName, double balance) {
      super(routingNumber, accountNumber, bankName, balance);
   }
   
   /* 
      Return a string representation of the checkingAccount object.
      @return String String Representation of the checkingAccount object. 
   */   
   public String toString() {
      return "CHECKING ACCOUNT\n" + super.toString();
   }
}