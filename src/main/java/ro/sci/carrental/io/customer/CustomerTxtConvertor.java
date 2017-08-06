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


        customer.setCustomerFirstName(tokens[0].trim());
        customer.setCustomerLastName(tokens[1].trim());
        customer.setCustomerAge(Integer.parseInt(tokens[2].replaceAll("[^0-9]", "")));
        customer.setCustomerTelephoneNumber(tokens[3].replaceAll("\\s+",""));
        customer.setCustomerAdress(new CustomerAdress(tokens[4].trim(), tokens[5].trim(),tokens[6].trim(),tokens[7].trim(),tokens[8].trim()));

        LOGGER.log(Level.INFO,"Customer in this list: " + customer);
        return customer;
    }
}
