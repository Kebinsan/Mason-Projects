/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   savingsAccount.java
   
   The purpose of this class is to define the data for a savingsAccount object.
   This is a subclass that extends the abstract Account.java superclass.  
*/

public class savingsAccount extends Account {
   private double interestRate;
   
   /*
      Create a savingsAccount object through a constructor with 5 parameters. 
      The constructor calls the Account superclass and sends the arguments. 
      @param routingNumber The bank routing number.
      @param accountNumber The bank account number. 
      @param accountName The name of the bank account. 
      @param balance The balance of the bank account. 
      @param interestRate The interest rate of the savings Account. 
   */   
   public savingsAccount(String routingNumber, String accountNumber, String bankName, double balance, double interestRate) {
      super(routingNumber, accountNumber, bankName, balance);
      if(interestRate < 0) {
         throw new IllegalArgumentException("Error: Interest Rate must be greater than or equal to 0.");
      }
      this. interestRate = interestRate;
   }
   
   /*
      Get the interest rate. 
      @return interestRate The interest rate of the savings account. 
   */
   public double getInterestRate() {
      return this.interestRate;
   }
   
   /*
      Set the interest rate. 
      @param interest The new interest rate of the savings account. 
   */
   public void setInterestRate(double interest) {
      if(interestRate < 0) {
         throw new IllegalArgumentException("Error: Interest Rate must be greater than or equal to 0.");
      }
      this.interestRate = interest;
   }
   
   /* 
      Return a string representation of the savingsAccount object.
      @return String String Representation of the savingsAccount object. 
   */    
   public String toString() {
      return "SAVINGS ACCOUNT\n" + super.toString() + "          Interest Rate: " + String.format("%.2f", interestRate);
   }
  
}