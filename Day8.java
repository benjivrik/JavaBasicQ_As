// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 8 : 
// Day 8 | IG : https://www.instagram.com/benjivrik/
// Subject :    import class Random 
// ----------------------------------------------------
// what would be the output of this program ?


/**
 *  
    What is the use of this class ?
    Internet > An instance of this class is used to generate a stream of pseudorandom numbers

    Each class that you import have their own functions. 
    How to use them ? Simply instantiate the object of the class you have imported.

    Let's generate 5 five random  numbers between 0 and 10, five times
    We are going to use the function nextInt(upperLimit) of the Random Library.
    
    this function will generate number from 0 (included) to the upperLimit(not included)
 */

import java.util.Random;

public class Day8 
{

    public static void main(String[] args)
    {
        // Create your Random object
        Random obj = new Random();

        // print a space at the beginning of the program
        // this space is not mandatory
        System.out.printf("\n");
        // use the function nextInt() in the object obj 
        // created above
        // Let's print the values on the terminal
        // print them five times
        for(int i = 0; i < 5 ; i++ )
        {
            // get the generated value
            // 0 to 10
            int generated_value = obj.nextInt(11);
            // print the value on your terminal
            System.out.printf("> %d. Value generated : %d;\n",i+1,generated_value);
        }
    }
}