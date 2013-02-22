import java.util.*;

public class driverTest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String discard;
      HashTable table = new HashTable(3);

      Student s1 = new Student(123093, "bob");
      Student s2 = new Student(123957, "smith");
      Student s3 = new Student(192377, "joe");
      Student s4 = new Student(120938, "larry");
      Student s5 = new Student(210938, "Timmy");
      Student s6 = new Student(1, "Kid");

      table.insert(s1);
      table.insert(s2);
      table.insert(s3);
      table.insert(s4);
      table.insert(s5);
      table.insert(s6);

      boolean exit = false;
      while (!exit) {
         System.out.println("Insert id (long type integer): ");
         Long id = input.nextLong();
         System.out.println("last name (one word, no spaces): ");
         String lastName = input.next();

         if (table.find(new Student(id, lastName)) != null)
            System.out.println("found!");
         else
            System.out.println("not found!");
         
         System.out.println("Do you want to quit? (y/n)");
         if(input.next().charAt(0) == 'y')
            exit = true;
      }

      table.printTable();
   }
}