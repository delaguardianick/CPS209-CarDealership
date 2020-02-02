import java.util.ArrayList;
import java.util.Scanner;

/**
 * Nicolas de la Guardia
 * 500806448
 * new class for CarDealershipSimulator
 */
public class CarDealershipSimulator 
{
  public static void main(String[] args)
  {
	  // Create a CarDealership object
				CarDealership dealership = new CarDealership();
				
	  // Then create an (initially empty) array list of type Car
      // Then create some new car objects of different types
	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	  
		
			ArrayList<Car> cars1 = new ArrayList<Car>();

		Car newCar0 = new Car("Toyota", "blue","SEDAN", "GAS_ENGINE", 9.5 , 500 , "2WD", 25000);
		Car newCar1 = new Car("Honda", "red", "SPORTS", "GAS_ENGINE", 9.2, 450, "2WD", 30000);
		Car newCar2 = new Car ("Kia", "white", "MINIVAN", "GAS_ENGINE", 9.7, 550, "2WD", 20000);
		Car newCar3 = new Car ("BMW", "black", "SEDAN", "GAS_ENGINE", 9.6, 600, "AWD", 55000);
		ElectricCar newCar4 = new ElectricCar ("Tesla", "red", "SEDAN", "ELECTRIC_MOTOR", 9.1, 425, "AWD", 85000, 30);
		Car newCar5 = new Car ("Chevy", "red", "MINIVAN", "GAS_ENGINE", 9.25, 475, "2WD", 40000);
		ElectricCar newCar6 = new ElectricCar ("ChevyVolt", "green", "SEDAN", "ELECTRIC_MOTOR", 8.9, 375, "AWD", 37000, 45);
		Car newCar7 = new Car ("Bentley", "black", "SEDAN", "GAS_ENGINE", 9.8, 575, "2WD", 150000);
		ElectricCar newCar8 = new ElectricCar ("NissanLeaf", "green", "SEDAN", "ELECTRIC_MOTOR", 8.8, 325, "AWD", 32000, 55);

		cars1.add(newCar0);
		cars1.add(newCar1);
		cars1.add(newCar2);
		cars1.add(newCar3);
		cars1.add(newCar4);
		cars1.add(newCar5);
		cars1.add(newCar6);
		cars1.add(newCar7);
		cars1.add(newCar8); 

		Scanner scan = new Scanner(System.in);
		// while the scanner has another line
		while(scan.hasNextLine())
		{
			//    read the input line
			String line = scan.nextLine();

		
		//    create another scanner object (call it "commandLine" or something) using the input line instead of System.in
		//    read the next word from the commandLine scanner 
    //	check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object  

		Scanner commandLine = new Scanner(line);
		if(commandLine.hasNext()){
			String command = commandLine.next();

			if (command.equals("L"))
			{
				dealership.displayInventory();
			}
			else if(command.equals("BUY"))
			{
				int number = commandLine.nextInt();
				Car carBought = dealership.buyCar(number);
				if (number < cars1.size())
				{
					System.out.println(carBought.display());
				}	
			}	
			else if(command.equals("RET"))
			{
				dealership.returnCar(dealership.getBought());
			}
			else if(command.equals("ADD"))
			{
				dealership.addCars(cars1);
			}
			else if(command.equals("SPR"))
			{
				dealership.sortByPrice();
			}
			else if(command.equals("SSR"))
			{
				dealership.sortBySatefyRating();
			}
			else if(command.equals("SMR"))
			{
				dealership.sortByMaxRange();
			}
			else if(command.equals("FPR"))
			{
				if (commandLine.hasNextDouble());
				{		double maxPrice;
						double minPrice = commandLine.nextDouble();
						if (commandLine.hasNextDouble())
						{
							maxPrice = commandLine.nextDouble();
							dealership.filterByPrice(minPrice, maxPrice);
						}
						
				}
			}
			else if(command.equals("FEL"))
			{
				dealership.filterByElectric();
			}
			else if(command.equals("FAW"))
			{
				dealership.filterByAWD();
			}
			else if(command.equals("FCL"))
			{
				dealership.filtersClear();
			}
			else if(command.equals("Q"))
			{
				return;
			}
		}
			commandLine.close();
		
	} 		scan.close();	

  }
}