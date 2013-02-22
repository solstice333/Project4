import java.util.Iterator;
import java.util.NoSuchElementException;

public class hashTableTest {

   /*
    * Description:
    * Parameters:
    * Preconditions:
    * Return value:
    * Exceptions:
    * Postconditions:
    */
   public static void main(String[] args) {
      HashTable ht = new HashTable(2);

      /*
      for (int i = 2; i < 7; i++) {
         ht.insert(i);
      }
      */
      
      ht.insert(9);
      ht.insert(12);
      ht.insert(14);
      ht.delete(9);
      ht.delete(12);
      ht.delete(14);
      ht.insert(9);
      ht.insert(1);
      ht.insert(2);
      ht.insert(12);
      ht.insert(14);
      ht.insert(2);
      ht.insert(23);
      ht.insert(23);
      ht.delete(23);
      
      System.out.println("ht.find(23): " + ht.find(23));
      
      Iterator iter = ht.iterator();

      while (iter.hasNext()) {
         System.out.println("iter.next(): " + (Integer) iter.next());
      }

      System.out.println("\n\nht.printTable: ");
      ht.printTable();
      System.out.println("\n\nht.elementCount(): " + ht.elementCount());
      System.out.println("\n\nht.isEmpty(): " + ht.isEmpty());
   }
}
