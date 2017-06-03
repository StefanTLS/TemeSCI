package ro.sci.carrental.domain;

/**
 * Created by Stefan on 29.05.2017.
 */
public class Customer {
    private String customerFirstName;
    private String customerLastName;
    private int customerAge;


//Constructor
    public Customer(String customerFirstName, String customerLastName, int customerAge){
        this.customerAge = customerAge;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    //Getters and Setters
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }
    //-----------------------------------------------






}