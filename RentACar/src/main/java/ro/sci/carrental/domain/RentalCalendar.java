package ro.sci.carrental.domain;

/**
 * Created by Stefan on 03.06.2017.
 */
public class RentalCalendar {

    private String pickupYear;
    private String pickupMonth;
    private String pickupDay;
    private String returnYear;
    private String returnMonth;
    private String returnDay;

//Constructor
    public RentalCalendar(String pickupYear, String pickupMonth, String pickupDay, String returnYear, String returnMonth, String returnDay) {
        this.pickupYear = pickupYear;
        this.pickupMonth = pickupMonth;
        this.pickupDay = pickupDay;
        this.returnYear = returnYear;
        this.returnMonth = returnMonth;
        this.returnDay = returnDay;
    }


    //Getter & Setter
    public String getPickupYear() {
        return pickupYear;
    }

    public void setPickupYear(String pickupYear) {
        this.pickupYear = pickupYear;
    }

    public String getPickupMonth() {
        return pickupMonth;
    }

    public void setPickupMonth(String pickupMonth) {
        this.pickupMonth = pickupMonth;
    }

    public String getPickupDay() {
        return pickupDay;
    }

    public void setPickupDay(String pickupDay) {
        this.pickupDay = pickupDay;
    }

    public String getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(String returnYear) {
        this.returnYear = returnYear;
    }

    public String getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(String returnMonth) {
        this.returnMonth = returnMonth;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }
}
