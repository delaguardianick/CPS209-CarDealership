import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map;

/**
 * Nicolas de la Guardia
 * 500806448
 * new class for CarDealership
 * @param bought
 * @param arraylist cars 
 * @param arraylist carsCopy
 * @param salesTeam
 * @param accountingSystem
 * @param rand
 * @param randMonth
 */

public class CarDealership
{
    private ArrayList<Car> cars;
    private ArrayList<Car> carsCopy;
    SalesTeam salesTeam = new SalesTeam();
    AccountingSystem accountingSystem = new AccountingSystem();
    Random rand = new Random();
    Car lastBought ;
    int randMonth;

    /**
     * Constructor for CarDealership
     * initiates cars and carsCopy with empty array of type object Car
     */

    public CarDealership()
    {
        cars = new ArrayList<Car>();
        carsCopy = new ArrayList<Car>();
    }

    //Adds cars in CarDealershipSimulator.java to cars and carsCopy
    public void addCars(ArrayList<Car> newCars)
    {
        cars.clear();
        carsCopy.clear();
        carsCopy.addAll(newCars);
        cars.addAll(newCars);
    }
    
    /**
     * checks if parameter VIN matches with the VIN of any of the transactions in the transList.
     * if so, remove the car from list, generate a random salesPerson from salesTeam list and add the parameters to AccountingSystem.add
     * this will return a string as Transaction.display() is being used inside .add().
     * if the VIN does not match, returns error string;
     * also stores the car removed in an instance variable in the class to be accessed later.
     * @param VIN
     * @return
     */
    
    public String buyCar(int VIN)
    {
        randMonth = rand.nextInt(12) + 1;
        int randDay = rand.nextInt(23) + 1;
        GregorianCalendar date = new GregorianCalendar(2019, randMonth, randDay);
        for (Car car : cars)
        {
            if (car.getVIN() == VIN)
            {
                lastBought = car;
            }
        }
        if (cars.contains(lastBought))
        {
            cars.remove(lastBought);
            String salesPerson = salesTeam.randomSalesPerson();
            return accountingSystem.add(date, lastBought, salesPerson, "BUY", lastBought.getPrice());
        }
        else 
        {
            return "Car not available";
        }
    }

    /**
     * gets the transaction of the lastBought car and checks if the cars list contains it
     * if not, it adds the car to the list again, makes a new return transaction in transList and returns the transaction.display() string
     * if car is already in list print error message
     */
    public void returnCar()
    {
        Transaction transaction = accountingSystem.getCarTransaction(lastBought);
        int randDay = rand.nextInt(7) + 23;
        GregorianCalendar date = new GregorianCalendar(2019, randMonth, randDay);
        if (cars.contains(transaction.getCar()) == false)
        {
            cars.add(transaction.getCar());
            String transDisplay = accountingSystem.add(date, transaction.getCar(), transaction.getSalesPerson(), "RET", transaction.getSalePrice());
            System.out.println(transDisplay + "\n");
            
        }
        else {System.out.println("Sorry, the car is already in the list");}
    }
     
    /**
     * prints the size of transactionList, helpful for debugging
     * @return int of transList.size()
     */
    public int listSize()
    {
        ArrayList<Transaction> transList = accountingSystem.getTransList();
        return transList.size();
    }

    /**
     * gets transList from accounting System and loops through it adding the transaction display to a String list.
     * @return list 
     */
    public String allSales()
    {
        ArrayList<Transaction> transList = accountingSystem.getTransList();
        String list = "";
        for (Transaction transaction : transList)
        {
            list += (transaction.display() + "\n") ;
        }
        return list;
    }

    /**
     * gets transList and loops through it, if the parameter month (int) matches the month of the transaction, 
     * it adds the display of that transaction to a list
     * if not, it skips it
     * @param month
     * @return list
     */
    public String getSalesOnMonth(int month)
    {
        ArrayList<Transaction> transList = accountingSystem.getTransList();
        String list = "";
        for (Transaction transaction : transList)
        {
            if (transaction.getMonth() == month)
            {
                list += (transaction.display() + "\n");
            }
        } return list;
    }

    /**
     * creates new map
     * gets transList from accountingSystem
     * loops through the transactions in transList and counts how many times the same key (salesPerson) appears.
     * at the end it looks for equal values for keys, meaning some salesPeople would have had the same number of sales.
     * and prints both if equal
     * @return result
     */
    public String topSP()
    {
        Map<String,Integer> map = new TreeMap<String,Integer>();
        ArrayList<Transaction> transList = accountingSystem.getTransList();
        String result = "";
        int maxSales = 0;
        for (Transaction transaction : transList)
        {
            String salesPerson = transaction.getSalesPerson();
            if (map.containsKey(salesPerson))
            {
                int oldValue = map.get(salesPerson);
                map.replace(salesPerson, oldValue, oldValue + 1);
                if (map.get(salesPerson) > maxSales)
                {
                    maxSales = map.get(salesPerson);
                }   
            }
            else
            {
                map.put(salesPerson, 1);
            }
            result = salesPerson + " : " + map.get(salesPerson);
        }
        return result;
        
    }
    
