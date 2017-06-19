package ro.sci.carrental.repository;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Stefan on 18.06.2017.
 */
public interface CustomerRepository {
    //Getter
    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    List<Customer> findAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
