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
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Day15 
{

    // Basic User-file Interaction.
    // * Let's first open a file, append this text inside
    
    // "
    //     Hello, I am a test.
    //     Append a text at the end of the file.
    // "
    // * Close the file writer
    // * Print the content of the file
    // * Close the file writer
    // * Append this text inside your file.
    // "
    //     Added!
    // "
    // * When this is done,
    // * Open the same file again, read the content,and print it.
    private static final String PATH = "text_data/";
    public static void main(String[] args)
    {
        File directory = new File(PATH);
        
        // create directory if it does not exist

        if( !(directory.exists()))
        {
            directory.mkdir();
        }
        
        File file = new File(PATH + "Day15_data.txt");
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

        // writing and reading processes
        try
        {
            // Write inside the file
            FileWriter writer =  new FileWriter(file.getAbsolutePath());
            System.out.println("\n----------- WRITING ------------\n");
            writer.write("Hello, I am a text.\nAppend this text inside your file.!\n");
            writer.close();
            Scanner sc = new Scanner(file); 

            System.out.println("\n----------- READING ------------\n");
            // read the content of the file
            while (sc.hasNextLine()) 
              System.out.println(sc.nextLine());
            
            sc.close();

            System.out.println("\n----------- WRITING ------------\n");
            // Append a text at the end of the file
            writer = new FileWriter(file.getAbsolutePath(), true);
            writer.write("Added!\n");
            writer.close();

            System.out.println("\n----------- READING ------------\n");
            sc = new Scanner(file);
            // read the content of the file
            while (sc.hasNextLine()) 
              System.out.println(sc.nextLine());
            
            sc.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("\nEnd of Program\n");
        
    }
} 