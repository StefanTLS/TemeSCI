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
                121, 4.7, ECONOMY, AVAILABLE);

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
        //todo make this log instead of print?
        CarSearchServiceImpl searchService = new CarSearchServiceImpl(carRepo1);

        List<Car> foundCarsByMakerAndModel = (List<Car>) searchService.findCarsByMakerAndModel("ToyOta", "Prius");

        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerAndModel) {
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }

        List<Car> foundCarsByMakerAndModel2 = searchService.findCarsByMakerAndModel("Mercedes", "SLR");
        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerAndModel2) {
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }

        System.out.println("-----------------------------------------------------");

        //Update a car--------------------------------------------
        toyotaPrius.setCarColor("Purple");

        //creating customer objects      ---------------------------
        //todo Update more customers
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
        RentalCalendar rentalDates1 = new RentalCalendar(new LocalDate(2018,7,10),new LocalDate(2018,7, 15));




        RentalCalendar rentalDates2 = new RentalCalendar(new LocalDate(2018, 3, 10),new LocalDate(2018, 3, 20));

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
        calculatePriceT.calculatePrice(fordTransit, new RentalCalendar(new LocalDate(2018, 3, 29),
                new LocalDate(2018, 3, 30)));

        System.out.println("-----------------------------------------------------");


        //-----------Car writer in excel-----------------------
        CarXLSXWriter carXLSXWriter = new CarXLSXWriter();
        carXLSXWriter.carWriter();

        CarXLSXReader carXLSXReader = new CarXLSXReader();
        carXLSXReader.carReader();

        //Testing Car Reader + CarConverter------------------------------
        //todo make this better, maybe a separate Class.method? (ASK)

        TxtReader txtReader = new TxtReader();
        File carInFile = new File("carsIn.txt");
        CarTxtConvertor carConvertor = new CarTxtConvertor(carInFile);

//        List<String> carLines = txtReader.readLines(carInFile);
//        CarTxtConvertor carConvertor2 = new CarTxtConvertor(carInFile);
//
//        CarRepositoryImpl<Car> carRepoIO = new CarRepositoryImpl<>();
//        int i = 0;
//        for (String line : carLines) {
//            i++;
//            Car carIO = null;
//            try {
//                carIO = carConvertor2.convert(line);
//                carRepoIO.add(carIO);
//            } catch (InvalidEntityException e) {
//                System.out.println("invalid carIO for: [" + line + "] at line: " + i);
//            }
//
//        }

        CarSearchServiceImpl searchServiceIO = new CarSearchServiceImpl(carConvertor.carsFromConvert());
        searchServiceIO.printThis();
        List<Car> foundCarsByMakerIO = searchServiceIO.findCarsByMaker("SkOda");

        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerIO) {
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }

        System.out.println("-----------------------------------------------------");

        //Testing Customer Reader + CustomerConverter------------------------------
        //todo same as for car?

        File customerFile = new File("customersIn.txt");
        List<String> customerLines = txtReader.readLines(customerFile);
        CustomerTxtConvertor customerConvertor = new CustomerTxtConvertor();
        CustomerRepositoryImpl<Customer> customerRepoIO = new CustomerRepositoryImpl<>();

        int j = 0;
        for (String line : customerLines) {
            j++;
            Customer customer1;
            try {
                customer1 = customerConvertor.convert(line);
                customerRepoIO.add(customer1);
            } catch (InvalidEntityException e) {
                System.out.println("invalid customer for: [" + line + "] at line: " + j);
            }
        }

        CustomerServiceImpl searchCustomerIO = new CustomerServiceImpl(customerRepoIO);
        searchCustomerIO.printThis();
        List<Customer> foundCustomersByFirstNameIO = searchCustomerIO.findCustomerByFirstName("Omar Aziz");
        System.out.println("Found customers with this first name: ");
        for (Customer customer: foundCustomersByFirstNameIO){
            System.out.println(customer.getCustomerFirstName()+ " " + customer.getCustomerLastName());
        }

        //Car writer-----------------------------
        File carOutFile = new File("carsOut.txt");
        CarTxtWriter<Car> carTxtWriter = new CarTxtWriter<>();
        carTxtWriter.writeObj(carRepo1.getAll(), carOutFile);

        //Customer writer------------------------
        CustomerTxtWriter<Customer> customerTxtWriter = new CustomerTxtWriter<>();
        customerTxtWriter.writeObj(customerRepository.getAll(),new File("customersOut.txt"));

    }
    //End psvm



}
