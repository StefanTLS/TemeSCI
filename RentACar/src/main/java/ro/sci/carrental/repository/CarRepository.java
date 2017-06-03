package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 30.05.2017.
 */
public class CarRepository {


    private List<Car> cars = new ArrayList<Car>();
//Constructor 1
    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }
//Constructor 2
    public CarRepository() {

    }

    /**
     * Adds a car to the list
     * @param car A new car in the list
     */
    public void addCar(Car car){
        cars.add(car);
    }

    /**
     *  Getter
     * @return Returns all cars
     */
    public List<Car> getCars() {
        return cars;
    }


}
