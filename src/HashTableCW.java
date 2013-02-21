import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTableCW {

   private class HashEntry {
      public Object element;
      public boolean active;

      public HashEntry(Object x) {
         element = x;
         active = true;
      }
   }

   private HashEntry[] HashArray;
   private int occupied;

   private int hash(Object x) {
      return Math.abs(x.hashCode()) % HashArray.length;
   }

   private int findPosition(Object x) {
      int i = 0;
      int hashValue = hash(x);
      int index = hashValue;

      while (HashArray[index] != null && !x.equals(HashArray[index].element)) {
         i++;
         index = (hashValue + i * i) % HashArray.length;
      }

      return index;
   }

   private void rehash() {
      HashEntry[] temp = HashArray;

      BigInteger val = new BigInteger(String.valueOf(HashArray.length * 2));
      HashArray = new HashEntry[val.nextProbablePrime().intValue()];

   }

   public HashTable(int collectionSize) {
      BigInteger val = new BigInteger(String.valueOf(collectionSize * 2));
      HashArray = new HashEntry[val.nextProbablePrime().intValue()];
   }

   // Requires testing
   private class Iter implements Iterator {
      int cursor;

      public Iter() {
         cursor = 0;
         while (!HashArray[cursor].active) {
            cursor++;
         }
      }

      @Override
      public boolean hasNext() {
         return cursor < HashArray.length;
      }

      @Override
      public Object next() {
         if (!hasNext())
            throw new NoSuchElementException();

         HashEntry val = HashArray[cursor];
         while (!HashArray[cursor].active) {
            cursor++;
         }

         return val;
      }

      @Override
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   public Object find(Object item) {
      int index = findPosition(item);
      boolean found = false;

      if (HashArray[index] != null && HashArray[index].active)
         found = true;

      return HashArray[index];
   }

   public void printTable() {

   }

}
