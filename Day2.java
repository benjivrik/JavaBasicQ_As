// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 2 :  Data types 
// Day 2 | IG : https://www.instagram.com/benjivrik/
// Subject :  Data types
// ----------------------------------------------------
// what would be the output of this program ?

public class Day2
{
    /**
     *
     *  How do you declare a class ? 
     * 
     * Modifier class class_name
     * 
     * Your modifier here can be public or private
     * 
     * Look at the example for this file. The file name is Day2.java
     * and the class inside is public class Day2.
     * 
     * Keep your class name starting with a uppercase first letter and 
     * your variable names starting with a lowercase first letter
     *  
     * 
     * You can find a full documentation here :  https://docs.oracle.com/javase/9/docs/api/overview-summary.html
     * 
     */
    /**
     * This is the main function for running your program in java
     * @param args
     */
    public static void main(String[] args)
    {
        // primitive data type of java
        

        // Integer
        byte byt = 5;    // 8 bits      
        char y = '2';    // 8 bits 
        short item = 54; // 16 bits
        int x = 0;       // 32 bits
        long value = 4 ; // 64 bits


        // floating points
        float float_one = 10.5f; // 32 bits
        float float_second = (float) 10.5; //Narrowing casting going from double to float
        double double_one = 0.5; //64 bits

        //boolean
        boolean should_be_true = true;
        boolean should_be_false = false;

        // Objects - I may be missing classes here

        String name = "Jivrik"; // a String
        Integer val = Integer.valueOf(4);

        System.out.printf("Your byte is %d\n",byt);
        System.out.printf("Your char is %c\n",y);
        System.out.printf("Your short is %d\n",item);
        System.out.printf("Your int is %d\n",x);
        System.out.printf("Your long is %d\n",value);
        System.out.printf("Your first float is %f\n",float_one);
        System.out.printf("Your second float is %f\n",float_second);
        System.out.printf("Your double is %f\n",double_one);
        System.out.printf("Your first boolean is %b\n",should_be_true);
        System.out.printf("Your second boolean is %b\n",should_be_false);
        System.out.printf("Your String is %s\n",name);
        System.out.printf("Your Integer is %d\n",val);

        System.out.println("End of program.");


    }
}