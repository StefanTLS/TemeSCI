package ro.sci.carrental.domain;


import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;


/**
 * Created by Stefan on 15.07.2017.
 */
public class RentalCalendar {

    private LocalDate pickupDate;
    private LocalDate returnDate;



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
