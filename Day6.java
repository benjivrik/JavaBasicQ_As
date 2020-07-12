import java.util.Scanner;

// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 6 : 
// Day 6 | IG : https://www.instagram.com/benjivrik/
// Subject :  Conditions
// ----------------------------------------------------
// what would be the output of this program ?

public class Day6 {
    /**
     * 
     *  if( condition )
        {
    
            when this condition  is True, this block executes
        
        }
        else if( condition )
        {
        
            when the previous condition is not executed
            if this condition is True, this block executes
            
        }
        else 
        {
            if none of the above conditions are satisfied, this
            block executes
        }

     */

    /**
     * return the double of the parameter
     * @param value
     * @return
     */
    public static int double_parameter(int value)
    {
        return value * 2;
    }

    /**
     * return the value of the parameter divide by two
     * @param value
     * @return
     */
    public static double divide_parameter_by_two(double value)
    {
        return value / 2;
    }

    /**
     * return add 2 to the value of the parameter
     * @param value
     * @return
     */
    public static int add_two_to_the_parameter(int value)
    {
        return value + 2;
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String stop = "n";
        while(stop.equals("n"))
        {
            int user_value;
            // Request the user to enter a value;
            System.out.printf("\nPlease enter an integer : ");
            user_value = sc.nextInt();
            

            if( user_value < 5)
            {
                //add two to the parameter
                System.out.printf("\nAdding 2 to your value %d gives %d.\n",user_value, Day6.add_two_to_the_parameter(user_value));

            }
            else if (user_value >= 5 && user_value < 10)
            {
                //divide 
                System.out.printf("\nDividing your value %d by 2 gives %.2f.\n",user_value, Day6.divide_parameter_by_two(user_value));
            }
            else // user
            {
                // multiply
                System.out.printf("\nAdding 2 to your value %d gives %d.\n",user_value, Day6.double_parameter(user_value));
            }

            System.out.printf("\nDo you want to stop ?(y/n) : ");
            stop = sc.next();

        }
        sc.close();
        System.out.println("End of program.");

    }
    
}