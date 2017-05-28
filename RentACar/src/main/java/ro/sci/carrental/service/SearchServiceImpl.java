package ro.sci.carrental.service;

import ro.sci.carrental.domain.Car;
import ro.sci.carrental.repository.CarRepository;
import ro.sci.carrental.util.FuelType;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchService Class offers search services for cars in car list.
 *
 * @author Flaviu Lupoian
 * @version 1.0
 * @since 1.8
 */
public class SearchServiceImpl implements SearchService {

    private CarRepository carRepository;

    public SearchServiceImpl(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    /**
     * Public method findCarsByMake searches cars by make.
     *
     * @param make holds value of car make
     * @return list of found cars.
     */
    public List<Car> findCarsByMake(String make) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll()) {
            if (car.getMake().equalsIgnoreCase(make)) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    /**
     * Public method findCarsByMakeAndModel searches cars by make and model.
     *
     * @param make  holds value of car make
     * @param model holds value f car model
     * @return list of found cars.
     */
    public List<Car> findCarsByMakeAndModel(String make, String model) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(model)) && (car.getMake().equalsIgnoreCase(make))) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    /**
     * Public method findCarsByMultipleCategories searches cars by make, model, color, seats.
     *
     * @param make  value of car make
     * @param model value of car model
     * @param color value of car color
     * @param seats value of car seats
     * @return list of found cars
     */
    public List<Car> findCarsByMultipleCategories(String make, String model, String color, int seats) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carRepository.getAll()) {
            if ((car.getModel().equalsIgnoreCase(model)) && (car.getMake().equalsIgnoreCase(make))
                    && (car.getColor().equalsIgnoreCase(color)) && (car.getSeats() == seats)) {
                foundCars.add(car);
            }
        }

        return foundCars;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

}
