package ro.sci.carrental.services;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Stefan on 18.06.2017.
 */
public interface CustomerService<Customer> {

    /**
     * Seach customers by first name only.
     * @param firstName
     * @return
     */
    List<?extends Customer>findCustomerByFirstName(String firstName);
    /**
     * Search customers by first and last name
     * @param firsName
     * @param lastName
     * @return
     */
    List<? extends Customer> findCustomersByFullName(String firsName, String lastName);



}