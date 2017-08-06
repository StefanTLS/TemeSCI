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
import ro.sci.carrental.repository.CarRepositoryImpl;

import java.io.File;
import java.util.List;

public class CarTxtConvertor implements Convertor<Car> {
    private static final Logger LOGGER = Logger.getLogger(CarTxtConvertor.class.getName());
    private File carsFile;

    @Override
    public Car convert(String convertedString) throws InvalidEntityException {
        String[] tokens = convertedString.split(";");
        if (tokens.length != 15) {
            throw new InvalidEntityException("Invalid Car Description");
        }

        Car car = new Car();

        car.setCarMaker(tokens[0].trim());
        car.setCarModel(tokens[1].trim());
        car.setCarType(tokens[2].trim());
        car.setCarDoorsNumber(Integer.parseInt(tokens[3].replaceAll("[^0-9]", "")));
        car.setCarMaxPassengers(Integer.valueOf(tokens[4].replaceAll("[^0-9]", "")));
        car.setCarColor(tokens[5].trim());
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

    public CarRepositoryImpl<Car> carsFromConvert(){
        TxtReader txtReader = new TxtReader();
        List<String> carLines = txtReader.readLines(carsFile);
        CarTxtConvertor carConvertor = new CarTxtConvertor(this.carsFile);
        CarRepositoryImpl<Car> carRepoIO = new CarRepositoryImpl<>();
        int i = 0;
        for (String line : carLines) {
            i++;
            Car carIO;
            try {
                carIO = carConvertor.convert(line);
                carRepoIO.add(carIO);
            } catch (InvalidEntityException e) {
                System.out.println("invalid carIO for: [" + line + "] at line: " + i);
            }

        }
        return carRepoIO;
    }

    public CarTxtConvertor(File carsFile) {
        this.carsFile = carsFile;
    }
}
