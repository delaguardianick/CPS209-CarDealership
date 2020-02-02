import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class SalesTeamTester
{

   public static void main(String[] args)
   {
    AccountingSystem accountingSystem = new AccountingSystem();
    SalesTeam sales = new SalesTeam();
    CarDealership dealership = new CarDealership();
    Car car = new Car("Kia",      "white", "MINIVAN", "GAS_ENGINE",     9.7, 550, "2WD", 20000);
    GregorianCalendar date = new GregorianCalendar(2019,6,4);
    String salesPerson = sales.randomSalesPerson();
    String type = "BUY";

    Transaction transaction = new Transaction(245, date, car, salesPerson, type );
    System.out.println(accountingSystem.add(date,car,salesPerson, type, car.getPrice()));
    System.out.println("List size: " + accountingSystem.listSize());
    System.out.println("All sales: " + accountingSystem.allSales());
    System.out.println("Sales on MONTH 6:" + accountingSystem.getSalesOnMonth(6));

   }
}