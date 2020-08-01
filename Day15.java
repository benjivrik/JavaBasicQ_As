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

public class Day15 
{
    // File file = 
    //   new File("C:\\Users\\pankaj\\Desktop\\test.txt"); 
    // Scanner sc = new Scanner(file); 
  
    // while (sc.hasNextLine()) 
    //   System.out.println(sc.nextLine());
    private static final String PATH = "text_data/";
    public static void main(String[] args)
    {
        File directory = new File(PATH);

        if( !(directory.exists()))
        {
            directory.mkdir();
        }
    }
    
}