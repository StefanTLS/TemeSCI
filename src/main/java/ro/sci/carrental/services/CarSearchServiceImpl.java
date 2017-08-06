package ro.sci.carrental.services;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.CarStatus;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.PriceCategory;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.RepoInterface;

import java.util.*;

public class CarSearchServiceImpl implements CarSearchService <Car> {

     private RepoInterface<Car> carRepository;

    public CarSearchServiceImpl(RepoInterface<Car> carRepository) {
        this.carRepository = carRepository;
    }

    public CarSearchServiceImpl(CarRepositoryImpl<Car> carRepository) {
        this.carRepository = carRepository;
    }

  public void printThis(){
      System.out.println(carRepository.getAll());
  }

    /**
     * Search a car by its maker
     *
     * @param carMaker What car maker is searched
     * @return cars of that maker available
     */
    @Override
    public List< Car> findCarsByMaker(String carMaker) {
        if(carMaker == null){
            System.out.println("Car not in system.");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getCarMaker().toLowerCase().equals(carMaker.toLowerCase())){
                foundCars.add(car);
            }
        }
        return foundCars;
  }

    /**
     * Search a car by maker and model
     *
     * @param carMaker Searched cars of this maker.
     * @param carModel Searched cars of this model.
     * @return cars found made by the same maker and of the same model.
     */
    @Override
    public List<Car> findCarsByMakerAndModel(String carMaker, String carModel) {
        if(carModel == null && carMaker == null){
            System.out.println("Car not in system.");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getCarMaker().toLowerCase().equals(carMaker.toLowerCase()) && car.getCarModel().toLowerCase().equals(carModel.toLowerCase())){
                foundCars.add(car);
            }
        }
        return foundCars;

    }

    /**
     * Search a car by color.
     *
     * @param carColor Desired color.
     * @return cars available with that color.
     */
    @Override
    public List<? super Car> findColors(String carColor) {
        if (carColor == null){
            System.out.println("Car not in system.");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getCarColor().toLowerCase().equals(carColor.toLowerCase())){
                foundCars.add(car);
            }
        }
        return foundCars;

    }

    /**
     * Search by the maximum number of passengers the car can have.
     *
     * @param passengers Maximum number of passengers.
     * @return Cars that can have that maximum of passengers or higher.
     */
    @Override
    public List<? super Car> findMaxPassengers(int passengers) {
        if (passengers == 0){
            System.out.println("Cars have a minimum of 1 passenger");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getCarMaxPassengers()== passengers){
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    /**
     * Search cars by the fuel type.
     *
     * @param fuelType Desired fuel type. It can be one of these: PETROL, DIESEL, LPG, ELECTRIC, HYBRID
     * @return Found cars with that fuel type.
     */
    @Override
    public List<? super Car> findCarsByFuelType(FuelType fuelType) {
        if (!fuelType.equals(FuelType.PETROL) || !fuelType.equals(FuelType.DIESEL) || !fuelType.equals(FuelType.HYBRID) || !fuelType.equals(FuelType.ELECTRIC) || !fuelType.equals(FuelType.LPG) ){
            System.out.println("No cars with that fuel type");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getFuelType().equals(fuelType)){
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    /**
     * Search for cars in a price category.
     *
     * @param priceCategory Desired price category. It can be of these: ECONOMY, MEDIUM, PREMIUM, SUPER
     * @return Found cars in that price category.
     */
    @Override
    public List<? super Car> findCarsByPriceCathegory(PriceCategory priceCategory) {
        if(!priceCategory.equals(PriceCategory.ECONOMY) || !priceCategory.equals(PriceCategory.MEDIUM) || !priceCategory.equals(PriceCategory.PREMIUM) || !priceCategory.equals(PriceCategory.SUPER)){
            System.out.println("No cars in that price category.");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getPriceCategory().equals(priceCategory)){
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    /**
     * Search cars with a certain state.
     *
     * @param carStatus It can be: AVAILABLE, IN_USE, BOOKED, IN_SERVICE;
     * @return Car status.
     */
    @Override
    public List<? super Car> findCarsByAvailability(CarStatus carStatus) {
        if (!carStatus.equals(CarStatus.AVAILABLE) || !carStatus.equals(CarStatus.BOOKED) || !carStatus.equals(CarStatus.IN_SERVICE) || !carStatus.equals(CarStatus.IN_USE)){
            System.out.println("Status non-existent.");
            throw new IllegalArgumentException();
        }
        List<Car> foundCars = new ArrayList<>();
        for (Car car: carRepository.getAll()){
            if(car.getCarStatus().equals(carStatus)){
                foundCars.add(car);
            }
        }
        return foundCars;
    }


}



