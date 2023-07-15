// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 16 : Web scraping with java 
// Day 16 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

// reference : https://medium.com/hackernoon/introduction-to-web-scraping-with-java-3d8a8d0f250b


import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;


@SuppressWarnings("unchecked")
public class Day16 {
    public static void main(String[] args)
    {
        //initialize the url of the website you want to visit
        String baseUrl = "https://www.stuntbusiness.ca/fr/legal/terms-and-conditions" ;
        
        // WebClient :  The main starting point in HtmlUnit: this class simulates a web browser.
        // https://htmlunit.sourceforge.io/apidocs/com/gargoylesoftware/htmlunit/WebClient.html
        WebClient client = new WebClient();

        // deactivate css and javascript
        client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
        
        // Start parsing your page
		try {
            // get your html page
			HtmlPage page = client.getPage(baseUrl);
            
            // Get all the html element h4 with class="title-in-content"
            List<HtmlElement> items = (List<HtmlElement>) (Object) page.getByXPath("//h4[@class='title-in-content']") ;
            
            if(items.isEmpty())
            {
				System.out.println("Nothing found with your request.");
            }else{
                // print all the elements collected
                int index = 0;

                // print the h4 found.
				for(HtmlElement htmlItem : items){
                    System.out.println( "> " + (index++) + ":\n" + htmlItem.asXml());
				}
            }
        
        // close your web client
        client.close();

		} catch(Exception e){
			e.printStackTrace();
        }
        
        System.out.println("End of program.");

    }
    
}