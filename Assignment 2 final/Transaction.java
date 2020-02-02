import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
Nicolas de la Guardia 
500806448
 * @param id
 * @param date
 * @param salesPerson
 * @param transactionType
 * @param salePrice
 * @param car
 * @param date1
*/
public class Transaction
{
    private int id;
    private GregorianCalendar date; 
    //private referene to Car object
    private String salesPerson;
    private String transactionType;
    private double salePrice;
    private Car car;
    private String date1;

    /**
     * @param id
     * @param date
     * @param car
     * @param salesPerson
     * @param transactionType
     * Initializes all the variables and associates salePrice to the price in class Car.
     */
    public Transaction(int id, GregorianCalendar date, Car car, String salesPerson, String transactionType)
    {
        this.id = id;
        this.salesPerson = salesPerson;
        this.transactionType = transactionType;
        this.date = date;  
        this.salePrice = car.getPrice();
        this.car = car;
    }

    /**
     * @return string display, changes date from GregorianCalendar to string to be displayed.
     */
    public String display()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
        date1 = sdf.format(date.getTime());
        return "ID: " + id + " "  + date1 + " "  + transactionType + " SalesPerson: " +  salesPerson + " : " + car.display(); 
    }
   
    /**
     * getter for salesPerson
     * @return String salesPerson
     */
    public String getSalesPerson()
    {
        return this.salesPerson;
    }

    /**
     * getter for date
     * @return GregorianCalendar date
     */
    public GregorianCalendar getDate()
    {
        return this.date;
    }

    /**
     * getter for month inside date
     * @return int month (0=JAN, 11=DEC)
     */
    public int getMonth()
    {
        GregorianCalendar date = getDate();
        return date.get(Calendar.MONTH);
    }
    
    /**
     * getter for Type
     * @return String transactionType
     */
    public String getType()
    {
        return this.transactionType;
    }

    /**
     * getter for salePrice
     * @return double salePrice
     */
    public double getSalePrice()
    {
        return this.salePrice;
    }

    /**
     * getter for id
     * @return int ID
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * getter for car
     * @return Car car
     */
    public Car getCar()
    {
        return this.car;
    }

    public static void main(String[] args)
    {
  
  
    }
}