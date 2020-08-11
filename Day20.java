// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 20 : Mini Store : Employees, Items and the Store | item.
// Day 20 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?


/**
 * 
 * Create an Item for your store. 
 * Give a name, a category, a price 
 * For the category : let's say we mean vegetables, fruits,etc. 
 * 
 */
class Item
{
    public String name;
    public String category;
    public double price;
    
    
    public Item(String name, String category, double price)
    {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getters
    public String getItemName()
    {
        return this.name;
    }

    public String getItemCategory()
    {
        return this.category;
    }

    public double getPrice()
    {
        return this.price;
    }

    // setters
    public void setItemName(String name)
    {
        this.name  = name;
    }

    public void setItemCategory(String category)
    {
        this.category = category;
    }

    public void setItemPrice(double price)
    {
        this.price = price;
    }

    // for displaying your object
    public String toString()
    {
        System.out.println("\n************** DISPLAYING ITEM INFO **************\n");

        String employee = String.format(
            "\nItem name : %s\nItem category : %s\nItem price : %s CAD \n",this.name,this.category,this.price
            );
    
        return employee;
    }

}
public class Day20 
{
    public static void main(String[] args)
    {

        Item banana = new Item("Banana","Fruits", 12.5);
        Item carrot = new Item("Carrot","Vegetables", 10);

        // display your items in your terminal
        System.out.println(banana);
        System.out.println(carrot);

        System.out.println("Changing the price of the items.");
        // change the price of your first item to 15 and the second item to 13
        banana.setItemPrice(15);
        carrot.setItemPrice(13);

        // display your items in your terminal
        System.out.println(banana);
        System.out.println(carrot);

    }
}