// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 13 : Challenge Module - Jfreechart
// Day 13 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

// https://www.tutorialspoint.com/jfreechart/jfreechart_line_chart.htm reference
// http://www.jfree.org/jfreechart/download/
// http://www.jfree.org/jfreechart/api/javadoc/overview-summary.html

import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class LineChart extends ApplicationFrame {

   public LineChart( String applicationTitle , String chartTitle ) {
      // initialize call the parent constructor ApplicationFrame
      super(applicationTitle);
      /**
       *    http://www.jfree.org/jfreechart/api/javadoc/org/jfree/chart/ChartFactory.html
       * 	createLineChart(
       *       String title, 
       *       String categoryAxisLabel, 
       *       String valueAxisLabel, 
       *       CategoryDataset dataset, 
       *       PlotOrientation orientation, 
       *       boolean legend,          
       *       boolean tooltips, 
       *       boolean urls)
       */
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Integer ID",
         "Integer Value",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,false,false);
      
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }
   
   //  initialize a function that return the dataset needed for the chart data
   //  Using the DefaultCategoryDataset
   //  http://www.jfree.org/jfreechart/api/javadoc/org/jfree/data/category/DefaultCategoryDataset.html
   /**
    * 
    * public void addValue(Number value,
                     Comparable rowKey,
                     Comparable columnKey)

     Adds a value to the table. 
     value - the value.           
     rowKey - the row key.         
     columnKey - the column key.  


    */
   
   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

      // You can create more than one data set for your line chart
      // let's create a line chart for five integer going from 5 to 15
      String rowKey = "integers-first";
      Random rand = new Random();
      // initialize value for the dataset
      // for the XY data you will have x =  i and y = rand.randInt()
      for(int i =0; i < 5 ;i++)
      {
         dataset.addValue(rand.nextInt(11)+5, rowKey, Integer.toString(i));
      }

       // let's create a second line chart for five integer going from 10 to 20
       rowKey = "integers-second";
       // initialize value for the dataset
       for(int i =0; i < 5 ;i++)
       {
          dataset.addValue(rand.nextInt(11)+10, rowKey, Integer.toString(i));
       }
       

      return dataset;
   }
}
public class Day13 
{
    public static void main(String[] args)
    {
        LineChart chart = new LineChart(
         "Integer generated" ,
         "Random integers vs Their IDs");

        chart.pack();
        RefineryUtilities.centerFrameOnScreen( chart );  // center your frame in your screen
        chart.setVisible( true );
    }
}