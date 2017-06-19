package ro.sci.carrental.services;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 06.06.2017.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepositoryImpl customerRepositoryImpl; //parametru?

    //Constructor?


    public CustomerServiceImpl(CustomerRepositoryImpl customerRepositoryImpl) {
        this.customerRepositoryImpl = customerRepositoryImpl;
    }

    public List<Customer> findCustomersByName(String firsName, String lastName){
        List<Customer> foundCustomers = new ArrayList<Customer>();

        for (Customer customer : customerRepositoryImpl.getCustomers()){
            if (customer.getCustomerFirstName().equals(firsName) &&
                    customer.getCustomerLastName().equals(lastName)){
                foundCustomers.add(customer);
            }

        }
        return foundCustomers;
    }

    public List<Customer> printAdress (String firstName, String lastName){
        List<Customer> foundCustomers = new ArrayList<Customer>();
        for (Customer customer: customerRepositoryImpl.getCustomers()){
            if (customer.getCustomerFirstName().equals(firstName) && customer.getCustomerLastName().equals(lastName)){
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }





}
