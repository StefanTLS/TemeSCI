package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Stefan on 11.06.2017.
 */
public interface CustomerRepository {



    void addCustomer (Customer customer);

    List<Customer> findAll();

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);




}
