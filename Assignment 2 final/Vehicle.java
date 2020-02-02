import java.util.Random;

/*
Nicolas de la Guardia 
500806448
 * Class Vehicle has the instance variables mfr (Manufacturer), color, power (GAS_ENGINE OR ELECTRIC_MOTOR)
*/
public class Vehicle 
{
/**
 * Introduces new Random object
 */
    Random rand = new Random();

/**
 * Initiates variables
 * @param mfr
 * @param color
 * @param power
 * @param ELECTRIC_MOTOR
 * @param GAS_ENGINE
 * @param VIN (Vehicle Identification Number)
 * 
**/
    private String mfr; // manufacturer
    private String color;
    private String power;
    private int VIN;
    final public int ELECTRIC_MOTOR = 0;
    final public int GAS_ENGINE = 1; // constants

/**
 * Constructor for Vehicle which takes the inputed parameters and associates them to the instance variables.
 * For VIN: creates number between 0-399 and adds 100 so it's between 100 and 499;
**/
    public Vehicle(String mfr, String color, String power)
    {
        this.mfr = mfr;
        this.color = color;
        this.power = power;
        this.VIN = rand.nextInt(400) + 100 ;
    }

    /**
     *  Compares 2 Vehicles to see if equal except color
     * @param otherObject used to compare object class inputed to the Vehicle class
     * @return false if there is no object
     * @return false if classes are not equal
     * @return true if mfr and power are equal, if not return false
    */

    public boolean equals(Object otherObject)
    {
        if(otherObject == null)
        {
            return false;
        }
        if (getClass() != otherObject.getClass())
        {
            return false;
        }
        Vehicle other = (Vehicle) otherObject;
        return this.mfr.equals(other.mfr)  &&  this.power == other.power ;
    }

    /**
     * @return car mfr and color in a string when called.
     */

    public String display()
    {
        return "VIN: " + this.VIN + " " + this.mfr + " " + this.color ;
    }

    /**
     * Getter for mfr
     * @return mfr
     */
    public String getMfr()
    {
        return mfr;
    }

    /**
     * Getter for color
     * @return color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Getter for power
     * @return power
     */
    public String getPower()
    {
        return power;
    }

    /**
     * Setter for mfr, returns nothing
     */
    public void setMfr(String mfr)
    {
        this.mfr = mfr ;
    }

    /**
     * Setter for color, returns nothing
     */
    public void setColor(String color)
    {
        this.color = color ;
    }

    /**
     * Setter for power, returns nothing
     */
    public void setPower(String power)
    {
        this.power = power;
    }

    public int getVIN()
    {
        return this.VIN;
    }
  public static void main(String[] args)
  {


  }
}
