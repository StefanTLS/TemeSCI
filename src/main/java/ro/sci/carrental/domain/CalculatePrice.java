package ro.sci.carrental.domain;


import org.joda.time.Days;
import ro.sci.carrental.domain.car.Car;
import static ro.sci.carrental.domain.car.PriceCategory.*;

/**
 * Created by Stefan on 03.07.2017.
 */
public class CalculatePrice{


    private  double totalPrice;
    private RentalCalendar calendar;
    private Car car;

    /**
     * Calculates the time period between pickUpDate and returnDate from calendar represented in number of days.
     * @return number of days as an integer.
     */
    public int numberOfDays() {
        Days numberOfDays = Days.daysBetween(calendar.getPickupDate(), calendar.getReturnDate());
        String intValue = numberOfDays.toString().replaceAll("[^0-9]", "");
        return Integer.parseInt(intValue);
    }

    /**
     * Calculates the total cost for a given car
     * @param car
     * @return
     */
    public double calculatePrice(Car car ){


        if(car.getPriceCategory() == ECONOMY){

            totalPrice = numberOfDays() * 15;


        }else if(car.getPriceCategory() == MEDIUM){

            totalPrice = numberOfDays() * 25;


        }else if(car.getPriceCategory()== PREMIUM){

            totalPrice =numberOfDays() * 45;

        }else if (car.getPriceCategory()== SUPER){

            totalPrice = numberOfDays() * 200;

        }else{

            System.out.println("Try again");

        }
        if (totalPrice == 0.0){
            throw new IllegalArgumentException("Rent for at least a day");
        }

        return totalPrice;
    }

    //Constructor
    public CalculatePrice() {
    }

    public CalculatePrice(RentalCalendar calendar, Car car) {
        this.calendar = calendar;
        this.car = car;
    }

    //Getter and Setter

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCalendar(RentalCalendar calendar) {
        this.calendar = calendar;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
