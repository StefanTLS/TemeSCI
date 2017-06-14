package ro.sci.carrental.repository;

import ro.sci.carrental.domain.car.Car;

import java.util.List;

/**
 * Created by Stefan on 12.06.2017.
 */
public interface CarRepository {

    List<Car> getCars();

    void addCar(Car car);

    List<Car> findAll();

    void getCar(Car car);

    void updateCar(Car car);

    void deleteCar(Car car);
}
