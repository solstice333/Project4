import java.util.Iterator;
import java.util.NoSuchElementException;

public class test {

   public static void main(String[] args) {
      HashTable ht = new HashTable(2);

      for (int i = 2; i < 7; i++) {
         ht.insert(i);
      }
      ht.insert(9);
      ht.insert(12);
      ht.insert(14);

      Iterator iter = ht.iterator();

      while (iter.hasNext()) {
         System.out.println("iter.next(): " + (Integer) iter.next());
      }

      System.out.println("\n\n ht.printTable: ");
      ht.printTable();
   }
}
