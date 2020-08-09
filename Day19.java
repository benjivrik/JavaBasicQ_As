// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 19 : Mini Store : Employees, Items and the Store | Employees.
// Day 19 | IG : https://www.instagram.com/benjivrik/
// Subject : Mini Store : Employees, Items and the Store | Employees.
// ----------------------------------------------------
// what would be the output of this program ?

/**
 * Create an object Employee
 * Give your employee a name, an ID and a Salary
 * Give your employee to know if is working or not.
 */
class Employee
{
    private static int totalEmployee = 0;
    private String employeeName;
    private String employeeID;
    private double employeeSalary;
    private boolean isWorking;

    public Employee(String employeeName, double employeeSalary)
    {
        // increment the instance number
        this.totalEmployee++;
        // employee not working
        this.isWorking = false;
        // Assuming their ID will be their instance number (totalEmployee)
        this.employeeID = Integer.toString(this.totalEmployee);
        //
        this.employeeName =  employeeName;
        this.employeeSalary = employeeSalary;
    }
    // a function for the updating the status of the employee
    public void status()
    {
        if(isWorking)
        {
            isWorking = false;
            System.out.println(this.employeeName +" is no longer working.");
        }
        else
        {
            isWorking = true;
            System.out.println(this.employeeName +" is currently working.");
        }
            
    }
    // getters
    public String getName()
    {
        return this.employeeName;
    }

    public double getSalary()
    {
        return this.employeeSalary;
    }

    public String getID()
    {
        return this.employeeID;
    }
    // setters
    public void setName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public void setID(String employeeID)
    {
        this.employeeID = employeeID;
    }
    public void setSalary(double employeeSalary)
    {
        this.employeeSalary = employeeSalary;
    }

    // the number of employee created.
    public int getEmployeeNumber()
    {
        return this.totalEmployee++;
    }

    // for displaying your object
    public String toString()
    {
        String employee = String.format(
            "\nEmployee name : %s\nEmployee ID : %s\nEmployee Salary : %s CAD per hour\n",this.employeeName,this.employeeID,this.employeeSalary
            );
    
        return employee;
    }
}
public class Day19 
{
    public static void main(String[] args)
    {
        Employee emp =  new Employee("Jivrik",21.5);
        // display the employee info
        System.out.println(emp);
        // to create a delay of 2 seconds and see the effect of the employee
        try
        {
            emp.status();
            Thread.sleep(3000);
            emp.status();
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        System.out.printf("\nChanging the salary of %s\n", emp.getName());
        // change the salary of your employee using your setter
        emp.setSalary(22.5);
        // display the employee info
        System.out.println(emp);

        System.out.println("Creating a new Employee");
        // create a second object employee and display the number of existing employees
        emp = new Employee("Vrik",24);
        System.out.println(emp);

        // print the number of Employee's object created.

        System.out.printf("\nThe total number of existing employees is %d\n", emp.getEmployeeNumber());

        System.out.println("\nEnd of program.");

    }
}