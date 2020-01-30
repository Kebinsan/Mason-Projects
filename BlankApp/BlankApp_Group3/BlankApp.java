/**
Names: Adelyn Gaegler (G00673498),  Kevin Taylor (G01101039), Rusul Kamal (G01126096)
   IT 306-001 
   Collaborating with Team 2
   The applaction/blankApp is a one-stop solution would connect the user’s bank accounts into one application. 
   blankApp will allow people to keep track of their transactions in one place instead of checking each bank account separately. 
   
   User can
      •	Register and login 
      •	Add (up to 10 account)
      •  Remove bank account
      •	Link transactions - withdrawal, deposit
      •	Search by date and category 
      •	Print monthly report
*/

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.LinkedList;
public class BlankApp  {
   public static void main(String[] args) {
    //the max number of users for the application  
      int MAX_USER=10;
      //Array to hold the Users
      User []  users = new User [MAX_USER];
      //Track index/ the number of users
      int numUsers=0;
      //menu option when opening the app
      mainMenu(users, numUsers);
   }
   
   public static void mainMenu(User [] users, int numUsers) {
      boolean running = true;
      while(running){
         int menuChoice = getMenuOption();
         switch(menuChoice) {
            case 1:  
               //Add new user
               users[numUsers] = addUser(); 
               //increase the number of user
               numUsers++;
               break;   
            case 2:
               //login for the user
               login(users,numUsers);
               break;
            case 3:
               //exit the program
               running = false;  
                //fix
               exitMsg();              
               break;                    
            default:
            // Program should never reach this condition if logic is correct
              //throw new RuntimeException("Unknown error in menu choice");
         }
      }
   }
   
   public static User addUser () {
      boolean userAdded = false; 
      String password = "";
      String validatePW = "";
      User aUser = new User();
     
      do {
         try {
            //prompt user for information
            String firstName=JOptionPane.showInputDialog("Enter your first name: ");
            String lastName =JOptionPane.showInputDialog("Enter your last name: ");
            String email=JOptionPane.showInputDialog("Enter your email address: "); 
            //Validate length of username upon entry
            String username= JOptionPane.showInputDialog("Enter your username (must be at least 6 characters, and no more than 15): ");
            //Enter pw twice to confirm -- if they don't match, password will not be set
            boolean validPW = false; 
            do {  
               //confirm that password match
               password=JOptionPane.showInputDialog("Enter your password (must be 8-20 characters and include at least 1 of each of the following: uppercase letter, lowercase letter, symbol, and number): ");
               validatePW = JOptionPane.showInputDialog("Re-enter password to confirm: ");
               if(password.equals(validatePW)) {
                  validPW = true;
               }
               else {
                  //error msg if password does not mathch
                  JOptionPane.showMessageDialog(null, "Passwords entered do not match. Please try again.");
               }
            }while (!validPW);
            //set the value of the user;
            aUser.setFirstName(firstName);
            aUser.setLastName(lastName);
            aUser.setEmail(email);
            aUser.setUsername(username);
            aUser.setPassword(password);
            userAdded = true;
         } //end try
         catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(!userAdded);
      return aUser; 
   }//end addUser() 
   
      /*
      this method allows the user to login to their account if they have the correct username and passoword
      */
   public static void login (User [] users, int numUsers) {
      String username= "";
      String password="";
      int index=0;
      boolean logged_in=false;
      //if username and pw correctly match username and pw in users[], logged_in = true;
      username = JOptionPane.showInputDialog("Enter your username");
      password = JOptionPane.showInputDialog("Enter your password");
      try {
         //search for the username and password to find a match
         if(users[index].getUsername().equals(username)){
            if(users[index].getPassword().equals(password)){
               logged_in=true;
            }
         }
         else{
            index++;
         }
      }
      catch (NullPointerException e) {
         JOptionPane.showMessageDialog(null, "Error"); 
      }
      //error msg if there are not matches
      if (logged_in==false) {
         JOptionPane.showMessageDialog(null, "Error! Username or Password is incorrect");
      }
      else{
         JOptionPane.showMessageDialog(null, "Login Successful!");
         //index of user
         getLoginMenu(users[index]);
      }
   }
   
   //when logged in
   public static void getLoginMenu(User user){
      int option;
      boolean running = true;
      while(running){
         option = getOption();
         switch (option) {
            case 1:
               printMonthlySummary(user);
               //"Monthly Summary
                  //> print user information
               break;
            case 2:
               if(user.getNumAccounts()>0)
               {
                  //JOptionPane.showMessageDialog(null, (user.getAccount(0).getTransaction(0).getDate()));
                  searchTransactions(user);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "no accounts");
               
               }
               //Search Transactions
                  //ask which item to search for
                     //caterogries
                     //date
               break;
            case 3:
               editAccount(user);
               //edit Account
                  //ask which
                     //add account
                     //remove account
               break;
            case 4:
               profileSetting(user);
                  //change username, email and password
               break;
            case 5:
                 //Logout
               running = false;                
               break;                    
            default:
            // Program should never reach this condition if logic is correct
               throw new RuntimeException("Unknown error in menu choice");
         }
      }
   }
   /*
     input user: the logged in user
     print the information of user for the current month
   */
   public static void printMonthlySummary(User user){
      String print= " *** Monthly Summary *** \n";         
      String output = user.toString();
      //print a report of all the accounts and transactions
      for(int i = 0; i < user.getNumAccounts(); i++) {
         output += "\n\n" + user.getAccount(i).toString();
         for(int j = 0; j < user.getAccount(i).getNumTransactions(); j++) {
            output += user.getAccount(i).getTransaction(j).toString();
         }
      }
      JOptionPane.showMessageDialog(null, output);
   }
   
