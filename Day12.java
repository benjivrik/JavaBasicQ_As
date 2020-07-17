// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 12 : 
// Day 12 | IG : https://www.instagram.com/benjivrik/
// Subject :   Dictionary (key,value) using java Hashmap
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.Scanner;
import java.util.HashMap;

public class Day12 
{
    
    /**
     * what is HashMap ?
     * 
     * Internet > Object that stores items as key/value pairs
     * 
     */
    public static void main(String[] args)
    {
        // create the HasMap object
        HashMap<String,String> items =  new HashMap<String,String>();
        // adding items in your HashMap object
        items.put("water","10$");
        items.put("biscuits","2$");
        items.put("chocolate","4$");
        items.put("rice","3$");
        items.put("wine","5$");

        Scanner sc = new Scanner(System.in);

        // get user name
        System.out.println("\nHey, what is your name?");
        String name = sc.next();
        // welcoming the user
        System.out.println(String.format("\nHello %s, I have the following items in my store", name));
        // print all the keys and values
        for(String key : items.keySet())
        {
            System.out.printf("> %s : %s", key, items.get(key));
            System.out.printf("\n");
        }

        String stop = "n";
        while(stop.equals("n"))
        {

            System.out.println("\nWhich item price do you want to check ?");
            System.out.println("Enter your item name :");
            String user_choice = sc.next();

            while(!(items.containsKey(user_choice)))
            {
                System.out.println(
                        String.format("I do not have the item %s. Please enter a correct item :",user_choice)
                    );
                user_choice = sc.next();
            }

            System.out.println(
                 String.format("Thank you. The price for them item %s is %s",user_choice, items.get(user_choice))
            );
            
            // ask the user if he wants to continue
            System.out.printf("\nDo you wanna stop ? (y/n) :");
            stop = sc.next();
            if(!stop.equals("y"))
            {
                stop = "n";
            }
            
            System.out.println("\n");
            
        }

        sc.close();
        System.out.println("End of program.");
    }

}