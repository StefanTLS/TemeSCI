package ro.sci.carrental.services;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Stefan on 18.06.2017.
 */
public interface CustomerService {



    List<Customer> findCustomersByName(String firsName, String lastName);













}
