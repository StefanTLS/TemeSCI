package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 03.06.2017.
 *
 */
public class CustomerRepositoryImpl<Customer> implements RepoInterface<Customer> {

    public List<Customer> customers = new ArrayList<>();
    /**
     * Create?
     * Adds a customer to repository
     *
     * @param customer some object
     */
    @Override
    public void add(Customer customer) {
        customers.add(customer);

    }

    /**
     * Read
     * Reads(finds) certain customer from the repository
     *
     * @param customer
     * @return
     */
    @Override
    public Customer findObj(Customer customer) {
        return customer;
    }

    /**
     * Update
     * Update customer
     * ?? - Use the set(index, element) method to replace the element at the specified index by the specified element?
     *
     * @param customer
     */
    @Override
    public void update(Customer customer) {
        customers.set(customers.indexOf(customer), customer);

    }

    /**
     * Delete customer from repository
     *
     * @param customer
     */
    @Override
    public void delete(Customer customer) {
        if (customer == null){
            throw new IllegalArgumentException();
        }
        customers.remove(customer);

    }

    /**
     * Returns all the customers from the repository
     *
     * @return List of customers
     */
    @Override
    public List<Customer> getAll() {
        if(customers.isEmpty()){
            throw new IllegalStateException();
        }
        return customers;
    }

    //Constructor
    public CustomerRepositoryImpl() {
    }
}

