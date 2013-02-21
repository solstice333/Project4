import java.math.BigInteger;
import java.util.Iterator;

public class HashTable {

   private class HashEntry {
      public Object element;
      public boolean active;
   }

   private HashEntry[] HashEntry;
   private int occupied;
   
   public HashTable(int collectionSize) {
      BigInteger val = new BigInteger(String.valueOf(collectionSize));
      HashEntry = new HashEntry[val.intValue()*2];
   }
   
   private class Iter implements Iterator {
      int cursor;
      
      @Override
      public boolean hasNext() {
         return cursor < HashEntry.length;
      }

      @Override
      public Object next() {
         // TODO Auto-generated method stub
         return null;
      }

      @Override
      public void remove() {
         // TODO Auto-generated method stub
         
      }
      
   }
   
}
