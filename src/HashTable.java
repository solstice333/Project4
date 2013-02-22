/*
 * @authors: Casey Wu, Kevin Navero    
 * @Assignment name: Project 4
 * @Class and section number: CPE103-04
 */

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Description: HashTable creates and manages an array of HashEntry objects 
 */
public class HashTable {
   
   /*
    * Description: HashEntry objects contain two values - the Object type
    * element passed to the constructor and a boolean value defining if the
    * HashEntry is active or not
    */
   private class HashEntry {

      /*
       * Description: element is the object to be stored within HashEntry
       */
      public Object element;

      /*
       * Description: active describes if the HashEntry is active/inactive within
       * the collection
       */
      public boolean active;

      /*
       * Description: HashEntry creates an entry to store within the hash table and sets
       * element and active to Object x and true respectively
       * Parameters: x is the element to store within the entry
       */
      public HashEntry(Object x) {
         element = x;
         active = true;
      }
   }
   
   /*
    * Description: HashArray is a hash table implemented as a HashEntry array 
    */
   private HashEntry[] HashArray;
   
   /*
    * Description: occupied is the number of entries occupying the table (active or inactive)
    */
   private int occupied;

   /*
    * Description: hash returns the hashCode as integer type
    * Parameters: x is the object requiring the hashcode
    * Preconditions: x is not null
    * Return value: returns integer type hashcode
    */
   private int hash(Object x) {
      return Math.abs(x.hashCode()) % HashArray.length;
   }

   /*
    * Description: findPosition finds the position of where x is located
    * Parameters: x is the object to search the position for
    * Preconditions: x is not null
    * Return value: returns an integer for the index of where x is located on the hash table
    */
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

   /*
    * Description: rehash recreates the array size to double the length
    */
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

   /*
    * Description: Iter implements the Iterator interface to traverse hash entries existing 
    * in the hash table
    */
   private class Iter implements Iterator {

      /*
       * Description: cursor is the cursor position that points to an active hash entry
       */
      int cursor;

      /*
       * Description: constructor for Iter class. Positions iterator at first active hash entry.
       */
      public Iter() {
         cursor = 0;
         while (hasNext()
               && (HashArray[cursor] == null || !HashArray[cursor].active)) {
            cursor++;
         }
      }

      /*
       * Description: checks if cursor has any active hash entries to traverse through
       * Return value: true if cursor has active hash entries to traverse through, false otherwise
       */
      @Override
      public boolean hasNext() {
         return cursor < HashArray.length;
      }

      /*
       * Description: cursor returns the hash entry at the current cursor position and 
       * moves to the next active hash entry position
       * Return value: returns hash entry element at current cursor position
       */
      @Override
      public Object next() {
         if (!hasNext())
            throw new NoSuchElementException();

         Object val = HashArray[cursor].element;
         cursor++;

         while (hasNext()
               && (HashArray[cursor] == null || !HashArray[cursor].active)) {
            cursor++;
         }

         return val;
      }

      /*
       * Description: unsupported operation
       * Exceptions: throws an UnsupportedOperationException
       */
      @Override
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   /*
    * Description: HashTable constructor initializes HashArray with HashEntry array
    * Parameters: collectionSize is the size of the intended collection (half the 
    * size of the array length)
    * Postconditions: empty HashEntry array
    */
   public HashTable(int collectionSize) {
      BigInteger val = new BigInteger(String.valueOf(collectionSize * 2));
      HashArray = new HashEntry[val.nextProbablePrime().intValue()];
   }

   /*
    * Description: checks if the item exists within the the HashTable as active
    * Parameters: item is the object to search for
    * Preconditions: item is not null
    * Return value: if item exists and is active, returns the found element belonging to the HashEntry
    * at the HashArray index
    */
   public Object find(Object item) {
      int index = findPosition(item);
      boolean found = false;

      if (HashArray[index] != null && HashArray[index].active) {
         found = true;
         return HashArray[index].element;
      }

      return null;
   }

   /*
    * Description: insert adds a HashEntry to the hash table
    * Parameters: item is the element to add to the hash table
    * Preconditions: item is not null
    * Postconditions: HashEntry added to hash table and occupied is incremented
    */
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

   /*
    * Description: delete deletes Object item if it exists as active within the hash table. Does 
    * nothing otherwise.
    * Parameters: item is the element to delete from the hash table
    * Preconditions: item is not null
    * Postconditions: sets active to false if item exists in hash table
    */
   public void delete(Object item) {
      int index = findPosition(item);
      if (HashArray[index] != null) {
         HashArray[index].active = false;
      }
   }

   /*
    * Description: counts all active hash entries
    * Return value: total integer count of how many active hash entries exists
    */
   public int elementCount() {
      int count = 0;
      Iterator iter = iterator();

      while (iter.hasNext()) {
         iter.next();
         count++;
      }

      return count;
   }

   /*
    * Description: checks if hash is empty
    * Return value: true if hash table is empty (or all entries inactive), false otherwise
    */
   public boolean isEmpty() {
      if (elementCount() > 0)
         return false;
      return true;
   }

   /*
    * Description: makes the hash table empty by reinitializing it with a new HashEntry array
    * Postconditions: garbage collector cleans old HashArray and HashArray points to new HashEntry array
    */
   public void makeEmpty() {
      BigInteger val = new BigInteger(String.valueOf(HashArray.length));
      HashArray = new HashEntry[val.nextProbablePrime().intValue()];
      occupied = 0;
   }
   /*
    * Description: prints entire HashArray, null indices inclusive
    */
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
            System.out.println("[" + i + "]: empty, inactive");
         }
      }
   }

   /*
    * Description: returns an iterator instance to client
    * Return value: Iter object
    */
   public Iterator iterator() {
      return new Iter();
   }
}
