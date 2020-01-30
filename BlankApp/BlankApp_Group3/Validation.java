  /*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   Validation.java
   
   The purpose of this class is to validate name, email and password for each user.
*/
public class Validation {

   public static boolean validateEmail(String email) {
      int addressSignCount = 0;
      //@return false if the first character of the email address is not a letter or a number
      if(!Character.isLetter(email.charAt(0)) && !Character.isDigit(email.charAt(0))) {
         return false;
      }
      for(int i = 0; i < email.length(); i++) {
         char x = email.charAt(i);
         //Counts the number of address signs
         if(x == '@') {
            addressSignCount++;
         }
         //@return false if a "symbol" character is not an '@', '.', or '_'
         if(!Character.isLetterOrDigit(x) && x != '@' && x != '.' && x != '_') {
            return false;
         }
      }
      //@return false if there are more than one address signs
      if(addressSignCount > 1) {
         return false;
      }
      int indexOfAddressSign = email.indexOf('@');
      //@return false if the address sign could not be found at any index
      if(indexOfAddressSign == -1) {
         return false;
      }
      else {
         //@return false if the address sign doesn't have enough characters after
         if(indexOfAddressSign == email.length() - 1) {
            return false;
         }
         else {
            String afterAddressSign = email.substring(indexOfAddressSign, email.length());
            //@return false if no period was found after the address sign
            if(afterAddressSign.indexOf('.') == -1) {
               return false;
            }
            String lastPeriod = afterAddressSign.substring((afterAddressSign.length() - 2), afterAddressSign.length());
            //@return false if there is not enough characters after the period
            if(lastPeriod.indexOf('.') != -1) {
               return false;
            }
         }
      }
      return true;
   }
   
   public static boolean validatePassword(String password) {
   //min and max lenght
      final int MIN_LENGTH = 8;
      final int MAX_LENGTH = 20;
      int index = 0;
      //needs to have the following
      boolean hasSymbol = false;
      boolean hasNumber = false;
      boolean hasUpper = false;
      boolean hasLower = false;
      boolean hasSpace = false;
      //check each chracter to find the requriment 
      while((password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH)
          && (index < password.length())
          && !(hasSymbol && hasNumber && hasUpper && hasLower)
          && !hasSpace) {
         if(!Character.isDigit(password.charAt(index)) && !Character.isLetter(password.charAt(index))) { 
            hasSymbol = true;
         }
         if(Character.isDigit(password.charAt(index))) {
            hasNumber = true;
         }
         if(Character.isUpperCase(password.charAt(index))) {
            hasUpper = true;
         }
         if(Character.isLowerCase(password.charAt(index))) {
            hasLower = true;
         }
         if(password.charAt(index) == ' ') {
            hasSpace = true;
         }
         index++;
      }//end while
      if ((password.length() > MIN_LENGTH && password.length() < MAX_LENGTH) && (hasSymbol && hasNumber && hasUpper && hasLower) && !hasSpace) {
         return true;
      }   
      else {
         return false;
      }
   }//end validatePassword()
   
   public static boolean validateUsername(String username) {
      boolean valid=false;
      //has to meet the length requirement
      final int MIN_LENGTH = 3;
      final int MAX_LENGTH = 15;
      if(username.length()>=MIN_LENGTH && username.length()<=MAX_LENGTH){
         valid=true;
      }  
      else{
         valid=false;
      }
      return valid;
   }
}
