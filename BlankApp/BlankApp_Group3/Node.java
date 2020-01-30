/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   Node.java
   
   The purpose of this class is to define the data for a Node object to be stored in a LinkedList.
*/

public class Node {
   private Transaction data;
   private Node next;
   
   /*
      Create the Node object through a constructor with 2 parameters. 
      @param data The transaction data to be added to the Node. 
      @param next The location of the next node that will be linked. 
   */ 
   public Node(Transaction data, Node next) {
      this.data = data;
      this.next = next;
   }
   
   /*
      Get the transaction data from a Node. 
      @return transaction The transaction in the Node. 
   */
   public Transaction getData() { 
      return this.data; 
   }
   
   /*
      Get the location of the next linked Node. 
      @return next The next Node. 
   */
   public Node getNext() { 
      return this.next; 
   }
   
   /*
      Set the transaction data in the Node. 
      @param data The new transaction to be set in the Node. 
   */
   public void setData(Transaction data) {
      this.data = data;
   }
   
   /*
      Set the location of the next linked Node. 
      @param next The location of the next linked Node. 
   */
   public void setNext(Node next) {
      this.next = next;
   }
   
   /*
      Determine if the current node links to another node. 
      @return boolean Whether or not a link to another node exists. 
   */
   public boolean hasNext() {
      if (next != null) {
         return true;
      }
      else {
         return false;
      }
   }

}