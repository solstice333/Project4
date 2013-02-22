import java.io.File;
import java.io.IOException;
import java.util.*;

public class HTDriver
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      HashTable table;
      String discard;
      char choice = 0;
      StringTokenizer st;
      String name;
      String token;
      String s;
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
       table = new HashTable(count);
       
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
               }
            if(!idnum.equals(0) && idnum > 0 && name != null)
            {
               table.insert(new Student(idnum,name));
               System.out.println(idnum + " added");
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
               Long i = new Long(item);
               Student dummy = new Student(i,"dummy");
               if(table.find(i) != null)
               {
                  table.delete(dummy);  
               }    
               System.out.println("Student with hashcode "+i + "deleted");
            }
            else
            {
               discard = input.nextLine();
               System.out.println("Invalid input");
            }

            break;


         case 'f':
            System.out.println("Input a single Integer 0-9:");
            if(input.hasNextInt())
            {
               Integer item = input.nextInt();
               discard = input.nextLine();
               if(item < 0)
               {
                  System.out.println("Invalid Input");
                  break;
               }
               Long i = new Long(item);
               Student dummy = new Student(i,"dummy");
               if(table.find(dummy) != null)
               {
                   System.out.println("Student with key "+item+" was found in collection");
               }
               else
               {
                   System.out.println("Student not found");
               }
            }
            else
            {
               discard = input.nextLine();
               System.out.println("Invalid Input");
            }
            break;

         case 'n':
            System.out.println("The number of elements in the collection is "+table.elementCount());
            break;

         case 'q':
            System.out.println("quitting");
            break;

         case 'p':
            table.printTable();
            System.out.println();
            break;

         case 'e':
            if(table.isEmpty())
            {
               System.out.println("The collection is empty");
            }
            else
               System.out.println("The collection is not empty");
            break;
         
         case 'k':
            table.makeEmpty();
            System.out.println("Collection Emptied");
            break;
            
         case 'o':
            Iterator iter = table.iterator();
            while (iter.hasNext())
            {
               System.out.print(iter.next().toString() + " ");
            }
               break;
       
            
         
         default:
            System.out.println("Invalid choice");
         }

      }

      System.out.println();
   }
}
