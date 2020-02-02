import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
				SalesTeam salesTeam = new SalesTeam();
				ArrayList<Car> cars = new ArrayList<Car>();
				
	  // Then create an (initially empty) array list of type Car
      // Then create some new car objects of different types
	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	  
		
	  try{
		//open cars.txt file
		File file = new File("cars.txt");
		Scanner in = new Scanner(file);
		
		//check if there is a line in the file to read and while there is, keep running
		while(in.hasNext()){

			//read in the words and store them in the correct variable in order to supply them
			//to the constructors for either the Car class or Electric Car class
			String tempMfr = in.next();
			String tempColor = in.next();
			String tempModel = in.next();
			String tempPower = in.next();
			double tempSafetyRating = in.nextDouble();
			int tempMaxRange = in.nextInt();

			//Since for All Wheel Drive the options are AWD and 2WD, check which one it is
			//set true if the string equals AWD, if not set it to false
			String tempAWD = in.next();
			
			
			Double tempPrice = in.nextDouble();

			//in order to set the recharge time we need to check if power is ELECTRIC_MOTOR
			//because only the electric cars have a recharge time
			if(tempPower.equals("ELECTRIC_MOTOR")){
			int tempRechargeTime = in.nextInt();
			//now we have all the variable required to create the Electric car object, so we create it
			//and add it to the list of car objects
			ElectricCar tempCar = new ElectricCar(tempMfr, tempColor, tempModel, tempPower, tempSafetyRating, tempMaxRange, tempAWD, tempPrice, tempRechargeTime);
			cars.add(tempCar);
		}
		//if power is not ELECTRIC_MOTOR in this case, the only other option is to constuct a car object
		//and add it to the list of Car object
			else{
				Car newCar = new Car(tempMfr, tempColor, tempModel, tempPower, tempSafetyRating, tempMaxRange, tempAWD, tempPrice);
				cars.add(newCar);
			}
		}
		in.close();
	}
  catch(FileNotFoundException e){
		e.printStackTrace();}

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
				if (commandLine.hasNextInt())
				{
					if (cars.size() != 0)
					{
						int number = commandLine.nextInt();
						String carBought = dealership.buyCar(number);
						System.out.println(carBought + "\n");	
					} 
					else {System.out.println("Please ADD cars" + "\n");}
				} 
			}	
			else if(command.equals("RET"))
			{
					dealership.returnCar();
			}
			else if(command.equals("ADD"))
			{
				dealership.addCars(cars);
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
			else if(command.equals("SALES"))
			{
				if (commandLine.hasNextInt())
				{
					int month = commandLine.nextInt();
					String list = dealership.getSalesOnMonth(month);
					System.out.print(list);
				}
				else if (commandLine.hasNext())
				{
					String next= commandLine.next();
					if (next.equals("TEAM"))
					{
						System.out.println(salesTeam.allSalesPeople() + "\n");
					}
					else if (next.equals("SIZE"))
					{
						System.out.println(dealership.listSize() + "\n");
					}
					else if (next.equals("TOPSP"))
					{
						System.out.println(dealership.topSP() + "\n");
					}
					else if (next.equals("STATS"))
					{
						System.out.println(dealership.salesStats() + "\n");
					}
				}
				else
				{
					System.out.println(dealership.allSales());
				}
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
