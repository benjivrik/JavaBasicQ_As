// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 25 : Working with json files in Java
// Day 25 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

/**
 * 
 * What is a JSON (JavaScript Object Notation)  file ? 
 * 
 * internet : JSON is a syntax for storing and exchanging data. (ref: w3schools)
 * 
 * Using this jar library :  https://code.google.com/archive/p/json-simple/
 * 
 * Use a JSONObject from the above jar and write it inside a file. 
 * 
 */


import org.json.simple.JSONObject;


import java.io.IOException;
import java.io.StringWriter;

public class Day25 {

    private static String getText(JSONObject obj)
    {
        // https://docs.oracle.com/javase/7/docs/api/java/io/StringWriter.html
        // A character stream that collects its output in a string buffer, which can then be used to construct a string.
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("text_data/", "Day25_data.txt");
        // Display file manager info
        System.out.println(fileManager);

        fileManager.clearFile();

        // initialize your json object
        JSONObject obj1 = new JSONObject();
        
        obj1.put("user_name","krik");
        obj1.put("user_age",25);
        obj1.put("user_category","student");

        System.out.println("\n************** DISPLAYING JSON FIELD user_category **************\n");
        // access key value using the method get()
        System.out.println("User category : " + obj1.get("user_category"));

     
        // get your string from the String writer recently created 
        String jsonText = getText(obj1);
        // write your jsonText inside the text file via your file manager
        fileManager.addContentInFile(jsonText);

        // System.out.print(jsonText);

        fileManager.addContentInFile("\n");

        // second json data
        JSONObject obj2 = new JSONObject();

        obj2.put("user_name","vrik");
        obj2.put("user_age",27);
        obj2.put("user_category","ambassador");

        // get your string from the String writer recently created 
        jsonText = getText(obj2);
        // write your jsonText inside the text file via your file manager
        fileManager.addContentInFile(jsonText);

        // System.out.print(jsonText);

        // display all data
        fileManager.displayAllData();

       
    }
}