package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 03.06.2017.
 *
 */
public class CustomerRepository {


    public List<Customer> customers = new ArrayList<Customer>();

    //Constructors
    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerRepository() {
    }


    //Getter
    public List<Customer> getCustomers() {
        return customers;
    }
    public void addCustomer( Customer customer){
         customers.add(customer);

    }
}

