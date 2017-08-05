package ro.sci.carrental.io.car;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.CarStatus;
import ro.sci.carrental.domain.car.FuelType;
import ro.sci.carrental.domain.car.PriceCategory;
import ro.sci.carrental.io.Convertor;
import ro.sci.carrental.io.InvalidEntityException;
import ro.sci.carrental.io.TxtReader;

public class CarTxtConvertor implements Convertor<Car> {
    private static final Logger LOGGER = Logger.getLogger(CarTxtConvertor.class.getName());

    @Override
    public Car convert(String convertedString) throws InvalidEntityException {
        String[] tokens = convertedString.split(";");
        if (tokens.length != 15) {
            throw new InvalidEntityException("Invalid Car Description");
        }

        Car car = new Car();

        car.setCarMaker(tokens[0]);
        car.setCarModel(tokens[1]);
        car.setCarType(tokens[2]);
        car.setCarDoorsNumber(Integer.parseInt(tokens[3].replaceAll("[^0-9]", "")));
        car.setCarMaxPassengers(Integer.valueOf(tokens[4].replaceAll("[^0-9]", "")));
        car.setCarColor(tokens[5]);
        car.setCarGps(Boolean.parseBoolean(tokens[6].replaceAll(" ","")));
        car.setCarAutomaticGearbox(Boolean.parseBoolean(tokens[7].replaceAll(" ","")));
        car.setFuelType(FuelType.valueOf(tokens[8].replaceAll(" ","").toUpperCase()));
        car.setCarModelYear(Integer.parseInt(tokens[9].replaceAll("[^0-9]", "")));
        car.setCarFuelTankCapacity(Integer.valueOf(tokens[10].replaceAll("[^0-9]", "")));
        car.setCarPower(Integer.valueOf(tokens[11].replaceAll("[^0-9]", "")));
        car.setCarFuelConsumption(Double.valueOf(tokens[12].replaceAll(" [^0-9].[^0-9] ", "")));
        car.setPriceCategory(PriceCategory.valueOf(tokens[13].replaceAll(" ","").toUpperCase()));
        car.setCarStatus(CarStatus.valueOf(tokens[14].replaceAll(" ","").toUpperCase()));

        LOGGER.log(Level.INFO,"Car in this list: " + car);
        return car;
    }
}
