package ro.sci.carrental;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.repository.CarRepository;


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

        // new object
        CarRepository carRepository = new CarRepository();
        // add cars in list
        carRepository.addCar(toyotaPrius);
        carRepository.addCar(mercedesSLR);
        carRepository.addCar(fordTransit);

        searches(carRepository);







    }

    private static void searches(CarRepository carRepository) {
        System.out.println("Toate masinile din lista:");
        for (Car car : carRepository.getCars()){
            System.out.println(car.getCarMaker() +" " + car.getCarModel());
        }

    }

}
