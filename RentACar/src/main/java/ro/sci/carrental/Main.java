package ro.sci.carrental;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.domain.Customer;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.service.SearchService;
import ro.sci.carrental.service.SearchServiceImpl;
import ro.sci.carrental.util.FuelType;
import ro.sci.carrental.util.VehicleCategory;

import java.util.List;

/**
 * <h1>RentACar Model</h1>
 * RentACar simulates a car rental business.
 * <p>
 * <h>
 * This is the main method which makes use of static void method searches() to run multiple queries
 *
 * @author Flaviu Lupoian
 * @version 1.0
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) {
        // initializam masini
        Car mercedes = new Car("Mercedes", "e220d", 5.0f, "Black", 5, 4, true, true, true, FuelType.DIESEL, VehicleCategory.LIMOUSINE);
        Car bmw = new Car("BMW", "520d", 5.0f, "Silver", 5, 4, true, true, true, FuelType.GAS, VehicleCategory.SPORT);
        Car vw = new Car("Volkswagen", "Passat", 5.0f, "White", 5, 4, true, false, false, FuelType.GPL, VehicleCategory.SEDAN);

        CarRepository carRepository = new CarRepositoryImpl();

        //introducem masini
        carRepository.add(mercedes);
        carRepository.add(bmw);
        carRepository.add(vw);

        //initializam clienti
        Customer customer1 = new Customer("Dorel", "Cretu", "Str. Carpati nr.1", "Cluj-Napoca");
        Customer customer2 = new Customer("Pavel", "Cristea", "Str. Bucegi nr.1", "Oradea");

        //efectuam cautari
        searches(carRepository);


    }

    /**
     * Public static void method searches() runs multiple searches criteria
     *
     * @param carRepository holds the values of car list.
     */
    private static void searches(CarRepository carRepository) {
        //cautarea tuturor masinilor
        System.out.println("Lista masinilor din CarRepository este: ");
        for (Car car : carRepository.getAll()) {
            System.out.println(car.getMake());
        }
        System.out.println("_____________________________________");

        //cautare dupa marca
        SearchService search1 = new SearchServiceImpl(carRepository);
        List<Car> foundCarsByMake = search1.findCarsByMake("BMW");

        System.out.println("Cautarea dupa Marca returneaza urmatoarele masini: ");
        for (Car car : foundCarsByMake) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("_____________________________________");

        //cautare dupa marca si model
        SearchService search2 = new SearchServiceImpl(carRepository);
        List<Car> foundCarsByMakeAndModel = search2.findCarsByMakeAndModel("Mercedes", "e220d");

        System.out.println("Cautarea dupa Marca si Model returneaza urmatoarele masini: ");
        for (Car car : foundCarsByMakeAndModel) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("_____________________________________");

        //cautare dupa Marca, Model, Culoare si Locuri
        SearchService search3 = new SearchServiceImpl(carRepository);
        List<Car> foundCarsByMultipleCategories = search3.findCarsByMultipleCategories(
                "Volkswagen", "Passat", "White", 5);

        System.out.println("Cautarea dupa Marca, Model, Culoare si Locuri returneaza urmatoarele masini: ");
        for (Car car : foundCarsByMultipleCategories) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
        System.out.println("_____________________________________");
    }
}
