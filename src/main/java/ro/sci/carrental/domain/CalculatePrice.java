package ro.sci.carrental.domain;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ro.sci.carrental.domain.car.Car;
import static ro.sci.carrental.domain.car.PriceCategory.*;

/**
 * Created by Stefan on 03.07.2017.
 */


public class CalculatePrice {

    static final Logger LOGGER = Logger.getLogger("Calculate Price");



    private double totalPrice;

    /**
     * Calculates the total cost for a given car
     * @param car
     * @return
     */
    public double calculatePrice(Car car, RentalCalendar calendar){


        if(car.getPriceCategory() == ECONOMY){

            totalPrice = calendar.numberOfDays() * 15;


        }else if(car.getPriceCategory() == MEDIUM){

            totalPrice = calendar.numberOfDays() * 25;


        }else if(car.getPriceCategory()== PREMIUM){

            totalPrice = calendar.numberOfDays() * 45;

        }else if (car.getPriceCategory()== SUPER){

            totalPrice = calendar.numberOfDays() * 200;

        }else{

            System.out.println("Try again");

        }
        if (totalPrice == 0.0){
            throw new IllegalArgumentException("Rent for at least a day");
        }

        LOGGER.log(Level.INFO, "The total cost for " + car.getCarMaker() +" "+ car.getCarModel() + " in " + calendar.numberOfDays() + " days is: " + this.totalPrice );

        return totalPrice;

    }

    //Constructor
    public CalculatePrice() {
    }


    //Getter and Setter

    public double getTotalPrice() {
        return totalPrice;
    }

}
