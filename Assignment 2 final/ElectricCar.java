/**
 * Nicolas de la Guardia
 * 500806448
 * public class ElectricCar that extends to Car
 * @param rechargeTime
 * @param batteryType 
 */
public class ElectricCar extends Car
{
    private int rechargeTime; // minutes
    private String batteryType;

    /**
     * Initiates parameters of ElectricCar constructor into instance variables above, as well as previous instance variables that it inherits.
     */
    public ElectricCar(String mfr, String color, String model, String power, double safetyRating, int maxRange, String AWD, double price,
    int rechargeTime)// String batteryType)
    {
        super(mfr, color, model, power, safetyRating, maxRange, AWD, price);
        this.rechargeTime = rechargeTime;
       // this.batteryType = batteryType;
    }

    /**
     * getter for rechargeTime
     * @return rechargeTime 
     */
    public int getRechargeTime()
    {
        return this.rechargeTime;
    }
    
    /**
     * setter for rechargeTime
     * @param rechargeTime
     */
    public void setRechargeTime(int rechargeTime)
    {
         this.rechargeTime = rechargeTime;
    }

    /**
    public String getBatteryType()
    {
        return this.batteryType;
    }
    
    public void setBatteryType(String batteryType)
    {
         this.batteryType = batteryType;
    }
**/

/**
 * adds new instance variables for electric car onto Car display string
 * @return display string and recharge time.
 */
    public String display()
    {
        return super.display() + " EL, BAT: Lithium RCH: " + this.rechargeTime;
    }
    public static void main(String[] args)
    {
 

    }
}