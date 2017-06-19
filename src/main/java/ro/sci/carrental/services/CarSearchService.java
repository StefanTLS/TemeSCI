package ro.sci.carrental.services;

import ro.sci.carrental.domain.car.Car;

import java.util.List;

/**
 * Created by Stefan on 12.06.2017.
 */
public interface CarSearchService {




    List<Car> findCarsByMaker(String carMaker);

    List<Car> findCarsByMakerAndModel(String carMaker, String carModel);

    List<Car> findColors (String carColor);
}
