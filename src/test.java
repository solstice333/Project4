import java.util.Iterator;
import java.util.NoSuchElementException;


public class test {

   public static void main(String[] args) {
      HashTable ht = new HashTable(2);

      for(int i = 0; i < 5; i++) {
         ht.insert(i);
      }
      
      for(int i = 0; i < 5; i++) {
         System.out.println("Found: " + (Integer)ht.find(i));
      }
      
      System.out.println("Found: " + (Integer)ht.find(9));
      
      ht.printTable();
   }
}




