package ro.sci.carrental.io.customer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.io.TxtWriter;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.ListIterator;

public class CustomerTxtWriter<Customer> implements TxtWriter<Customer> {

    private static final Logger LOGGER = Logger.getLogger(CustomerTxtWriter.class.getName());
    /**
     * Write in a txt file
     *
     * @param customers    Object to be written
     * @param file Destination file
     */
    @Override
    public void writeObj(List<Customer> customers, File file) {


        Charset charset = Charset.forName("UTF8");

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {

            ListIterator iterator = customers.listIterator();

            while (iterator.hasNext()) {
                writer.write(iterator.next().toString());

                if (!iterator.hasNext()) {
                    break;
                }
                writer.write("\n");
            }

            LOGGER.log(Level.INFO, "Customer list writing successful.");

        } catch (IOException e) {
            LOGGER.log(Level.WARN, "IO exception found!" + e);

        }


    }
}
