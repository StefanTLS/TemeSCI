package ro.sci.carrental;


import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import ro.sci.carrental.domain.CalculatePrice;
import ro.sci.carrental.domain.RentalCalendar;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.io.car.CarReader;
import ro.sci.carrental.io.car.CarWriter;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.services.CarSearchServiceImpl;
import java.util.List;
import static ro.sci.carrental.domain.car.CarStatus.*;
import static ro.sci.carrental.domain.car.FuelType.*;
import static ro.sci.carrental.domain.car.PriceCategory.*;



/**
 * Created by Stefan on 28.05.2017.
 *
 *
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger("MainClass");
    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.info("Hello this is an info message");

        try {

        } catch (Exception ex) {


            LOGGER.log(org.apache.log4j.Level.WARN, "Testing");
        }


        System.out.println("_____________________________");


        Car toyotaPrius = new Car("Toyota", "Prius", "FAMILY", 4, 5,
                "White", true, true, HYBRID, 2014, 45,
                121, 4.7, ECONOMY, AVAILABLE );


        Car mercedesSLR = new Car("Mercedes", "SLR", "SPORTS", 2, 2,
                "Black", false, true, PETROL, 2003, 97,
                650, 15, SUPER, AVAILABLE);

        Car fordTransit = new Car("Ford", "Transit", "UTILITY", 3, 3,
                "Gray", true, true, DIESEL, 2015, 94,
                185, 15, PREMIUM, AVAILABLE);

        Car fordTransit2 = new Car("Ford", "Transit2", "UTILITY", 3, 3,
                "Gray", true, true, DIESEL, 2015, 94,
                185, 15, ECONOMY, AVAILABLE);


        // new object----------------------------
        CarRepositoryImpl<Car> carRepo1 = new CarRepositoryImpl<Car>();

        // add cars in list
        carRepo1.add(toyotaPrius);
        carRepo1.add(mercedesSLR);
        carRepo1.add(fordTransit);
        carRepo1.add(fordTransit2);


        System.out.println(carRepo1.findObj(toyotaPrius));
        System.out.println(carRepo1.getAll());

        System.out.println("Toate masinile din lista: ");


        //search car by maker---------------------------
        CarSearchServiceImpl searchService = new CarSearchServiceImpl(carRepo1);

        searchService.printThis();

        System.out.println("Cars by maker found: "+ searchService.findCarsByMaker("toYoTa"));


        List<Car> foundCarsByMakerAndModel = (List<Car>) searchService.findCarsByMakerAndModel("ToyOta", "Prius");
        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerAndModel){
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }

        List<Car> foundCarsByMakerAndModel2 = (List<Car>) searchService.findCarsByMakerAndModel("Mercedes", "SLR");
        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerAndModel2){
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }
        //Update--------------------------------------------
        toyotaPrius.setCarColor("Purple");

        System.out.println("--------------Customer-----------------");

        //creating customer objects        ---------------------------
        Customer mihaiPopa = new Customer();
        Customer florinRadu = new Customer();
        Customer biancaOanea = new Customer();

        //Customer Repo-------------------------------------------
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

        //Add in repoList     --------------------

        customerRepository.add(mihaiPopa);
        customerRepository.add(florinRadu);
        customerRepository.add(biancaOanea);

        // update customers with params -------------------------

        mihaiPopa.setCustomerFirstName("Popa");
        mihaiPopa.setCustomerLastName("Mihai");

        //------------------Rental Price----------------------
        System.out.println("-----------------Rental Price-----------------------------");

        RentalCalendar rentalDates1 = new RentalCalendar();
        rentalDates1.setPickupDate(new LocalDate(2017,7,10));
        rentalDates1.setReturnDate(new LocalDate(2017,7,15));


        RentalCalendar rentalDates2 = new RentalCalendar();
        rentalDates2.setPickupDate(new LocalDate(2017,3,10));
        rentalDates2.setReturnDate(new LocalDate(2017,3,20));

        CalculatePrice calculatePriceT = new CalculatePrice();

        //---------Car 1 - date 1------------------
        calculatePriceT.calculatePrice(toyotaPrius, rentalDates1);

        //----------Car 1 - date 2 -----------------------------
        calculatePriceT.calculatePrice(toyotaPrius, rentalDates2);

        //----------Car 2 - date 1-------------
        calculatePriceT.calculatePrice(mercedesSLR, rentalDates1);

        //------------ Car 2 - date 2-------------------------
        calculatePriceT.calculatePrice(mercedesSLR, rentalDates2);

        //------------ Car 3 - date 3-------------------------
        calculatePriceT.calculatePrice(fordTransit, new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,30)));

        System.out.println("Your rental cost for car 3 - period 3 is: " + calculatePriceT.getTotalPrice());



        //-----------Car writer in excel-----------------------
        CarWriter carWriter = new CarWriter();
        carWriter.carWriter();

        CarReader carReader = new CarReader();
        System.out.println(carReader.carReader());



    }
    //End psvm


}
