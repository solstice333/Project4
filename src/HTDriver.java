import java.util.*;

public class HTDriver
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      HashTableSC<Integer> t;
      String discard;
      char choice = 0;

      System.out.println("Enter size of table: ");
      t = new HashTableSC<Integer>(input.nextInt());
      discard = input.nextLine();

      System.out.println("Operations: "  
            + "\n   - Add/insert (a)"
            + "\n   - delete (d)" 
            + "\n   - empty (e)"
            + "\n   - print the hashtable (p)" 
            + "\n   - find (f) "
            + "\n   - quit (q)");

      while (choice != 'q')
      {
         System.out.println("Enter a menu choice: ");
         choice = input.nextLine().charAt(0);

         switch (choice)
         {
         case 'a':
            System.out.println("Input a value: ");
            if (input.hasNextInt())
            {
               Integer item = input.nextInt();
               discard = input.nextLine();
               t.insert(item);
               System.out.println(item + " added");
            }

            else
            {
               discard = input.nextLine();
               System.out.println("Invalid input");
            }

            break;

         case 'd':
            System.out.println("Input a value: ");
            if (input.hasNextInt())
            {
               Integer item = input.nextInt();
               discard = input.nextLine();
               t.delete(item);
               System.out.println(item + " deleted");
            }
            else
            {
               discard = input.nextLine();
               System.out.println("Invalid input");
            }
            break;

         case 'e':
            if (t.isEmpty())
               System.out.println("empty");
            else
               System.out.println("not empty");
            break;

         case 'f':
            System.out.println("Input a value: ");
            if (input.hasNextInt())
            {
               Integer item = input.nextInt();
               discard = input.nextLine();

               if (t.find(item))
                  System.out.println(item + " found");
               else
                  System.out.println(item + " not found");
            }

            else
            {
               discard = input.nextLine();
               System.out.println("Invalid input");
            }

            break;

         case 'q':
            System.out.println("quitting");
            break;

         case 'p':
            t.print();
            System.out.println();
            break;

         default:
            System.out.println("Invalid choice");
         }

      }

      System.out.println();
   }
}
