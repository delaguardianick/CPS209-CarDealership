import java.util.ArrayList;
import java.util.Collections;

/**
 * Nicolas de la Guardia
 * 500806448
 * new class for CarDealership
 * @param bought
 * @param arraylist cars 
 * @param arraylist carsCopy
 */

public class CarDealership
{
    private Car bought;

    private ArrayList<Car> cars;
    private ArrayList<Car> carsCopy;

    /**
     * Constructor for CarDealership
     * initiates cars and carsCopy with empty array of type object Car
     */
    public CarDealership()
    {
        cars = new ArrayList<Car>();
        carsCopy = new ArrayList<Car>();
        bought = null;
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
     * Removes a car from the list and returns it if index is not negative or over array length
     * @return bought with the car removed if index is within conditions
     * @param index
     */
    
    public Car buyCar(int index)
    {
        if (index < cars.size() && index >= 0)
        {
            bought = cars.get(index);
            cars.remove(index);
            return bought;
        }
        return null;
    }

    /**
     * adds the car bought with buyCar() to the list again, if car is already in list, null
     * @param car
     */
    public void returnCar(Car car)
    {
        if (car != null)
        {
            if (cars.contains(bought) == false)
                 {cars.add(car);}
        }
    }

    /**
     * for every car in list cars, displays inventory and adds an index in front of every car
     * @param index
     * @param car
     */
    public void displayInventory()
    {
        int index = 0;
        for (Car car : cars)
        {
            System.out.println(index + " " + car.display());
            index ++;
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

    /**
     * getter for bought variable
     * @return bought
     */
    public Car getBought()
    {
        return bought;
    }
    public static void main(String[] args)
    {
  
  
    }
}