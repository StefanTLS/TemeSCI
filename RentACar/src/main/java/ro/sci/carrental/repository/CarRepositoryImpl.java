package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.lang.String;

/**
 * Created by Stefan on 30.05.2017.
 *
 *
 * ToDo: Implement remove and find
 *
 */
public class CarRepositoryImpl implements  CarRepository {


    public List<Car> cars = new ArrayList<Car>();

//Constructor 1
    public CarRepositoryImpl(List<Car> cars) {
        this.cars = cars;
    }

//Constructor 2
    public CarRepositoryImpl() {

    }

    //Getter
    public List<Car> getCars() {
        return cars;
    }

    /**
     * Add a car in the List
     * @param car
     */
    public void addCar(Car car) {
        if(car == null) {
            cars.isEmpty();
        } else{

        cars.add(car);
        }
    }

    /**
     * returns all carrs found in the list
     * @return
     */
    public List<Car> findAll(){
        return cars;

    }
    public void getCar(Car car){
        cars.get(cars.indexOf(car));
    }

    public void updateCar(Car car) {
        cars.set(cars.indexOf(car), car);

    }

    public void deleteCar(Car car){
        cars.remove(car);




    }
}
