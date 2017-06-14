package ro.sci.carrental.services;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * Created by Stefan on 03.06.2017.
 *
 *
 *
 */
public class CarSearchServiceImpl implements CarSearchService {


    public CarSearchServiceImpl(CarRepositoryImpl carRepositoryImpl) {
        this.carRepositoryImpl = carRepositoryImpl;
    }

    private CarRepositoryImpl carRepositoryImpl;

    public List<Car> findCarsByMaker(String carMaker) {
        List<Car> foundCarsMaker = new ArrayList<Car>();

        for (Car car : carRepositoryImpl.getCars()) {

            if (car.getCarMaker().equals(carMaker)) {
                foundCarsMaker.add(car);
            }
        }

        return foundCarsMaker;
    }



    public List<Car> findCarsByMakerAndModel(String carMaker, String carModel){
        List<Car> foundCarsMakerAndModel = new ArrayList<Car>();

        for (Car car : carRepositoryImpl.getCars()){

            if (car.getCarMaker().equals(carMaker) && car.getCarModel().equals(carModel)){
                foundCarsMakerAndModel.add(car);
            }
        }
        return foundCarsMakerAndModel;
    }

    public List<Car> findColors (String carColor){

        List<Car> findColors = new ArrayList<Car>();

        for  (Car car : carRepositoryImpl.getCars()){
            if (car.getCarColor().equals(carColor)){
                findColors.add(car);
            }
        }
        return findColors;
    }


//    public List<Car> findCarsMultiple(
//             String carMaker,
//             String carModel,
//             String carType,
//             int carDoorsNumber,
//             int carMaxPassengers,
//             String carColor,
//             boolean carGps,
//             boolean carAutomaticGearbox,
//             FuelType fuelType,
//             int carModelYear,
//             int carFuelTankCapacity,
//             int carPower,
//             double carFuelConsumption){
//        List<Car> foundCarsAll = new ArrayList<Car>();
//
//        for (Car car : carRepositoryImpl.getCars()){
//
//            if (car.getCarModel().equals(carMaker) || car.getCarModel().equals(carModel) || car.getCarType().equals(carType) ||
//                    car.getCarDoorsNumber() == carDoorsNumber || car.getCarMaxPassengers() == carMaxPassengers ||
//                    car.getCarColor().equals(carColor) || car.isCarGps() == carGps || car.isCarAutomaticGearbox() == carAutomaticGearbox ||
//                    car.getFuelType() == fuelType || car.getCarModelYear() == carModelYear || car.getCarFuelTankCapacity() == carFuelTankCapacity ||
//                    car.getCarPower() == carPower || car.getCarFuelConsumption() == carFuelConsumption){
//                foundCarsAll.add(car);
//            }
//        }
//        return foundCarsAll;




}






