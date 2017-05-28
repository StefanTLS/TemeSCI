package ro.sci.carrental.service;

import ro.sci.carrental.domain.Car;

import java.util.List;

/**
 * Created by Stefan on 25.05.2017.
 */
public interface SearchService {


    List<Car> findCarsByMake(String make);

    List<Car> findCarsByMakeAndModel(String make, String model);

    List<Car> findCarsByMultipleCategories(String make, String model, String color, int seats);
}
