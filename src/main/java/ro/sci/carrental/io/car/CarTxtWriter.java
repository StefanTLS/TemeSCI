package ro.sci.carrental.io.car;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ro.sci.carrental.domain.car.Car;
import ro.sci.carrental.io.TxtWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.ListIterator;

public class CarTxtWriter<Car> implements TxtWriter<Car> {

    private static final Logger LOGGER = Logger.getLogger(CarTxtWriter.class.getName());
    /**
     * Write in a txt file
     *
     * @param carRepo  Object to be written
     * @param file Destination file
     */
    @Override
    public void writeObj(List<Car> carRepo, File file) {

        Charset charset = Charset.forName("UTF8");

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {

            ListIterator iterator = carRepo.listIterator();

            while (iterator.hasNext()) {
                writer.write(iterator.next().toString());

                if (!iterator.hasNext()) {
                    break;
                }
                writer.write("\n");
            }

            LOGGER.log(Level.INFO, "Car list writing successful.");

        } catch (IOException e) {
            LOGGER.log(Level.WARN, "IO exception found!" + e);

        }
    }
}