   /*
     input user: the logged in user
     search all the transactions for a specific date or category
     print the list transactions if there is a match or print an error msg
   */
   public static void searchTransactions(User user){
      String date="";
      String category="";
      String print="";
      
      boolean running = true;
      while(running){
         //ask user which item they want to search for
         int menuChoice=Integer.parseInt(JOptionPane.showInputDialog(" Which of the following do you want to search" 
            +"\n(1) By Date "
            +"\n(2) By Cateogry "
            +"\n(3) Exit"));    
         switch(menuChoice) {
            case 1:
               boolean found=false;
            //fix
            //loop through user accounts and transactions to find a match
               date=JOptionPane.showInputDialog("Enter the date you want to search");
               for(int i = 0; i < user.getNumAccounts(); i++) {
                  for(int j = 0; j < user.getAccount(i).getNumTransactions(); j++) {
                     
                     if(date.equals(user.getAccount(i).getTransaction(j).getDate())){
                        found=true;
                     
                        print+=user.getAccount(i).getTransaction(j).toString() + "\n";
                     }
                  }
               }
               if(found==true){
                  JOptionPane.showMessageDialog(null, print);
               }
               else{
                  JOptionPane.showMessageDialog(null, "Not Found");
               }
               break;   
            case 2:
               category=JOptionPane.showInputDialog("Enter the category you want to search");
               boolean found1=false;
             //loop through user accounts and transactions to find a match
               for(int i = 0; i < user.getNumAccounts(); i++) {
                  for(int j = 0; j < user.getAccount(i).getNumTransactions(); j++) {
                     
                     if(category.equals(user.getAccount(i).getTransaction(j).getCategory())){
                        found=true;
                     
                        print+=user.getAccount(i).getTransaction(j).toString() + "\n";
                     }
                  }
               }
               if(found1==true){
                  JOptionPane.showMessageDialog(null, print);
               }
               else{
                  JOptionPane.showMessageDialog(null, "Not Found");
               }
               break;
            case 3:
            //exit the menu
               running = false;
               break;                    
            default:
            // Program should never reach this condition if logic is correct
               throw new RuntimeException("Unknown error in menu choice");
         }
      }
   }
   /*
      menu options for adding and removing account 
   
   */
   public static void editAccount(User user){
      boolean running = true;
      while(running){
         int menuChoice=Integer.parseInt(JOptionPane.showInputDialog("Select an option  \n(1) Add account \n(2) Remove account \n(3) Back"));
         switch(menuChoice) {
            case 1:
               //method for adding account
               addAccount(user);
               printAccountSummary(user);
               break;   
            case 2:
               //method for removing account
               removeAccount(user);
               printAccountSummary(user);
               break;
            case 3:
               running = false;
               break;                    
            default:
            // Program should never reach this condition if logic is correct
               break;
         }
      }
   }
   /*
   method to read information from text file and set the variables
   */
   public static void addAccount(User user) {    
      if(user.getNumAccounts() < User.MAX_NUM_ACCOUNTS) {
         int repeat = -1;  
         //Adds accounts to 
         do {
            //variables for account object creation
            String accountName = "";
            String routingNumber = "";
            String accountNumber = "";
            double balance = 0;
            boolean verifyAccount = false;
            boolean bankFound = false;
            boolean accountSet = false;
            boolean stop = false;
         
            do {
               repeat = -1;
               try {
                  //Gets users bank name input
                  do {
                     accountName = JOptionPane.showInputDialog("Enter the name of the bank account: ");
                     if(accountName.equals("") || accountName == null) {
                        JOptionPane.showMessageDialog(null, "Bank Accounts name cannot be blank");
                     }
                  }
                  while(accountName.equals("") || accountName == null);
               
                  //gets users routing number input
                  do {
                     routingNumber = JOptionPane.showInputDialog("Enter the bank's routing number: ");
                     if(routingNumber.equals("") || routingNumber == null) {
                        JOptionPane.showMessageDialog(null, "Routing number cannot be blank");
                     }
                  }
                  while(routingNumber.equals("") || routingNumber == null);  
               
                  //Asks the user to input the account number and enter it again to verify it, both entries must match
                  do {
                     do {
                        accountNumber = JOptionPane.showInputDialog("Enter the account number: ");
                        if(accountNumber.equals("") || accountNumber == null) {
                           JOptionPane.showMessageDialog(null, "Account number cannot be blank");
                        }
                     }
                     while(accountNumber.equals("") || accountNumber == null);
                     
                     if(accountNumber.equals(JOptionPane.showInputDialog("Re-enter the account number: "))) {
                        verifyAccount = true;
                     }
                     else {
                        JOptionPane.showMessageDialog(null, "The accounting numbers must match");
                     }
                  }
                  while(!verifyAccount); 
                 
                  try {
                     //Opens file
                     Scanner in = getFile();        
                     //Creates the appropriate bank account object and adds additional information read from the file banks.txt
                     while(in.hasNextLine() && !bankFound) {
                        try {
                           if((routingNumber+accountNumber).equals(in.next())) {
                              bankFound = true;
                              
                              switch(in.next()) {
                                 case "checking":
                                    user.setAccount(new checkingAccount(routingNumber, accountNumber, accountName, in.nextDouble()));
                                    break;
                                 case "credit":
                                    user.setAccount(new creditAccount(routingNumber, accountNumber, accountName, in.nextDouble(), in.nextDouble()));
                                    break;
                                 case "savings":
                                    user.setAccount(new savingsAccount(routingNumber, accountNumber, accountName, in.nextDouble(), in.nextDouble()));
                                    break;
                                 default:
                                    JOptionPane.showMessageDialog(null, "An error has ocurred creating a bank account");
                                    break;
                              }
                           }
                        }
                        catch(RuntimeException e) {
                           repeat = JOptionPane.showConfirmDialog(null, "The account could not be found, Would you like to try again?", "Try Again", JOptionPane.YES_NO_OPTION);
                        }
                     }
                  
                     //Adds transactions to the account
                     while(in.hasNextLine() && !stop) {
                        if(!in.hasNextDouble()) {
                           stop = true;
                        }
                        else {
                           user.getAccount(user.getNumAccounts() - 1).setTransaction(new Transaction(in.nextDouble(), in.next(), in.next(), in.nextBoolean(), in.next()));
                        }
                     } 
                                
                     //close file
                     in.close();
                  }
                  catch(FileNotFoundException e) {
                     JOptionPane.showMessageDialog(null, "Error: The bank file was not found");
                  }
               }
               catch(IllegalArgumentException e) {
                  JOptionPane.showMessageDialog(null, e.getMessage());
               }  
               
               //If the bank was not found, a message is prompted asking the user if they want to try again or exit
               if(bankFound) {
                  JOptionPane.showMessageDialog(null, "The " + user.getAccount(user.getNumAccounts() - 1).getAccountName() + " account was successfully created!");
               }
            }
            while(repeat == 0);  
            //end creation of account
            
            repeat = -1;
            if(user.getNumAccounts() < User.MAX_NUM_ACCOUNTS) {
               repeat = JOptionPane.showConfirmDialog(null, "Would you like to add another bank account?", "Bank Account Creation", JOptionPane.YES_NO_OPTION);
            }
            else {
               JOptionPane.showMessageDialog(null, "The maximum number of bank accounts has been created");
            }
         }
         while(repeat == JOptionPane.YES_OPTION && user.getNumAccounts() < User.MAX_NUM_ACCOUNTS);
      }
      else {
         JOptionPane.showMessageDialog(null, "The maximum number of bank accounts has been created");
      }
   }
   
