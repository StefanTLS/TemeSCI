package ro.sci.carrental.repository;
import ro.sci.carrental.domain.Car;
import ro.sci.carrental.util.FuelType;
import java.util.List;

/**
 * Created by Stefan on 25.05.2017.
 *
 *
 *
 * MAKE java doc acasa!
 */

/**
 *
 * Repository interface for Car
 */
public interface CarRepository {

    /**
     * Retuns all cars
     *
     * @return List<Car>
     *
      */
    List<Car> getAll();

    /**
     * Return cars by fuel type
     * @param
     * @return
     */
    List<Car> getCarsByFuelType();
    /**
     * Return all the cars of a certain maker
     * @param
     * @return List<Car>
     */
    List<Car> getCarsByMake();
    /**
     * Add a car to list
     * @param
     * @return List<Car>
     */

    void add(Car car);

    /**
     * Deletes a car from list
     * @param car
     */
    void delete(Car car);

    /**
     * Updates a certain car
     * @param car
     */
    void update (Car car);




}
