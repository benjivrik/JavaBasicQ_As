// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 22 : Mini Store | Customer.
// Day 22 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

class Customer
{
    private Store store;
    private String name;
    private double bugdet;
    private HashMap<String,Double> cart;

    public Customer(String name, double budget)
    {
        this.store = null; // the store value is set using setStore()
        this.name = name;
        this.bugdet = budget;
        this.cart = new HashMap<String,Double>();
    }

    // set the store of the customer
    public void setStore(Store store)
    {
        this.store = store;

    }

    // Customer name
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name =  name;
    }

    // add item to cart
    // Assuming the item always exists in the store
    public void addToCart(String itemName)
    {
        if (this.store == null)
            throw new NullPointerException("A store has not been set for the customer " + this.name + ".");
        // get the list of items from the store
        List<Item> items = this.store.getItems();

        // find the items
        Item item = findItemByName(items, itemName);

        if (item  ==  null) 
            throw new NullPointerException("Item '" +itemName+"' not found in the store.");

        // add to the cart
        this.cart.put(item.getItemName(), item.getPrice());
    }
    // remove item from cart
    public void removeFromCart(String itemName)
    {
        if(this.cart.containsKey(itemName))
        {
            this.cart.remove(itemName);
        }
        else
            throw new NoSuchElementException("Item '" +itemName+"' not found in your cart.");
    }
    // Utility - find item by name
    private Item findItemByName(List<Item> items, String itemName)
    {
        for(Item item : items)
        {
            if(item.getItemName().equals(itemName))
            {
                return item;
            }
        }

        System.out.println("\nItem not found.\n");

        return null;
    }


    // calculate the bill of the curstomer
    public boolean calculateBill()
    {
        boolean canPay = false; // if the customer has enough money for proceeding with the payment
        double bill = 0;
        for(String item : cart.keySet())
        {
            bill += cart.get(item);
        }

        if(bill > this.bugdet)
        {
            System.out.println("\nYour bill is "+ bill + " CAD.\n");
            System.out.println("However, " + this.bugdet + " CAD is your budget.\nYou might want to remove some items.\n");
        
        }
        else 
        {
            System.out.println("\n> Your bill is "+ bill + " CAD.\n");
            System.out.println("\n> Your budget is "+ this.bugdet + " CAD.\n");
            // bill <= this.budget
            System.out.println("\nYou are good to go. You have enough money.\n"); 
            canPay = true;
        }

        return canPay;
    }

    // customer buying items and changing the store content
    // Assumption : Supposing the customer is only adding one item for each product in the store
    // i.e the user is not buying two TVs at the same time
    public void buy()
    {

        // get the list of items from the store
        List<Item> items = this.store.getItems();

        if(this.calculateBill())
        {
            for(String itemName : cart.keySet())
            {
                // find the items
                Item item = findItemByName(items, itemName);
                // decrease the stock of the item in the store
                int quantity = 1; // this value will be always be 1 based on the assumption made
                // update item in the store
                this.store.sell(item, quantity);
                // decrease the customer budget
                this.bugdet -= cart.get(itemName);
            }
            // empty the cart
            this.cart.clear();
        }
        else
        {
            System.out.println("\nPlease remove some items before processing with the checkout.\n");
        }
    }

    // display customer information
    // Assuming the customer can only take one entity for each Item
    public String toString()
    {
        System.out.println("\n************** DISPLAYING CUSTOMER INFO **************\n");
        String customer = "";
        customer += "\n> Customer name : "+this.name+".\n"+"> Customer budget : "+this.bugdet+" CAD.\n";

        // get the list of items from the store
        List<Item> items = this.store.getItems();
        
        if(this.cart.size() == 0)
           customer += "\nYou do not have any item in your cart.\n";
        else
        {
            customer += "\nYour cart has the following items.\n";

            for(String itemName :  this.cart.keySet())
            {
                Item  item = findItemByName(items,itemName);

                if(item != null)

                    customer += "\n> "+itemName+ ": " + item.getPrice() + " CAD (Unit Price)\n"; 

                else // Just be sure that item really exists in the store.  Throwing this exception for letting you know
                    throw new NullPointerException("No items with the name '" + itemName + "' were found.");
            }
        }
        
        return customer;
    }

}
public class Day22 {

    public static void main(String[] args)
    {
        Store store = new Store("Stunt-Business");

        Item computer = new Item("laptop", "computer", 200);
        Item tv =  new Item("TV", "computer", 1200);
 
        // display the information about your store
        System.out.println(store);
 
        System.out.println("\n>>>> Adding items in the store <<<<\n");
 
        // adding five laptops to the store
        store.addItem(computer, 5);
 
        // add ten Tvs in the store
        store.addItem(tv,10);

        // display the information about your store
        System.out.println(store);

        // create a customer
        Customer customer = new Customer("Jivrik", 4000);
        // set the store the customer
        customer.setStore(store);

        // add laptop to cart
        customer.addToCart("laptop");

        // add laptop to the cart
        customer.addToCart("TV");

        // display customer info
        System.out.println(customer);

        // buy your items
        customer.buy();

        // display customer info
        System.out.println(customer);

        // display the information about your store
        System.out.println(store);

    }
    
}