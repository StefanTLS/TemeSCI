package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Stefan on 30.05.2017.
 *
 *
 *
 *
 */
public class CarRepositoryImpl <Car> implements RepoInterface<Car> {

    public List<Car> cars = new ArrayList<>();



    /**
     * Create?
     * Adds and object of type Car to the repository
     *
     * @param car some object
     */
    public void add(Car car) {
            cars.add(car);

    }

    /**
     * Read
     * Reads(finds) certain Cars from the repository
     *
     * @return
     */
    @Override
    public Car findObj(Car car) {
        return car;
    }

    /**
     * Update
     * Update Car
     * ?? - Use the set(index, element) method to replace the element at the specified index by the specified element?
     *
     * @param car
     */
    @Override
    public void update(Car car) {
        cars.set(cars.indexOf(car), car);
    }

    /**
     * Delete car!
     *
     * @param car
     */
    @Override
    public void delete(Car car) {
        cars.remove(car);

    }

    /**
     * Returns all the cars in the repository
     * @return List of cars
     */
    @Override
    public List<Car> getAll() {
        return cars;
    }



    //Constructor 1
    public CarRepositoryImpl(List<Car> cars) {
        this.cars = cars;
    }
    //Constructor 2
    public CarRepositoryImpl() {

    }


}
