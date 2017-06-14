package ro.sci.carrental;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.services.CarSearchService;
import ro.sci.carrental.services.CarSearchServiceImpl;


import java.util.List;

import static ro.sci.carrental.domain.car.FuelType.DIESEL;
import static ro.sci.carrental.domain.car.FuelType.HYBRID;
import static ro.sci.carrental.domain.car.FuelType.PETROL;



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
                121, 4.7 );
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


         fordTransit2 = null; //Truly deleted but requires exceptions?



        // new object----------------------------
        CarRepositoryImpl carRepositoryImpl = new CarRepositoryImpl();



        // add cars in list
        carRepositoryImpl.addCar(toyotaPrius);
        carRepositoryImpl.addCar(mercedesSLR);
        carRepositoryImpl.addCar(fordTransit);
        carRepositoryImpl.addCar(fordTransit2);



        //carRepositoryImpl.deleteCar(fordTransit2); - Deleted from List but remains in memory and would work for another collection




        //toyotaPrius.setCarColor("Purple");




        //search by maker---------------------------
        CarSearchService searchByMaker = new CarSearchServiceImpl(carRepositoryImpl);
        List<Car> foundCarsByMaker = searchByMaker.findCarsByMaker("Ford");
        System.out.println("Cars by maker found: ");
        for (Car car : foundCarsByMaker){
            System.out.println((car.getCarMaker()));
        }


        //Search by maker and model---------------------------------
        CarSearchService searchByMakerAndModel = new CarSearchServiceImpl(carRepositoryImpl);
        List<Car> foundCarsByMakerAndModel = searchByMakerAndModel.findCarsByMakerAndModel("Toyota", "Prius");
        System.out.println("Search resutls by maker and model:");
        for (Car car : foundCarsByMakerAndModel){
            System.out.println((car.getCarMaker() + " " + car.getCarModel()));
        }

        //Search by anything? ------------------- Doesn't work----------------------
//        CarSearchServiceImpl searchByAnything = new CarSearchServiceImpl(carRepositoryImpl);
//        List<Car> foundCars = searchByAnything.findCarsMultiple("Mercedes");
//        System.out.println("Search results: ");
//        for (Car car : foundCars){
//            System.out.println(car.getCarMaker() + "" + car.getCarModel());
//        }





        System.out.println("--------------Customer-----------------");






        //all the cars--------------
        searches(carRepositoryImpl);


    }

    //all the cars--------------
    private static void searches(CarRepositoryImpl carRepositoryImpl) {
        System.out.println("Toate masinile din lista:");
        for (Car car : carRepositoryImpl.getCars()){
            System.out.println(car.getCarMaker() +" " + car.getCarModel());
        }

        System.out.println("Car color:");

        for (Car car : carRepositoryImpl.getCars()){
            System.out.println(car.getCarModel()+ " " + car.getCarColor());
        }

    }


    //Update car?



}
