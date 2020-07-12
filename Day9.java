// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 8 : 
// Day 8 | IG : https://www.instagram.com/benjivrik/
// Subject :    Challenge V - Guess the number 
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.Random;
import java.util.Scanner;

public class Day9 
{
    /**
     * 
     * 
        Let the user guess the number you have just generated.
        Your  number should be generated between 0 and 10.
        if the value entered is higher  than the number
        let the user know so that the user can reduce its value
        for the next attempt.
        if the value entered is lower than the number
        let the user know so that the user can increase its
        value.
        Give 5 attemps to the user.
        If the user fails to find the number,
        ask the user if he wants to stop.
        If the user enter yes, stop program.
     */

    public static void main(String[] args)
    {
        // max attempt for the user to play
        int max_attempts = 5;

        // define the upper limit for the function nextInt
        // from 0 to 10
        int upper_limit = 11;

        // create the Scanner
        Scanner sc = new Scanner(System.in);

        // String for stopping the program
        String stop = "no";

        // initialize your Random object
        Random obj = new Random();

        // print a space at the beginning of the program
        // this space is not mandatory
        System.out.printf("\n");
        // loop for the main program
        while( stop.equals("no") )
        {
            // generate your number
            int generated_number =  obj.nextInt(upper_limit);
            
            System.out.println("Hello User. Guess the number I have generated.");

            while(max_attempts > 0)
            {
                System.out.printf("You have %d attempts left.\n", max_attempts);
                max_attempts--;
                generated_number++;
            }
            // ask the user if he wants to continue
            System.out.printf("Do you wanna stop ? (yes or no) :");
            stop = sc.next();
            System.out.println("\n");

        }

        // close the scanner 
        sc.close();

    }
    
}