package ro.sci.carrental.services;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Stefan on 03.06.2017.
 *
 *
 *
 */
public class CarSearchServiceImpl implements CarSearchService {


    private CarRepositoryImpl carRepositoryImpl;

    public CarSearchServiceImpl(CarRepositoryImpl carRepositoryImpl) {
        this.carRepositoryImpl = carRepositoryImpl;
    }




    /**
     * Find caar by maker
     * @param carMaker
     * @return
     */
    public List<Car> findCarsByMaker(String carMaker) {

        List<Car> foundCarsMaker = new ArrayList<Car>();

        for (Car car : carRepositoryImpl.getCars()) {

            if (car.getCarMaker().equals(carMaker)) {
                foundCarsMaker.add(car);
            }
        }

        return foundCarsMaker;
    }


    /**
     * Find car by model
     * @param carMaker
     * @param carModel
     * @return
     */
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

    public List<Car> findByFuelType(FuelType fuelType){
        List<Car> foundFuel = new ArrayList<Car>();
        for (Car car: carRepositoryImpl.getCars()){
            if (car.getFuelType().equals(fuelType)){
                foundFuel.add(car);
            }
        }
        return foundFuel;
    }

    private List<Car> isAutomatic(boolean carAutomaticGearbox){
        List<Car> foundAutomatic = new ArrayList<Car>();
        for (Car car: carRepositoryImpl.getCars()){
            if(car.hasCarAutomaticGearbox() == carAutomaticGearbox){
                foundAutomatic.add(car);
            }
        }
        return foundAutomatic;
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
//                    car.getCarColor().equals(carColor) || car.isCarGps() == carGps || car.isCarAutomaticGearbox() w carAutomaticGearbox ||
//                    car.getFuelType() == fuelType || car.getCarModelYear() == carModelYear || car.getCarFuelTankCapacity() == carFuelTankCapacity ||
//                    car.getCarPower() == carPower || car.getCarFuelConsumption() == carFuelConsumption){
//                foundCarsAll.add(car);
//            }
//        }
//        return foundCarsAll;




}






