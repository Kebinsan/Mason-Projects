  /*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   Transaction.java
   
   The purpose of this class is to hold the information for each Transaction object.
*/
public class Transaction {
//list of the cateogries transaction can be
   public static final String[] CATEGORIES = {"gas", "food", "retail", "miscellaneous"};
  //list of the type transaction can be
   public static final String[] TYPES = {"withdrawal", "deposit"};
   //amount for each transaction
   private double amount;
         //date for each transaction
   private String date;
     //category for each transaction
   private String category;
   //true for complete transactions, false for pending
   private boolean completionStatus;
   //type of  transaction
   private String type;
   //constructor for transaction object
   public Transaction(double amount, String date, String category, boolean completionStatus, String type) {
      boolean found = false;
      if(date == null || date.equals("")) {
         throw new IllegalArgumentException("Error: Transactions date cannot be blank");
      }
      if(category == null || category.equals("")) {
         throw new IllegalArgumentException("Error: Transaction category cannot be blank");
      }
      else {
         for(int i = 0; i < CATEGORIES.length; i++) {
            if(category.equalsIgnoreCase(CATEGORIES[i])) {
               found = true;
            }
         }
         if(!found) {
            throw new IllegalArgumentException("Error: Transaction category was not valid");
         }
      }
      found = false;
      if(type == null || type.equals("")) {
         throw new IllegalArgumentException("Error: Transaction type cannot be blank");
      }
      else {
         for(int i = 0; i < TYPES.length; i++) {
            if(type.equalsIgnoreCase(TYPES[i])) {
               found = true;
            }
         }
         if(!found) {
            throw new IllegalArgumentException("Error: Transaction type was not valid");
         }
      }
      this.amount = amount;
      this.date = date;
      this.category = category;
      this.completionStatus = completionStatus;
      this.type = type;
   }
   //return the amount
   public double getAmount() { 
      return this.amount; }
      //return the date
   public String getDate() { 
      return this.date; }
      //return the category
   public String getCategory() { 
      return this.category; }
      //return the status
   public boolean getCompletionStatus() { 
      return this.completionStatus; }
      //return the type
   public String getType() { 
      return this.type; }
   //set amount
   public void setAmount(double amount) {
      this.amount = amount;
   }
   //set date
   public void setDate(String date) {
      if(date == null || date.equals("")) {
         throw new IllegalArgumentException("Error: Transactions date cannot be blank");
      }
      this.date = date;
   }
   //set category if its one of the list
   public void setCategory(String category) {
      boolean found = false;
      if(category == null || category.equals("")) {
         throw new IllegalArgumentException("Error: Transaction category cannot be blank");
      }
      else {
         for(int i = 0; i < CATEGORIES.length; i++) {
            if(category.equals(CATEGORIES[i])) {
               found = true;
            }
         }
         if(!found) {
            throw new IllegalArgumentException("Error: Transaction category was not valid");
         }
      }
   
      this.category = category;
   }
   //set the status
   public void setCompletionStatus(boolean completionStatus) {
      this.completionStatus = completionStatus;
   }
  //set type if its one of the list
   public void setType(String type) {
      boolean found = false;
      if(type == null || type.equals("")) {
         throw new IllegalArgumentException("Error: Transaction type cannot be blank");
      }
      else {
         for(int i = 0; i < TYPES.length; i++) {
            if(type.equals(TYPES[i])) {
               found = true;
            }
         }
         if(!found) {
            throw new IllegalArgumentException("Error: Transaction type was not valid");
         }
      }
      this.type = type;
   }
   
  //string representation for Transaction
   public String toString() {
      String statusOutput = "";
      if(this.completionStatus) {
         statusOutput = "Completed";
      }
      else {
         statusOutput = "Pending";
      }
      return "Amount: " + String.format("$%.2f", this.amount) + "          Date: " + this.date + "          Category: " + this.category + 
         "          Status: " + statusOutput + "          Type: " + this.type + "\n";
   } 
}