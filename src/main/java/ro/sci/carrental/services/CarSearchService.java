package ro.sci.carrental.services;

import ro.sci.carrental.domain.car.CarStatus;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.PriceCategory;

import java.util.List;

/**
 * Created by Stefan on 12.06.2017.
 */
public interface CarSearchService <Car>{


    /**
     * Search a car by its maker
     * @param carMaker What car maker is searched
     * @return cars of that maker
     */
    List<? super Car> findCarsByMaker(String carMaker);

    /**
     * Search a car by maker and model
     * @param carMaker Searched cars of this maker.
     * @param carModel Searched cars of this model.
     * @return Cars found made by the same maker and of the same model.
     */
    List<? super Car> findCarsByMakerAndModel(String carMaker, String carModel);

    /**
     * Search a car by color.
     * @param carColor Desired color.
     * @return  Cars with that color.
     */
    List<? super Car> findColors(String carColor);

    /**
     * Search by the maximum number of passengers the car can have.
     * @param passengers Maximum number of passengers.
     * @return Cars that can have that maximum of passengers or higher.
     */
    List<? super Car> findMaxPassengers(int passengers);

    /**
     * Search cars by the fuel type.
     * @param fuelType Desired fuel type. It can be one of these: PETROL, DIESEL, LPG, ELECTRIC, HYBRID
     * @return Found cars with that fuel type.
     */
    List<? super Car> findCarsByFuelType(FuelType fuelType);

    /**
     * Search for cars in a price category.
     * @param priceCategory Desired price category. It can be of these: ECONOMY, MEDIUM, PREMIUM, SUPER
     * @return Found cars in that price category.
     */
    List<? super Car> findCarsByPriceCathegory(PriceCategory priceCategory);

    /**
     * Search cars with a certain state.
     * @param carStatus It can be: AVAILABLE, IN_USE, BOOKED, IN_SERVICE;
     * @return Car status.
     */
    List<? super Car> findCarsByAvailability(CarStatus carStatus);



}
