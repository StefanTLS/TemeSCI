package ro.sci.carrental.services;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepositoryImpl;
import ro.sci.carrental.repository.RepoInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 06.06.2017.
 */
public class CustomerServiceImpl implements CustomerService<Customer>{

    private RepoInterface<Customer> customerRepository;

    public CustomerServiceImpl(RepoInterface<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Seach customers by first name only.
     *
     * @param firstName
     * @return
     */
    @Override
    public List<?extends Customer> findCustomerByFirstName(String firstName) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer: customerRepository.getAll()){
            if(customer.getCustomerFirstName().equals(firstName)){
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    /**
     * Search customers by first and last name
     *
     * @param firsName
     * @param lastName
     * @return
     */
    @Override
    public List findCustomersByFullName(String firsName, String lastName) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer: customerRepository.getAll()){
            if(customer.getCustomerFirstName().equals(firsName) && customer.getCustomerLastName().equals(lastName)){
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }
    //Customer
    public CustomerServiceImpl() {
    }
}