    /**
     * gets transList and loops through it
     * checks the transactionType and counts individually for "BUY" and "RET"
     * also gets the price for every transaction and adds it to totalProfit
     * then divides totalProfit by 12 to get the averageProfitPerMonth
     * then gets the month with most sales from maxMonth.
     * all these are added to a String result
     * @return result
     */
    public String salesStats()
    {
        ArrayList<Transaction> transList = accountingSystem.getTransList();
        String result = "";
        int totalBuys = 0;
        int totalRets = 0;
        double totalProfit = 0;
        for (Transaction transaction : transList)
        {
            if (transaction.getType() == "BUY")
            {
                totalBuys ++;
            }
            else if (transaction.getType() == "RET")
            {
                totalRets ++;
            }
            totalProfit += transaction.getSalePrice();
            
        }
        double averageProfitPerMonth = totalProfit/12;
        averageProfitPerMonth = (double)Math.round(averageProfitPerMonth * 100d) / 100d;
        result += ("Total Sales: $" + totalProfit + "\n");
        result += ("Average sales per month: $" + averageProfitPerMonth + "\n");
        result += ("Total number of cars sold: "  + totalBuys + "\n");
        result += ("Highest sales month: "+ maxMonth(transList) + "\n");
        result += ("Total car returns: " + totalRets);
        return result;
    } 
    
    /**
     * takes in a transList and loops through it
     * gets the month of the transaction and maps it with the number of ocurrences
     * then returs the most frequent month in transaction
     * the if statement at the bottom associates the int month with a string of the month name
     * @param transList
     * @return
     */
    public String maxMonth(ArrayList<Transaction> transList)
    {
        Map<Integer,Integer> map = new TreeMap<>();
        int maxSales = 0;
        int maxMonth = 0;
        for (Transaction transaction : transList)
        {
            int month = transaction.getMonth();
            if (map.containsKey(month))
            {
                int oldValue = map.get(month);
                map.replace(month, oldValue, oldValue + 1);
                if (map.get(month) > maxSales)
                {
                    maxSales = map.get(month);
                    maxMonth = month;
                }
            }
            else
            {
                map.put(month,0);
            }
        }
        if (maxMonth == 0)
        { return "January"; }
        else if (maxMonth == 1)
        { return "February"; }
        else if (maxMonth == 2)
        { return "March"; }
        else if (maxMonth == 3)
        { return "April"; }
        else if (maxMonth == 4)
        { return "May"; }
        else if (maxMonth == 5)
        { return "June"; }
        else if (maxMonth == 6)
        { return "July"; }
        else if (maxMonth == 7)
        { return "August"; }
        else if (maxMonth == 8)
        { return "September"; }
        else if (maxMonth == 9)
        { return "October"; }
        else if (maxMonth == 10)
        { return "November"; }
        else{ return "December"; }
    }
    
    /**
     * for every car in list cars, displays inventory and adds an index in front of every car
     * @param index
     * @param car
     */
    public void displayInventory()
    {
        for (Car car : cars)
        {
            System.out.println( /* + vehicle.VIN */  " " + car.display());
        }
    }

    /**
     * @param car
     * if power for car is equal to GAS_ENGINE, remove from array. This will leave only gas cars remaining
     */
    public void filterByElectric()
    {
        cars.removeIf((Car car) -> (car.getPower() == "GAS_ENGINE"));
    }

    /**
     * @param car
     * if AWD for car is false, remove car from array. This will leave only non AWD cars remaining
     */
    public void filterByAWD()
    {
        cars.removeIf((Car car) -> (!car.getAWD()));
    }

    /**
     * @param minPrice
     * @param maxPrice
     * @param car
     * if the price of the car is larger than maxPrice: remove car
     * if the price of the car is smaller than minPrice: remove car
     */
    public void filterByPrice(double minPrice, double maxPrice)
    {
        cars.removeIf((Car car) -> (car.getPrice() > maxPrice || car.getPrice() < minPrice));
    }

    /**
     * adds all the items in the carsCopy array into the array cars. This resets the array to the initial order.
     */
    public void filtersClear()
    {
        cars.clear();
        cars.addAll(carsCopy);
    }

    /**
     * sorts array cars by price, uses compareTo() method in Car.
     */
    public void sortByPrice()
    {
        Collections.sort(cars);
    }

    /**
     * sorts array by safetyRating using sortBySafetyRating.java file and collection method as above
     */
    public void sortBySatefyRating()
    {
        Collections.sort(cars, new sortBySafetyRating());
    }

    /**
     * sorts array by maxRange using sortBymaxRange.java file and collection method as above
     */
    public void sortByMaxRange()
    {
        Collections.sort(cars, new sortByMaxRange());
    }
    public static void main(String[] args)
    {
  
  
    }
}