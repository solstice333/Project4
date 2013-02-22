import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable {

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
      occupied = 0;

      int index;
      for (int i = 0; i < temp.length; i++) {
         if (temp[i] != null && temp[i].active) {
            index = findPosition(temp[i].element);
            HashArray[index] = temp[i];
            occupied++;
         }
      }
   }

   private class Iter implements Iterator {
      int cursor;

      public Iter() {
         cursor = 0;
         while (hasNext() && (HashArray[cursor] == null || !HashArray[cursor].active)) {
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

         Object val = HashArray[cursor].element;
         cursor++;
         
         while (hasNext() && (HashArray[cursor] == null || !HashArray[cursor].active)) {
            cursor++;
         }

         return val;
      }

      @Override
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   public HashTable(int collectionSize) {
      BigInteger val = new BigInteger(String.valueOf(collectionSize * 2));
      HashArray = new HashEntry[val.nextProbablePrime().intValue()];
   }

   public Object find(Object item) {
      int index = findPosition(item);
      boolean found = false;

      if (HashArray[index] != null && HashArray[index].active) {
         found = true;
         return HashArray[index].element;
      }

      return null;
   }

   public void insert(Object item) {
      int index = findPosition(item);
      if (HashArray[index] == null) {
         HashArray[index] = new HashEntry(item);
         occupied++;
         if (occupied >= HashArray.length / 2)
            rehash();
      }
      else if (!HashArray[index].active)
         HashArray[index].active = true;
   }

   public void delete(Object item) {
      int index = findPosition(item);
      if(HashArray[index] != null) {
         HashArray[index].active = false;
      }
   }
   
   public int elementCount() {
      int count = 0;
      Iterator iter = iterator();
      
      while(iter.hasNext()) {
         iter.next();
         count++;
      }
      
      return count;
   }
   
   public boolean isEmpty() {
      if(elementCount() > 0) 
         return false;
      return true;
   }
   
   public void makeEmpty() {
      BigInteger val = new BigInteger(String.valueOf(HashArray.length));
      HashArray = new HashEntry[val.nextProbablePrime().intValue()];
      occupied = 0;
   }
   
   public void printTable() {
      for (int i = 0; i < HashArray.length; i++) {
         try {
            if (HashArray[i].active)
               System.out.println("[" + i + "]: " + HashArray[i].element
                     + ", active");
            else
               System.out.println("[" + i + "]: " + HashArray[i].element
                     + ", inactive");
         }
         catch (NullPointerException npe) {
            System.out.println("[" + i + "]: null, inactive");
         }
      }
   }

   public Iterator iterator() {
      return new Iter();
   }
}