   /*
   method to read information from text file and set the variables
   */
   public static void removeAccount(User user){
   
      String accountNumber;
      boolean found = false;
      boolean verifyAccount = false;
      int repeat = -1;
      do {
         do {
         //prompt the user on what account they want to remove
            accountNumber = JOptionPane.showInputDialog("Enter the account number of the bank you wish to remove: ");
            if(accountNumber.equals(JOptionPane.showInputDialog("Re-enter the account number: "))) {
               verifyAccount = true;
            }
            else {
               JOptionPane.showMessageDialog(null, "The accounting numbers must match");
            }
         }
         while(!verifyAccount);
         if(JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this account?", "Delete Account?", JOptionPane.YES_NO_OPTION) == 0) {
            for(int i = 0; i < user.getNumAccounts(); i++) {
               if(accountNumber.equalsIgnoreCase(user.getAccount(i).getAccountNumber())) {
                  JOptionPane.showMessageDialog(null, "The following account was successfully removed\n\n" + user.getAccount(i).toString());
                  user.removeAccount(i);
                  found = true;
               }
            }
         }
         else {
            JOptionPane.showMessageDialog(null, "Account removal was cancelled");
         }
         if(!found) {
            repeat = JOptionPane.showConfirmDialog(null, "The account could not be found, would you like to try again?", "Try Again?", JOptionPane.YES_NO_OPTION);
         }
      }
      while(!found && repeat == 0);
   }
   /*
   
   */
   public static void profileSetting(User user){
      String username="";
      String password="";
      String email="";
      boolean running = true;
      while(running){
         int menuChoice = profileOptions();
         switch(menuChoice) {
            case 1:
               username=JOptionPane.showInputDialog("Enter the new username");
               if(Validation.validateUsername(username)){
                  user.setUsername(username);
                  JOptionPane.showMessageDialog(null, "Username has been changed");
               }
               else{
               //set if valid
                  JOptionPane.showMessageDialog(null, "Error! Username requirment not met. Try Again");
               }
               break;   
            case 2:
               password=JOptionPane.showInputDialog("Enter the new password");
               if(Validation.validatePassword(password)){
                 //set if valid
                  user.setPassword(password);
                  JOptionPane.showMessageDialog(null, "Password has been changed");
               }
               else{
                  JOptionPane.showMessageDialog(null, "Error! Password requirment not met. Try Again");
               }
               break;
            case 3:
               email=JOptionPane.showInputDialog("Enter the new email");
               if(Validation.validateEmail(email)){
                 //set if valid
                  user.setEmail(email);
                  JOptionPane.showMessageDialog(null, "Email has been changed");
               }
               else{
                  JOptionPane.showMessageDialog(null, "Error! email requirment not met. Try Again");
               }
               break;
            case 4:
               running = false;
               //getLoginMenu(index, users,  numUser);               
               break;                    
            default:
            // Program should never reach this condition if logic is correct
               throw new RuntimeException("Unknown error in menu choice");
         }
      } 
   }
   
