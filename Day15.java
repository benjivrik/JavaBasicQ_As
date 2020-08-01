// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 14 : 
// Day 14 | IG : https://www.instagram.com/benjivrik/
// Subject :   File Handling
// ----------------------------------------------------
// what would be the output of this program ?

import java.io.File;
import java.io.IOException;

public class Day15 
{
    // File file = 
    //   new File("C:\\Users\\pankaj\\Desktop\\test.txt"); 
    // Scanner sc = new Scanner(file); 
  
    // while (sc.hasNextLine()) 
    //   System.out.println(sc.nextLine());

    //     try
    // {
    //     String filename= "MyFile.txt";
    //     FileWriter fw = new FileWriter(filename,true); //the true will append the new data
    //     fw.write("add a line\n");//appends the string to the file
    //     fw.close();
    // }
    // catch(IOException ioe)
    // {
    //     System.err.println("IOException: " + ioe.getMessage());
    // }
    private static final String PATH = "text_data/";
    public static void main(String[] args)
    {
        File directory = new File(PATH);
        
        // create directory if it does not exist

        if( !(directory.exists()))
        {
            directory.mkdir();
        }
        
        File file = new File(PATH + "Day15.txt");
        // creating the file if it does not exist
        if(!file.exists())
        {
            try
            {
                if(file.createNewFile())
                {
                    System.out.println("File successfully created : "+file.getName());
                }
            }catch(IOException e)
            {
                e.printStackTrace();
            }
           
        }
        else   // the file does not exist
        {
            System.out.println(
                    String.format("File %s already exists.", file.getName())
                );
        }


        
    }
    
}