package ro.sci.carrental;


import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import ro.sci.carrental.domain.CalculatePrice;
import ro.sci.carrental.domain.RentalCalendar;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.io.Convertor;
import ro.sci.carrental.io.InvalidEntityException;
import ro.sci.carrental.io.TxtReader;
import ro.sci.carrental.io.car.CarTxtConvertor;
import ro.sci.carrental.io.car.CarTxtWriter;
import ro.sci.carrental.io.car.CarXLSXReader;
import ro.sci.carrental.io.car.CarXLSXWriter;
import ro.sci.carrental.io.customer.CustomerTxtConvertor;
import ro.sci.carrental.io.customer.CustomerTxtWriter;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.services.CarSearchServiceImpl;
import ro.sci.carrental.services.CustomerService;
import ro.sci.carrental.services.CustomerServiceImpl;

import java.io.File;
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

        System.out.println("_________________Main start_________________");

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


        CarRepositoryImpl<Car> carRepo1 = new CarRepositoryImpl<>();

        // add cars in list
        carRepo1.add(toyotaPrius);
        carRepo1.add(mercedesSLR);
        carRepo1.add(fordTransit);
        carRepo1.add(fordTransit2);

        //search car tests
        CarSearchServiceImpl searchService = new CarSearchServiceImpl(carRepo1);

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

        System.out.println("-----------------------------------------------------");

        //Update a car--------------------------------------------
        toyotaPrius.setCarColor("Purple");

        //creating customer objects      ---------------------------
        Customer mihaiPopa = new Customer();
        Customer florinRadu = new Customer();
        Customer biancaOanea = new Customer();

        //Customer Repo-------------------------------------------
        CustomerRepositoryImpl<Customer> customerRepository = new CustomerRepositoryImpl<>();

        //Add in repoList     --------------------
        customerRepository.add(mihaiPopa);
        customerRepository.add(florinRadu);
        customerRepository.add(biancaOanea);

        // update customers with params -------------------------
        mihaiPopa.setCustomerFirstName("Popa");
        mihaiPopa.setCustomerLastName("Mihai");

        //------------------Rental Price----------------------
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

        System.out.println("-----------------------------------------------------");


        //-----------Car writer in excel-----------------------
        CarXLSXWriter carXLSXWriter = new CarXLSXWriter();
        carXLSXWriter.carWriter();

        CarXLSXReader carXLSXReader = new CarXLSXReader();
        carXLSXReader.carReader();

        //Testing Car Reader + CarConverter------------------------------
        File carInFile = new File("carsIn.txt");
        TxtReader txtReader = new TxtReader();
        List<String> carLines = txtReader.readLines(carInFile);
        CarTxtConvertor carConvertor = new CarTxtConvertor();
        int i = 0;
        for (String line : carLines) {
            i++;
            Car car = null;
            try {
                car = carConvertor.convert(line);
            } catch (InvalidEntityException e) {
                System.out.println("invalid car for: [" + line + "] at line: " + i);
            }
        }
        System.out.println("-----------------------------------------------------");

        //Testing Customer Reader + CustomerConverter------------------------------

        File customerFile = new File("customersIn.txt");

        List<String> customerLines = txtReader.readLines(customerFile);
        CustomerTxtConvertor customerConvertor = new CustomerTxtConvertor();

        for (String line: customerLines){
            i++;
            Customer customer = null;
            try {
               customer =  customerConvertor.convert(line);
            }catch (InvalidEntityException e){
                System.out.println("invalid customer for: [" + line + "] at line: " + i);
            }
        }

        //Car writer-----------------------------

        File carOutFile = new File("carsOut.txt");
        CarTxtWriter<Car> carTxtWriter = new CarTxtWriter<>();
        carTxtWriter.writeObj(carRepo1.getAll(),carOutFile);

        //Customer writer------------------------

        File customerOutFile = new File("customersOut.txt");
        CustomerTxtWriter<Customer> customerTxtWriter = new CustomerTxtWriter<>();
        customerTxtWriter.writeObj(customerRepository.getAll(),customerOutFile);

    }
    //End psvm


}
