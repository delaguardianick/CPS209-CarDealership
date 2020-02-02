/**
 * Nicolas de la Guardia
 * 500806448
 *  New class Car which extends to Vehicle and implements the Comparable interface
 * @param model
 * @param maxRange
 * @param safetyRating
 * @param AWD
 * @param price
 * 
*/
public class Car extends Vehicle implements Comparable<Car>
{
    private String model;
    private int maxRange;
    private double safetyRating;
    private boolean AWD; //all wheel drive
    private double price;
/**
 * Constructor for Car which initiates all instance variables above with the given parameters
 * @param AWD is initiated as boolean and parameter is String, so a temporary variable is needed to change the input type. 
 */  
    public Car(String mfr, String color, String model, String power, double safetyRating, int maxRange, String AWD, double price)
    {
        super(mfr, color, power);
        this.model = model;
        this.maxRange = maxRange;
        this.safetyRating = safetyRating;
        this.price = price;
        boolean tempAWD;
        if(AWD.equals("AWD"))
        {
            tempAWD = true;
        }
           else {tempAWD = false;}
        this.AWD = tempAWD;
    }

    /**
     *  Adds Car instance variables to previous display in vehicle with some strings for output clarity.
     *  @return display string with new variables
    */ 
    public String display()
    {
        return super.display() + " " + model + " " + price + "$ " + "SF: " + safetyRating + " RNG: " + maxRange;
    }
    
    /**
     *  Compare two objects by model and AWD to see if equal
     * @return false if not equal
    */
    public boolean equals(Object otherObject)
    {
        if (super.equals(otherObject))
        {
            Car other = (Car) otherObject;
            return (this.model == other.model) && (this.AWD == other.AWD);
        }
        return false;
    }
    /**
     * compareTo() for the comparable interface
     * @return 1 or -1 for different prices and 0 for equality
     */
    public int compareTo(Car otherObject)
    {
        Car other = (Car) otherObject;
        if (this.price > other.price)
        { return 1; }
        if (this.price < other.price)
        { return -1; }
        else {return 0;}
    }

    /**
     * getter for maxRange
     * @return maxRange
     */
    
    public int getMaxRange()
    {
        return this.maxRange;
    }
    /**
     * getter for model
     * @return model
     */
    public String getModel()
    {
        return this.model;
    }

    /**
     * getter for safetyRating
     * @return safetyRating
     */
    public double getSafetyRating()
    {
        return this.safetyRating;
    }

    /**
     * getter for AWD
     * @return AWD
     */
    public boolean getAWD()
    {
        return this.AWD;
    }
/**
 * getter for price
 * @return price
 */
    public double getPrice()
    {
        return this.price;
    }

    public static void main(String[] args)
     {

}}