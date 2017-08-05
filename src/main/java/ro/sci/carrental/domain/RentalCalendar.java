package ro.sci.carrental.domain;



import org.joda.time.Days;
import org.joda.time.LocalDate;



/**
 * Created by Stefan on 15.07.2017.
 * todo booking? in transactions pickup confirmation to change the car status
 */
public class RentalCalendar {

    private LocalDate pickupDate;
    private LocalDate returnDate;



    /**
     * Calculates the time period between pickUpDate and returnDate from calendar represented in number of days.
     * @return number of days as an integer.
     */
    public int numberOfDays() {
        Days intDays = Days.daysBetween(getPickupDate(), getReturnDate());
        String intValue = intDays.toString().replaceAll("[^0-9]", "");
        return Integer.parseInt(intValue);
    }



    //Constructor
    public RentalCalendar(LocalDate pickupDate, LocalDate returnDate) {

        if (pickupDate.isAfter(returnDate)){
            throw  new IllegalArgumentException("Return date should be after pickup date!");
        }
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
    }

    public RentalCalendar() {
    }

    //Getters and setters
    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {

        if (pickupDate.isAfter(returnDate)){
            throw  new IllegalArgumentException("Return date should be after pickup date!");
        }
        this.returnDate = returnDate;
    }


}
