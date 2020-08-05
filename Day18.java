// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 18 : Writing in a File - Data coming from the web
// Day 18 | IG : https://www.instagram.com/benjivrik/
// Subject : Challenge X - Data processing - Read and Plot 
// ----------------------------------------------------
// what would be the output of this program ?

// Open a text file and write inside the following content:
// Angle  Cosine  Sine
// 0
// 15
// 30
// 45
// 60
// 75
// ...
// Generate your angle from 0 to 360. 
// And add a 15 degrees span between each angle value.

// Close the File.
// Read the File you have just created.
// and using the matplotlib.pyplot module, 
// plot the cosine and sine values 
// with two different graphs.
// The module numpy will help you to generate the required values
// for your array.
// Use its function arange(start,stop,step) where step should be 15
// in our case.
// Use the module math for the sine and cosine calculations.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import org.apache.commons.lang3.StringUtils;


import java.util.HashMap;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class Graph extends ApplicationFrame {

   private String chartTitle;
   private HashMap<String,double[]> data;

   public Graph( String applicationTitle , String chartTitle ) {
      // initialize call the parent constructor ApplicationFrame
      super(applicationTitle);
      
      this.chartTitle = chartTitle;

      // initialize your hasmap
      this.data = new HashMap<String,double[]>();


   }

    /**
     * 
     * @param rowKey
     * @param dataArray
     */
   public void addData(String rowKey, double[] dataArray)
   {    
        this.data.put(rowKey, dataArray);
   }


   /**
    * 
    * @return
    */
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

      
        for(String rowKey: this.data.keySet())
        {
            double index = 0; // index for positioning the number
            // add the integers in your dataset
            for(double value : this.data.get(rowKey))
            {
                dataset.addValue(value, rowKey,Double.toString(index));
                index++;
            }
        }
  
        return dataset;
     }

   /**
    * 
    */
   public void plot()
   {
        JFreeChart lineChart = ChartFactory.createLineChart(
            this.chartTitle,
            "Angle",
            "Cosine / Sine Values",
            createDataset(),
            PlotOrientation.VERTICAL,
            true,false,false);
        
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
   }

}


public class Day18 
{
    private static final String PATH = "text_data/";
    /**
     * @return an return an array of integers from the start to the end with span 
     * between those numbers
     */
    private static int[] generateAngles(int start, int end, int span)
    {
        List<Integer> data = new ArrayList<Integer>();

        // generate the appropriate angle vakues

        for(int i = start; i <= end; i+=span)
        {
            data.add(i);
        }

        // from your list 'data' return an array of integers (int[])
        // https://www.geeksforgeeks.org/stream-in-java/
        // https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java

        return data.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args)
    {
 
        File directory = new File(PATH);

        // create directory if it does not exist

        if( !(directory.exists()))
        {
            directory.mkdir();
        }


        File file = new File(PATH + "Day18_data.txt");
        // creating the file if it does not exist
        if(!file.exists())
        {
            try
            {
                if(file.createNewFile())
                {
                    System.out.println("\nFile successfully created : "+file.getName());
                }
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        
        }
        else   // the file does not exist
        {
            System.out.println(
                    String.format("\nFile %s already exists.", file.getName())
                );
        }


        // writing and reading processes
        try
        {

            // get the values for your array
            int[] angleValues =  generateAngles(0, 360, 15);

            //System.out.println(Arrays.toString(angleValues));

            // Write inside the file
            FileWriter writer =  new FileWriter(file.getAbsolutePath());
            System.out.println("\n----------- WRITING ------------\n");

            writer.write("Angle\t\tCosine\t\tSine\n");
           
            for( int i : angleValues)
            {
                double cosine  = Math.cos( Math.toRadians(i));
                double sine = Math.sin( Math.toRadians(i));
                writer.write(
                    String.format("%d\t\t%f\t\t%f\n", i,cosine,sine )
                );
            }
  
            writer.close();

            Scanner sc = new Scanner(file); 

            System.out.println("\n----------- READING ------------\n");
            // read the content of the file
            // Info : check if a data exists in your array 
            // https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java

            List<Double> cosine = new ArrayList<Double>();

            while (sc.hasNextLine()) 
            {
                String[]  line =  sc.nextLine().split("\t");

                // check if the line contains "Angle"
                // meaning that is the first line
                if(Arrays.stream(line).anyMatch(x -> x.equals("Angle")))
                {   
                    
                    continue;
                    
                }
                else
                {
                    // remove the empty element in the array
                    line =  Arrays.stream(line).filter(x -> !StringUtils.isBlank(x)).toArray(String[]::new);

                    System.out.println(Arrays.toString(line));
                }
                    
            }
                

                
            
            sc.close();

            
            // Using the Chart Class from Day14.java
            // Make your files are in the same package
            // Package : https://www.w3schools.com/java/java_packages.asp 
            Graph line = new Graph("Data processing", "Sine and Cosine");

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
         

         System.out.println("End of program.");
 
    }
}