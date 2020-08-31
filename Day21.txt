// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 21 : Mini Store : Employees, Items and the Store | Store.
// Day 21 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;

class Store {

    private String name;
    private String address;
    private List<Item> items;
    private HashMap<String, Integer> itemStocks;
    private List<Employee> employees;

    public Store(String name)
    {
        this.name = name;
        this.items = new ArrayList<Item>();
        this.employees = new ArrayList<Employee>();
        this.itemStocks = new HashMap<String,Integer>();
        this.address = "";
    }

    // name
    public String getStoreName()
    {
        return this.name;
    }

    public void setStoreName(String name)
    {
        this.name = name;
    }

    // address
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return this.address;
    }
    // get Employees
    public List<Employee> getEmployees()
    {
        return this.employees;
    }
    // add employees 
    public void addEmployee(Employee employee)
    {
        this.employees.add(employee);
    }

    // remove employees
    public void removeEmployee(Employee employee)
    {
        this.employees.remove(employee);
    }

    // In case the parameter is the employee name
    // Supposing the employee names are always unique
    public void removeEmployee(String employeeName)
    {
        for(Employee employee : this.employees)
        {
            if(employee.getName().equals(employeeName)) 
            {
                this.employees.remove(employee);

                System.out.println("Employee '"+employeeName+"' with salary '"+employee.getSalary()+" CAD' has been removed");

                break; 
            }
               
        }
        
    }

    // get all items
    public List<Item> getItems()
    {
        return this.items;
    }

    // add item
    public void addItem(Item item, int inStock)
    {
        this.items.add(item);
        this.itemStocks.put(item.getItemName(),inStock);
    }
    
    // get inventory
    public HashMap<String,Integer> getStoreInventory()
    {
        return this.itemStocks;
    }

    // remove item | supposing the item always exists in the store before removing
    public void removeItem(Item item)
    {

        if(this.itemStocks.containsKey(item.getItemName()))
        {
            this.items.remove(item);
            this.itemStocks.remove(item.getItemName());
        }
        else throw new NullPointerException("Sorry, The element "+ item.getItemName() + " does not exist in the store.");
            
    }
    // sell an item : just decrease the quantity in the store
    public void sell(Item item, int quantity)
    {

        if(this.itemStocks.containsKey(item.getItemName()))
        {
            int inStock = this.itemStocks.get(item.getItemName());

           
            // you should catch all the possibility
            // assuming that quantity is always less than the value of inStock
            
            if(inStock == 0)
            {
                System.out.println("The item "+ item.getItemName() + " is sold out.");
            }
            else
            {
                this.itemStocks.put(item.getItemName(), inStock - quantity);
                System.out.println("\n> Item(s) '"+item.getItemName()+"' sold.");
            }
                
        }
        else throw new NullPointerException("Sorry, The element "+ item.getItemName() + " does not exist in the store.");
            
    }


    public String toString()
    {
        System.out.println("\n************** DISPLAYING STORE INFO **************\n");

        String store = "";

        store += "\n> Your store "+ this.name + " have " + this.employees.size() + " employee(s).\n";

        store += "\nYour store have the following items:\n";

        if(this.items.size() == 0)
        {
            store += "\n>>> You do not have any item in your store.\nPlease add some. <<<";
        }
        else
        {
            for(String itemName :  this.itemStocks.keySet())
            {
                Item  item = findItemByName(itemName);
    
                if(item != null)
    
                   store += "\n> "+itemName+ ": " + item.getPrice() + " CAD | " + this.itemStocks.get(itemName) + " left in the Store\n"; 
    
                else // Just be sure that item really exists in the store.  Throwing this exception for letting you know
                   throw new NullPointerException("No items with the name '" + itemName + "' were found.");
            }
        }

        return store;
    }

    // Used in toString
    // Find the item is the store list of items using its name
    private Item findItemByName(String itemName)
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
}
public class Day21 {
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

       // display the information about your store.

       System.out.println(store);


       System.out.println("\n>>>> Selling 2 TVs in the store <<<<\n");
       
       // selling 2 TVs
       store.sell(tv,2);


       // display the information about your store.

       System.out.println(store);


    }
}