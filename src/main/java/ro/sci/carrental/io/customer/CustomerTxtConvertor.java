package ro.sci.carrental.io.customer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.domain.customer.CustomerAdress;
import ro.sci.carrental.io.Convertor;
import ro.sci.carrental.io.InvalidEntityException;

public class CustomerTxtConvertor implements Convertor<Customer> {
    private static final Logger LOGGER = Logger.getLogger(CustomerTxtConvertor.class.getName());

    /**
     * Convert string lines
     *
     * @param convertedString lines of strings
     * @return .
     * @throws InvalidEntityException .
     */
    @Override
    public Customer convert(String convertedString) throws InvalidEntityException {

        String[] tokens = convertedString.split(";");
        if (tokens.length != 9) {
            throw new InvalidEntityException("Invalid Customer Description");
        }

        Customer customer = new Customer();


        customer.setCustomerFirstName(tokens[0]);
        customer.setCustomerLastName(tokens[1]);
        customer.setCustomerAge(Integer.parseInt(tokens[2].replaceAll("[^0-9]", "")));
        customer.setCustomerTelephoneNumber(tokens[3]);
        customer.setCustomerAdress(new CustomerAdress(tokens[4], tokens[5],tokens[6],tokens[7],tokens[8]));

        LOGGER.log(Level.INFO,"Customer in this list: " + customer);
        return customer;
    }
}
