import java.util.LinkedList;
import java.util.Random;
import java.util.ListIterator;

/**
 * Nicolas de la Guardia
 * 500806448
 * Creates a class SalesTeam which makes a list of strings of names for sales people
 */
public class SalesTeam
{
    LinkedList<String> team = new LinkedList<>();

    public SalesTeam()
    {
        team.add("Shwin");
        team.add("Kablawi");
        team.add("Ambalandgoldeoe");
        team.add("Big Mo");
        team.add("Bikel");
        team.add("Pyret");
    }

    /**
     * gets a random person from the team list
     * @return a random sales person
     */
    public String randomSalesPerson()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(team.size());
        ListIterator<String> iter = team.listIterator();
        for (int i = 0; i < team.size(); i++)
        {
            String person = iter.next();
            if (i == randomNum)
            {
                return person;
            }
        } return null;
    }

    /**
     * prints all the sales people in list team
     * @return salesPerson
     */
    public String allSalesPeople()
    {
        ListIterator<String> iter = team.listIterator();
        String display = "";
        for (int i = 0; i < team.size(); i++)
        {
            String person = iter.next();
            display += person + ", ";
        }
        return display;
    }
    
   public static void main(String[] args)
    {

    }
}