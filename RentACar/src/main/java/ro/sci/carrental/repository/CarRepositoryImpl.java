package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Car;

import java.util.ArrayList;
import java.util.List;



/**
 * Implementation of CarRepository
 * @author Stefan
 * @version 1.0
 * @since 1.8
 */

public class CarRepositoryImpl implements CarRepository{

    private List<Car> cars = new ArrayList<Car>();


    /**
     * Public void method addCar adds a car to the list of cars
     * @param car
     */
    public void addCar(Car car) {

        cars.add(car);
    }

    public List<Car> getAll() {
        return null;
    }

    public List<Car> getCarsByFuelType() {
        return null;
    }

    public List<Car> getCarsByMake() {
        return null;
    }

    /**
     * Getter for returning car list.
     * @return car list values.
     */
    public List<Car> getAllCars() {

        return cars;
    }

    public void update(Car car) {

    }

    public void delete(Car car) {

    }

    public void add(Car car) {

    }


}
