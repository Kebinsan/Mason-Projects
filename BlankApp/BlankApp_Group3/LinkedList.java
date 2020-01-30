/*
   @author Rusul Kamal
   @author Kevin Robinson
   @author Adelyn Gaegler 
     
   IT306-001 | Prof. Fennel 
   Project Phase IV/V
   LinkedList.java
   
   The purpose of this class is to define the data for a LinkedList that stores Node objects.
*/

public class LinkedList {
   private Node head;
   private int size;
   
   /*
      Create the linkedList through a default constructor. 
   */   
   public LinkedList() {
      this.size = 0;
   }
   
   /*
      Determine whether or not the linkedList is empty.
      @return boolean Whether or not the linkedList is empty. 
   */
   public boolean isEmpty() {
      if (head == null) {
         return true;
      }
      else {
         return false;
      }
   }
   
   /*
      Get the size of the linkedList.
      @return size The size of the linkedList. 
   */
   public int getSize() { 
      return this.size; 
   }
   
   /*
      Add a node to the linkedList. 
      If the linkedList is empty, add the node to the head. Otherwise, add the node to the end of the linkedList. 
      @param node The new node to be added to the linkedList. 
   */
   public void add(Node node) {
      size++;
      if(isEmpty()) {
         head = node;
      }
      else {
         Node curr = head;
         if(!curr.hasNext()) {
            curr.setNext(node);
         }
         else {
            while(curr.hasNext()) {
               curr = curr.getNext();
            }
            curr.setNext(node);
         }
      }
   }
   
   /* 
      Get a transaction from the linkedList. 
      @param index The index of the requested transaction in the linkedList. 
      @return transaction The transaction found at the index searched. 
    */
   public Transaction get(int index) {
      if(isEmpty()) {
         return null;
      }
      if(index >= size || index < 0) {
         throw new IndexOutOfBoundsException();
      }
      int count = 0;
      Node current = head;
      while(count != index) {
         current = current.getNext();
         count++;
      }
      return current.getData();
   }

}