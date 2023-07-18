// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 26 : User 
// Day 26 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?
import java.time.LocalDate;

class User
{
    private String firstName;
    private String lastName;
    private String category;
    private LocalDate dateOfBirth;
    private int id;
    private static int userID = 0;

    public User()
    {
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = null;
        this.category = "";
        this.id = ++this.userID;
    }
    public User(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.category = null;
        this.dateOfBirth = null;
        this.id = ++this.userID;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return this.category;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public int getUserID()
    {
        return this.id;
    }
    /**
     * 
     * @param year
     * @param month
     * @param day
     */
    public void setDateOfBirth(int year, int month, int day)
    {
        this.dateOfBirth = LocalDate.of(year,month,day);
    }

    public String toString()
    {

        System.out.println("\n************** DISPLAYING USER INFO **************\n");

        String user = "";

        user +="\nUser first-name :" + this.firstName+"\n";
        user +="User last-name :" + this.lastName+"\n";
        user +="User category :"+ this.category+"\n";
        user +="User date of birth : " + this.dateOfBirth +"\n";
        user +="User ID : " + this.id +"\n";


        return user;
    }
}
public class Day26 
{
    public static void main(String[] args)
    {
        User user = new User();
        // setting data for the user
        user.setFirstName("Donald");
        user.setLastName("Vrik");
        user.setCategory("Teacher");
        user.setDateOfBirth(1987, 04, 14);

        // print your user data
        System.out.println(user);

        // Empty user
        user  = new User();
        System.out.println(user);

    }
} 