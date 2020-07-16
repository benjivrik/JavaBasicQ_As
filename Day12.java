import java.util.HashMap;

// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 11 : 
// Day 11 | IG : https://www.instagram.com/benjivrik/
// Subject :   Dictionary (key,value) using java Hashmap
// ----------------------------------------------------
// what would be the output of this program ?

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
        // welcoming the user
        System.out.println("\nHello User, I have the following items in my store");
        // print all the keys and values
        for(String key : items.keySet())
        {
            System.out.printf("> %s : %s", key, items.get(key));
            System.out.printf("\n");
        }
        
    }

}