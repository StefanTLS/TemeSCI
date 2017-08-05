package ro.sci.carrental.domain.transactions;

import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.domain.car.CarStatus;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CarRepositoryImpl;
import ro.sci.carrental.repository.CustomerRepositoryImpl;

import static ro.sci.carrental.domain.car.CarStatus.*;

public class Transaction {

    private int transactionID;
    private Car car;
    private Customer customer;
    private CarRepositoryImpl carRepository;
    private CustomerRepositoryImpl customerRepository;


    private void rentACar(Customer customer, Car car) {
       if (car.getCarStatus() != AVAILABLE){
           System.out.println("This car is unavailable for rental. Please pick another.");
           throw new IllegalArgumentException();
       }


    }

}
