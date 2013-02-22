   /*
 * @authors: Casey Wu, Kevin Navero   
 * @Assignment name: Project 4
 * @Class and section number: CPE103-04
 */

import java.util.*;
 
 /*
 * Description: Student class represents a Student that has their id number and name;
 */
public class Student 
{
   private long id;
   private String lname;

   /*
    * Description: The constructor takes in a long and string, the long represents the students id number
    * and the string represents the Student's last name. 
    */
   public Student(long id, String lname)
   {
      this.id = id;
      this.lname = lname;
   }
   
   /*
    * Description: the equals, method of Student determines whether the students are the same or not based on their ID number
    * Parameters: Student other, represents the other student which the student that calls this method 
    *             will be compared with
    * Preconditions: must both be of Student type with valid ID numbers
    * Return value: returns true if the students are the same false if they are not the same
    */
   public boolean equals(Object other)
   {
      return this.id == other.id
   }
   
   /*
    * Description: toString creates the student with his id number and name into a string as specified.
    * Parameters: None
    * Preconditions: Valid student calling this method. 
    * Return Value: a string representing the student with his ID number and last name
    */
    
   public String toString()
   {
      String s;
      s = "{ id: " + id + ", name: " + lname + " }";
      return s;
   }
   
   /*
    * Description: hash code method uses the student id has the key to hash
    * Parameters: None    
    * Preconditions: Valid student calling this method. 
    * Return Value: returns the hash code
    */
    
   public int hashCode()
   {
      return 0;
   }
}

