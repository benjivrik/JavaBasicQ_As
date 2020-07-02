import java.util.Scanner;

// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 7 : 
// Day 7 | IG : https://www.instagram.com/benjivrik/
// Subject :  challenge IV - Basic Calculator
// ----------------------------------------------------
// what would be the output of this program ?

public class Day7_Calculator
{
    /**
     * 
    Create a basic calculator that let the user
    choose between the following operators
    +,-,*,/
    and let the user enter the operands a and b

     */
    // constructor
    public Day7_Calculator()
    {
        System.out.println("\n> Calculator created.");
    }
    // operations

    /**
     * add the parameters a and b
     * @param a
     * @param b
     * @return
     */
    public double add_operands(double a, double b)
    {
        return a + b;
    }

    /**
     * subtract the b from a
     * @param a
     * @param b
     * @return
     */
    public double subtract_operands(double a, double b)
    {
        return a-b;
    }
    
    /**
     * multiply the operands a and bs
     * @param a
     * @param b
     * @return
     */
    public double multiply_operands(double a, double b)
    {
        return a*b;
    }

    public double divide_operands(double a, double b)
    {
    
        if(b == 0)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("You can not divide an integer by 0");
            while( b == 0)
            {
                System.out.printf("Please enter a correct value for b:");
                b = sc.nextDouble();
            }
            sc.close();

            System.out.printf("\n> For this division, the new value of b is set to %.2f\n",b);
        }
        
        return a / b;
    }
}