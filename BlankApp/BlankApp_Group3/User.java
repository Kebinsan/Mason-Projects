/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   User.java
   
   The purpose of this class is to hold the information for each user.
*/
public class User {
   //Maximum number of accounts per user
   public static final int MAX_NUM_ACCOUNTS = 10;
   /*information for user*/
   private String firstName;
   private String lastName;
   private String username;
   private String password;
   private String email;
   private Account[] accounts;
   private int numAccounts;
   
  //constructor to make the user object
   public User() {
      this.accounts = new Account[MAX_NUM_ACCOUNTS];
   }
   //constructor to make the user object
   public User(String firstName, String lastName, String username, String password, String email) {
      this();
      if(firstName == null || firstName.equals("")) {
         throw new IllegalArgumentException("Error: First name cannot be blank");
      }
      if(lastName == null || lastName.equals("")) {
         throw new IllegalArgumentException("Error: Last name cannot be blank");
      }
      if(username == null || username.equals("") || !Validation.validateUsername(username)) {
         throw new IllegalArgumentException("Error: Username was invalid");
      }
      if(password == null || password.equals("") || !Validation.validatePassword(password)) {
         throw new IllegalArgumentException("Error: Password was invalid");
      }
      if(email == null || email.equals("")|| !Validation.validateEmail(email)) {
         throw new IllegalArgumentException("Error: Email was invalid");
      }
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = username;
      this.password = password;
      this.email = email;
   }
   //return the user first name
   public String getFirstName() { 
      return this.firstName; }
    //return the user last name
   public String getLastName() { 
      return this.lastName; }
     //return the user username
   public String getUsername() { 
      return this.username; }
     //return the user password name
   public String getPassword() { 
      return this.password; }
      //return the user email
   public String getEmail() { 
      return this.email; }
  
  //return account a scecfifc index
   public Account getAccount(int index) {
      if(index < 0 || index > this.getNumAccounts()) {
         throw new IllegalArgumentException("An account does not exist at that index");
      }
      return this.accounts[index];
   }

   public Account[] getAccounts() {
      return this.accounts; }
      //return the number of account 
   public int getNumAccounts() { 
      return this.numAccounts; }
 //set the user first name
   public void setFirstName(String firstName) {
      if(firstName == null || firstName.equals("")) {
         throw new IllegalArgumentException("Error: First name cannot be blank");
      }
      this.firstName = firstName;
   }
          //set the user last name
   public void setLastName(String lastName) {
      if(lastName == null || lastName.equals("")) {
         throw new IllegalArgumentException("Error: Last name cannot be blank");
      }
      this.lastName = lastName;
   }
   //set the user username 
   public void setUsername(String username) {
      if(username == null || username.equals("") || !Validation.validateUsername(username)) {
         throw new IllegalArgumentException("Error: Username was invalid");
      }
      this.username = username;
   }
   //set the user password
   public void setPassword(String password) {
      if(password == null || password.equals("") || !Validation.validatePassword(password)) {
         throw new IllegalArgumentException("Error: Password was invalid");
      }
      this.password = password;
   }
   //set the user email
   public void setEmail(String email) {
      if(email == null || email.equals("") || !Validation.validateEmail(email)) {
         throw new IllegalArgumentException("Error: Email was invalid");
         
      }
      this.email = email;
   
   }
//set the user account
   public void setAccount(Account account) {
      if (account == null) {
         throw new IllegalArgumentException("Error: Account cannot be empty");
      }
      if (this.numAccounts >= MAX_NUM_ACCOUNTS || this.numAccounts < 0) {
         throw new IllegalArgumentException("Error: The maximum number of accounts has been created for the user");
      }
      this.accounts[this.numAccounts++] = account;  
   }
   //set the user accounts
   public void setAccounts (Account[] accounts) {
      for(int x = 0; x < getNumAccounts(); x++)
      {
         if(accounts[x]== null){
            throw new IllegalArgumentException("Error: No accounts were found");      
         }
         this.accounts = accounts;  
      }
   }
   //remove the user account
   public void removeAccount(int index) {
      if(index >= 0 && index < this.numAccounts) {
         for(int i = index; i < this.numAccounts - 1; i++) {
            this.accounts[i] = this.accounts[i + 1];
         }
         this.numAccounts--;
      }    
   }
   //string representation for user
   public String toString() {
      String print ="Username: " + this.username + "\nName: " + this.firstName + " " + lastName + " Email: " + this.email +"\n";
      print+="Account Information \n";
      /*for(int x=0;x<=getNumAccounts();x++){
         print+= getAccount(x) + "\n";
      }*/
      return print;
   }
}