import java.util.Random;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 * Nicolas de la Guardia
 * 500806448
 * @param ArrayList<Transaction> transList
 * @param Random rand
 */
public class AccountingSystem
{
    private ArrayList<Transaction> transList ;

    Random rand = new Random();
    
    public AccountingSystem()
    {
        transList= new ArrayList<Transaction>();
    }

    /**
     * makes random id from 1-100, creates a transaction and adds it to transList
     * @param date
     * @param car
     * @param salesPerson
     * @param type
     * @param salePrice
     * @return String from transaction.display()
     */
    public String add(GregorianCalendar date, Car car, String salesPerson,String type, double salePrice)
    {
        int id = rand.nextInt(99) + 1;
        Transaction transaction = new Transaction(id, date, car, salesPerson, type);
        transList.add(transaction);
        return transaction.display();
    }

    /**
     * getter for transaction of a specific car
     * @param car
     * @return transaction of that car
     */
    public Transaction getCarTransaction(Car car)
    {
        for (Transaction transaction : transList)
        {
            if (transaction.getCar() == car)
            {
                return transaction;
            }
        } return null;
    }

    /**
     * getter for transaction of a specific id
     * @param id
     * @return transaction or null if id is not found in list
     */
    public Transaction getTransaction(int id)
    {
        for (Transaction transaction : transList)
        {
            if (transaction.getId() == id)
            {
                return transaction;
            }
            
        } return null;
    }

    /**
     * getter for transList
     * @return transList
     */
    public ArrayList<Transaction> getTransList()
    {
        return transList;
    }

    /**
     * getter for salesPerson of a specific transaction
     * @param transaction
     * @return salesPerson
     */
    public String getSalesPerson(Transaction transaction)
    {
        return transaction.getSalesPerson();
    }

    /**
     * getter for a car of a specific transaction
     * @param transaction
     * @return Car
     */
    public Car getCar(Transaction transaction)
    {
        return transaction.getCar();
    }

    /**
     * getter for salePrice of a specific transaction
     * @param transaction
     * @return salePrice
     */
    public double getSalePrice(Transaction transaction)
    {
        return transaction.getSalePrice();
    }

    public static void main(String[] args)
    {

    }
}