   public static int profileOptions(){
      int answer=0;
      do {
         try{
            answer=Integer.parseInt(JOptionPane.showInputDialog(" Which of the following do you want to change" 
               + "\n(1) Username"
               + "\n(2) Password"
               + "\n(3) Email"
               + "\n(4) Exit"));
         }
         catch (NumberFormatException e) {
            answer = 0;
         }
         //options are only from 1-5 
         if (answer < 1 || answer >45) 
         {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (answer < 1 || answer > 4);
      return answer;
   }
   /*
      method that provides the menu option for user
   */
   public static int getOption(){
      int menuChoice;
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter:"
               + "\n(1) Monthly Summary "
               + "\n(2) Search Transactions "
               + "\n(3) Edit Account"
               + "\n(4) Profile Setting"
               + "\n(5) Logout"
               ));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
         //options are only from 1-5 
         if (menuChoice < 1 || menuChoice > 5) 
         {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuChoice < 1 || menuChoice > 5);
      return menuChoice;
   }
    /*
      method that provides the menu option for user
   */
   public static int getMenuOption() {
      int menuChoice;
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter:"
               + "\n(1) Register "
               + "\n(2) Login "
               + "\n(3) Exit"
               ));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
         //options are only from 1-5 
         if (menuChoice < 1 || menuChoice > 3) 
         {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuChoice < 1 || menuChoice > 3);
      return menuChoice;
   }
   //file information
   public static Scanner getFile() throws FileNotFoundException {
      Scanner in = null;
      in = new Scanner(new FileInputStream(("banks.txt")));
      return in;
   }
   /*
   print the details for each account
   */
   public static void printAccountSummary(User user) {
      String output = user.toString();
      //loop through each account
      for(int i = 0; i < user.getNumAccounts(); i++) {
         output += "\n" + user.getAccount(i).toString();
         output += "\nTRANSACTIONS:\n";
         //loop through each transaction
         for(int j = 0; j < user.getAccount(i).getNumTransactions(); j++) {
            output += user.getAccount(i).getTransaction(j).toString();
         }
      }
      JOptionPane.showMessageDialog(null, output);
   }
   //msg for exiting the program 
   public static void exitMsg(){
      JOptionPane.showMessageDialog(null, "Thank You for using BlankApp");
   }
   
}