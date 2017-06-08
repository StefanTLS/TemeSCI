package ro.sci.carrental;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.services.CarSearchService;


import java.util.List;

import static ro.sci.carrental.util.FuelType.DIESEL;
import static ro.sci.carrental.util.FuelType.HYBRID;
import static ro.sci.carrental.util.FuelType.PETROL;



/**
 * Created by Stefan on 28.05.2017.
 *
 *
 */
public class Main {


    public static void main(String[] args) {
        

        System.out.println("_____________________________");


        Car toyotaPrius = new Car("Toyota", "Prius", "FAMILY", 4, 5,
                "White", true, true, HYBRID, 2014, 45,
                121, 4 );
 //de ce nu pot pune cu virgula la carFuelConsumption?

        Car mercedesSLR = new Car("Mercedes", "SLR", "SPORTS", 2, 2,
                "Black", false, true, PETROL, 2003, 97,
                650, 15);

        Car fordTransit = new Car("Ford", "Transit", "UTILITY", 3, 3,
                "Gray", true, true, DIESEL, 2015, 94,
                185, 15);

        Car fordTransit2 = new Car("Ford", "Transit2", "UTILITY", 3, 3,
                "Gray", true, true, DIESEL, 2015, 94,
                185, 15);

        // new object----------------------------
        CarRepository carRepository = new CarRepository();
        // add cars in list
        carRepository.addCar(toyotaPrius);
        carRepository.addCar(mercedesSLR);
        carRepository.addCar(fordTransit);
        carRepository.addCar(fordTransit2);

        //search by maker---------------------------
        CarSearchService searchByMaker = new CarSearchService(  carRepository);
        List<Car> foundCarsByMaker = searchByMaker.findCarsByMaker("Ford");
        System.out.println("Cars by maker found: ");
        for (Car car : foundCarsByMaker){
            System.out.println((car.getCarMaker()));
        }


        //Search by maker and model---------------------------------
        CarSearchService searchByMakerAndModel = new CarSearchService(carRepository);
        List<Car> foundCarsByMakerAndModel = searchByMakerAndModel.findCarsByMakerAndModel("Toyota", "Prius");
        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerAndModel){
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }

        //Search by anything? Doesn't work as intended
//        CarSearchService searchByAnything = new CarSearchService(carRepository);
//        List<Car> foundCars = searchByAnything.findCarsMultiple("Mercedes");
//        System.out.println("Search results: ");
//        for (Car car : foundCars){
//            System.out.println(car.getCarMaker() + "" + car.getCarModel());
//        }


        System.out.println("--------------Customer-----------------");






        //all the cars--------------
        searches(carRepository);
    }

    //all the cars--------------
    private static void searches(CarRepository carRepository) {
        System.out.println("Toate masinile din lista:");
        for (Car car : carRepository.getCars()){
            System.out.println(car.getCarMaker() +" " + car.getCarModel());
        }

    }




}
