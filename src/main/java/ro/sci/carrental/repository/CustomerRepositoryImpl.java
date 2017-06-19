package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 03.06.2017.
 *
 */
public class CustomerRepositoryImpl implements CustomerRepository {


    public List<Customer> customers = new ArrayList<Customer>();

    //Constructors
    public CustomerRepositoryImpl(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerRepositoryImpl() {
    }


    //Getter
    public List<Customer> getCustomers() {
        return customers;
    }


    /**
     * Add a customer in List
     * @param customer Name
     */
    public void addCustomer(Customer customer){
         customers.add(customer);

    }

    /**
     * Read
     * @return All customers in the list
     */

    public List<Customer> findAllCustomers(){
        return customers;
    }

    /**
     * Update??
     * @param customer
     */
    public void updateCustomer(Customer customer){
        customers.set(customers.indexOf(customer),customer);


    }

    /**
     * Delete a customer from DB/List
     * @param customer
     */
    public void deleteCustomer(Customer customer){
        customers.remove(customer);
    }







}

