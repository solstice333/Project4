import java.util.*;

public class HTDriver
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      HashTable<Student> table;
      String discard;
      char choice = 0;
      StringTokenizer st;
      String name;
      String token;
      String discard;
      Long idnum;
      int count;

      String filename = null;
      File inFile = null;
      Scanner in = null;

      System.out.println("enter name of the input file:");
      filename = input.next();
      try
       {
        inFile = new File("/Users/Casey/Dropbox/cpe103Shared/Project4/src",filename);
        in = new Scanner(inFile);
       }
       catch(IOException e)
       {
         e.printStackTrace();
       }
       count = in.nextInt();
       table = new HashTable<Student>(count);
       
       for(int i = 0; i < count; i++)
       {
          s = in.nextLine();
          st = new StringTokenizer(s);
          if(st.countTokens() == 2)
          {
             idnum = new Long(0);
             name = null;
             while(st.hasMoreTokens())
             {
                token = st.nextToken();
                try
                {
                   idnum = new Long(token);
                }
                catch(Exception e)
                {
                   name = token;
                }
             }
             if(!idnum.equals(0) && idnum > 0 && name != null)
             {
                table.insert(new Student(idnum,name));
             }  
          }
      }

     
      discard = input.nextLine();

      System.out.println("Choose one of the following operations by entering provided letter: "  
            + "\n   a - add the element"
            + "\n   d - delete the element" 
            + "\n   f - find and retrieve the element"
            + "\n   n - get the number of elements in the collection" 
            + "\n   e - check if the collection is empty"
            + "\n   k - make the hash table empty" 
            + "\n   p - print out the content of the hash table"
            + "\n   o - output the elements of the collection" 
            + "\n   q - Quit the program");

      while (choice != 'q')
      {
         System.out.println("Enter a menu choice: ");
         choice = input.nextLine().charAt(0);

         switch (choice)
         {
         case 'a':
            System.out.println("Input a id number and a name. (Same line separated by a space) ");
            s = in.nextLine();
            st = new StringTokenizer(s);
            if(st.countTokens() == 2)
            {
               idnum = new Long(0);
               name = null;
               while(st.hasMoreTokens())
               {
                  token = st.nextToken();
               try
               {
                  idnum = new Long(token);
               }
               catch(Exception e)
               {
                  name = token;
               }
            
            if(!idnum.equals(0) && idnum > 0 && name != null)
            {
               table.insert(new Student(idnum,name));
               System.out.println(item + " added");
            }
            
            }
            else
            {
               discard = input.nextLine();
               System.out.println("Invalid input");
            }

            break;

         case 'd':
            System.out.println("Input a integer only: ");
            if (input.hasNextInt())
            {
               Integer item = input.nextInt();
               discard = input.nextLine();
               table.delete(item);      
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
