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
    private LocalDate dateOfBirth;
    private int id;
    private static int userID = 0;

    public User()
    {
        this.firstName = null;
        this.lastName = null;
        this.dateOfBirth = null;
        this.id = ++this.userID;
    }
    public User(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName  = lastName;
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

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
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
}
public class Day26 
{
    public static void main(String[] args)
    {
        User user = new User();
    }
}