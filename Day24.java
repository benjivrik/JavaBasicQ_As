// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 23 : Challenge XII - File Manager
// Day 23 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileManager {
    private String path;
    private String fileName;

    public FileManager(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
        this.init(this.path, this.fileName);
    }

    // initialize directory and file
    private void init(String path, String fileName) {
        File directory = new File(path);

        // create directory if it does not exist

        if (!(directory.exists())) {
            directory.mkdir();
        }

        File file = new File(path + fileName);
        // creating the file if it does not exist
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("\nFile successfully created : " + file.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else // the file does not exist
        {
            System.out.println(String.format("\nFile %s already exists.", file.getName()));
        }

    }

    // set filename and create the file
    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.init(this.path, this.fileName);
    }

    // get filename
    public String getFileName() {
        return this.fileName;
    }

    // set folder path and create the folder with the current if you set initPath to
    // true
    // Customizable function
    public void setFolderPath(String path, boolean initPath) {
        this.path = path;

        if (initPath)
            this.init(this.path, this.fileName);
    }

    // display all the data contained in the file
    public void displayAllData() {
        File file = new File(path + fileName);

        Scanner sc;
        try {

            sc = new Scanner(file);
            System.out.println("\n----------- READING ------------\n");
            // read the content of the file
            while (sc.hasNextLine()) 
                System.out.println(sc.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // add the content to the existing file
    public void addContentInFile(String data)
    {

        File file = new File(path + fileName);

        // Append a text at the end of the file
        try {
            
           
            System.out.println("\n----------- WRITING ------------\n");

            FileWriter writer =  new FileWriter(file.getAbsolutePath(),true);

            writer.write(data);
            writer.close();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

    // clear content in file
    public void clearFile()
    {
        File file = new File(path + fileName);

        // Append a text at the end of the file
        try {
            
            FileWriter writer =  new FileWriter(file.getAbsolutePath());

            writer.write("");
            writer.close();

            System.out.println("\n----------- FILE CLEARED ------------\n");
            

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    // to String
    public String toString()
    {
        System.out.println("\n************** DISPLAYING FILE MANAGER INFO **************\n");

        String fileManager = "\nHello,\nYour current folder is '"+ this.path+"'.\n";
        fileManager += "And you are working with the file '" + this.fileName +"'.\n";
        fileManager += "Your full path is '" + this.path + this.fileName+"'.";
        return  fileManager;
    }
}
public class Day24 
{
    public static void main(String[] args)
    {
        FileManager fileManager = new FileManager("text_data/","Day24_data.txt");
        // display the informatin about the task manager
        System.out.println(fileManager);
        // clearing data inside the file
        fileManager.clearFile();
        // adding random data
        fileManager.addContentInFile("blah blah\n");
        fileManager.addContentInFile("TEST\n");
        fileManager.addContentInFile("blah blah blah\n");
        // display all data
        fileManager.displayAllData();
    }
    
}