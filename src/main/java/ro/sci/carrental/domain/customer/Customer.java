package ro.sci.carrental.domain.customer;

import ro.sci.carrental.domain.customer.CustomerAdress;

/**
 * Created by Stefan on 29.05.2017.
 */
public class Customer {
    private String customerFirstName;
    private String customerLastName;
    private int customerAge;
    private String customerTelephoneNumber;
    private CustomerAdress customerAdress;


    //Constructors

    public Customer() {
    }

    public Customer(String customerFirstName, String customerLastName, int customerAge,
                    String customerTelephoneNumber, CustomerAdress customerAdress) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAge = customerAge;
        this.customerTelephoneNumber = customerTelephoneNumber;
        this.customerAdress = customerAdress;
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

    public String getCustomerTelephoneNumber() {
        return customerTelephoneNumber;
    }

    public void setCustomerTelephoneNumber(String customerTelephoneNumber) {
        this.customerTelephoneNumber = customerTelephoneNumber;
    }

    public CustomerAdress getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(CustomerAdress customerAdress) {
        this.customerAdress = customerAdress;
    }


    //-----------------------------------------------


    @Override
    public String toString() {
        return "Customer{" +
                "customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerAge=" + customerAge +
                ", customerTelephoneNumber='" + customerTelephoneNumber + '\'' +
                ", customerAdress=" + customerAdress +
                '}';
    }
}