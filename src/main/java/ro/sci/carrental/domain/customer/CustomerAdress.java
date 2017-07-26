package ro.sci.carrental.domain.customer;

/**
 * Created by Stefan on 03.06.2017.
 */
public class CustomerAdress {

    private String customerCountry;
    private String customerCity;
    private String customerStreet;
    private String customerAdressNumber;
    private String customerPostalCode;

    //Constructors

    public CustomerAdress() {
    }

    public CustomerAdress(String customerCountry, String customerCity, String customerStreet,
                          String customerAdressNumber, String customerPostalCode) {
        this.customerCountry = customerCountry;
        this.customerCity = customerCity;
        this.customerStreet = customerStreet;
        this.customerAdressNumber = customerAdressNumber;
        this.customerPostalCode = customerPostalCode;
    }
    //Getters and setters
    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerStreet() {
        return customerStreet;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public String getCustomerAdressNumber() {
        return customerAdressNumber;
    }

    public void setCustomerAdressNumber(String customerAdressNumber) {
        this.customerAdressNumber = customerAdressNumber;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }
}
