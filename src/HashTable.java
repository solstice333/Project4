import java.math.BigInteger;

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
}
