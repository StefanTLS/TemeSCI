package ro.sci.carrental.domain.car;


/**
 * @author Stefan
 *
 *
 */
public class Car  {


    private String carMaker;
    private String carModel;
    private String carType;
    private int carDoorsNumber;
    private int carMaxPassengers;
    private String carColor;
    private boolean carGps;
    private boolean carAutomaticGearbox;
    private FuelType fuelType;
    private int carModelYear;
    private int carFuelTankCapacity;
    private int carPower;
    private double carFuelConsumption;


    //Constructor
    public Car() {

    }


    //Constructor 2
    /**
     *  @param carMaker The car making company, examples: Toyota, Ford, Volkswagen etc.
     * @param carModel The car model, in broad terms mostly. Examples: Prius, Focus, Passat etc.
     * @param carType The car type based on usage/purpose. They are: Economy, Family, Sports, Off-road, Luxury, Utility.
     * @param carDoorsNumber
     * @param carMaxPassengers The maximum number of passengers legally in a car, including the driver
     * @param carColor
     * @param carGps
     * @param carAutomaticGearbox True = automatic gearbox, false = manual gearbox
     * @param fuelType PETROL, DIESEL, LPG, ELECTRIC
     * @param carModelYear Car's year of manufacture not it's age. Example: 2010(not 7 years old)
     * @param carFuelTankCapacity Car's fuel tank capacity in LITRES
     * @param carPower In HP - HorsePower
     * @param carFuelConsumption Factory advertised average fuel consumption, can be in litres or  kilowatt-hour(kWh) for electric
     */
    public Car(String carMaker, String carModel, String carType, int carDoorsNumber, int carMaxPassengers, String carColor,
               boolean carGps, boolean carAutomaticGearbox, FuelType fuelType, int carModelYear, int carFuelTankCapacity, int carPower,
               double carFuelConsumption) {

        this.carMaker = carMaker;
        this.carModel = carModel;
        this.carType = carType;
        this.carDoorsNumber = carDoorsNumber;
        this.carMaxPassengers = carMaxPassengers;
        this.carColor = carColor;
        this.carGps = carGps;
        this.carAutomaticGearbox = carAutomaticGearbox;
        this.fuelType = fuelType;
        this.carModelYear = carModelYear;
        this.carFuelTankCapacity = carFuelTankCapacity;
        this.carPower = carPower;
        this.carFuelConsumption = carFuelConsumption;
    }




    //Getters and Setters


    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(String carMaker) {
        this.carMaker = carMaker;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCarDoorsNumber() {
        return carDoorsNumber;
    }

    public void setCarDoorsNumber(int carDoorsNumber) {
        this.carDoorsNumber = carDoorsNumber;
    }

    public int getCarMaxPassengers() {
        return carMaxPassengers;
    }

    public void setCarMaxPassengers(int carMaxPassengers) {
        this.carMaxPassengers = carMaxPassengers;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public boolean hasGps() {
        return carGps;
    }

    public void setCarGps(boolean carGps) {
        this.carGps = carGps;
    }

    public boolean hasCarAutomaticGearbox() {
        return carAutomaticGearbox;
    }

    public void setCarAutomaticGearbox(boolean carAutomaticGearbox) {
        this.carAutomaticGearbox = carAutomaticGearbox;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }

    public int getCarFuelTankCapacity() {
        return carFuelTankCapacity;
    }

    public void setCarFuelTankCapacity(int carFuelTankCapacity) {
        this.carFuelTankCapacity = carFuelTankCapacity;
    }

    public int getCarPower() {
        return carPower;
    }

    public void setCarPower(int carPower) {
        this.carPower = carPower;
    }

    public double getCarFuelConsumption() {
        return carFuelConsumption;
    }

    public void setCarFuelConsumption(double carFuelConsumption) {
        this.carFuelConsumption = carFuelConsumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carMaker='" + carMaker + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carType='" + carType + '\'' +
                ", carDoorsNumber=" + carDoorsNumber +
                ", carMaxPassengers=" + carMaxPassengers +
                ", carColor='" + carColor + '\'' +
                ", carGps=" + carGps +
                ", carAutomaticGearbox=" + carAutomaticGearbox +
                ", fuelType=" + fuelType +
                ", carModelYear=" + carModelYear +
                ", carFuelTankCapacity=" + carFuelTankCapacity +
                ", carPower=" + carPower +
                ", carFuelConsumption=" + carFuelConsumption +
                '}';
    }


}
