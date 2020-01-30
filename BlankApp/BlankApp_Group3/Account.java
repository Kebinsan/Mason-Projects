/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler   
   
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   Account.java
   
   The purpose of this abstract class is to define the data that represents an Account object. 
   This is a superclass that contains variables such as routingNumber, accountNumber, 
      accountName, balance, transactions, and numTransactions. 
   This class will be extended by checkingAccount, savingsAccount, and creditAccount. 
   It will be implemented by BlankApp.java. 
   The transactions will be stored in a linkedList of transaction objects. 

*/
import java.util.LinkedList;

public abstract class Account {
   private String routingNumber; 
   private String accountNumber; 
   private String accountName;   
   private double balance;     
   private LinkedList transactions;    
   private int numTransactions;    
   
   
   /*
      Create an Account object through a constructor with 4 parameters, validating each variable.
      @param routingNumber The bank routing number.
      @param accountNumber The bank account number. 
      @param accountName The name of the bank account. 
      @param balance The balance of the bank account. 
   */
   public Account(String routingNumber, String accountNumber, String accountName, double balance) {
      if(routingNumber == null || routingNumber.equals("")) {
         throw new IllegalArgumentException("Error: Routing number cannot be blank");
      }
      if(accountNumber == null || accountNumber.equals("")) {
         throw new IllegalArgumentException("Error: Account number cannot be blank");
      }
      if(accountName == null || accountName.equals("")) {
         throw new IllegalArgumentException("Error: Bank name cannot be blank");
      }
      this.routingNumber = routingNumber;
      this.accountNumber = accountNumber;
      this.accountName = accountName;
      this.balance = balance;
      this.transactions = new LinkedList();
   }
   
   /*
      Get the routing number.
      @return routingNumber The bank routing number.    
   */
   public String getRoutingNumber() { 
      return this.routingNumber; }
      
   /*
      Get the account number.
      @return accountNumber The bank account number.    
   */     
   public String getAccountNumber() { 
      return this.accountNumber; }
      
   /*
      Get the account name.
      @return accountName The user-specified bank account name.    
   */      
   public String getAccountName() { 
      return this.accountName; } 
      
   /*
      Get the balance.
      @return balance The bank account balance.    
   */      
   public double getBalance() { 
      return this.balance; }
      
   /*
      Get the number of transactions.
      @return numTransactions The number of transactions associated with the bank account.    
   */      
   public int getNumTransactions() {
      return this.numTransactions; }

   /*
      Get the list of transactions.
      @return transactions The list of transactions associated with the bank account.    
   */      
   public LinkedList getTransactions() { 
      return this.transactions; }
      
      //fix
   /*
      Get a transaction from the list.
      @param index The index of the requested transaction in the linkedList. 
      @return transactions The transaction located at the specified index.    
   */      
   public Transaction getTransaction(int index) {
      return (Transaction)this.transactions.get(index);
   }
   
   /*
      Set the routing number after validating that it is not null. 
      If it is null, throw an IllegalArgumentException and return to the calling method. 
      @param routingNumber The new routing number to be set.    
   */   
   public void setRoutingNumber(String routingNumber) {
      if(routingNumber == null || routingNumber.equals("")) {
         throw new IllegalArgumentException("Error: Routing number cannot be blank");
      }
      this.routingNumber = routingNumber;
   }
   
   /*
      Set the account number after validating that it is not null. 
      If it is null, throw an IllegalArgumentException and return to the calling method. 
      @param accountNumber The new account number to be set.    
   */   
   public void setAccountNumber(String accountNumber) {
      if(accountNumber == null || accountNumber.equals("")) {
         throw new IllegalArgumentException("Error: Account number cannot be blank");
      }
      this.accountNumber = accountNumber;
   }
   
   /*
      Set the account name after validating that it is not null. 
      If it is null, throw an IllegalArgumentException and return to the calling method. 
      @param accountName The new account name to be set.    
   */   
   public void setAccountName(String accountName) {
      if(accountName == null || accountName.equals("")) {
         throw new IllegalArgumentException("Error: Bank name cannot be blank");
      }
      this.accountName = accountName;
   }
   
   /*
      Set the transaction after validating that it is not null. 
      If it is null, throw an IllegalArgumentException and return to the calling method. 
      @param transaction The new transaction to be set.    
   */   
   public void setTransaction(Transaction transaction) {
      if(transaction == null) {
         throw new IllegalArgumentException("Error: Transaction cannot be null");
      }
      transactions.add(transaction);
      this.numTransactions++;
   }
   
   /* 
      Return a string representation of the Account object.
      @return String String Representation of the Account object. 
   */   
   public String toString() {
      return "Account Name: " + this.accountName + "              Account Number: " + this.accountNumber +
         "           Routing Number: " + this.routingNumber + "             Balance: $" + String.format("%.2f", this.balance)
         ;
   }
   
   /*
      Determine whether or not two Account objects are equal.
         @param otherAccount The other Account object being compared.
         @return boolean Whether or not the two Accounts are considered equal.
   */
   public boolean equals(Account otherAccount) {
      return (this.routingNumber == otherAccount.routingNumber && this.accountNumber == otherAccount.accountNumber);
   }
}
