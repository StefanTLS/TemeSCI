package ro.sci.carrental.io.car;

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarReader {

    private static final Logger LOGGER = Logger.getLogger("CarReader");

    public List<Cell> carReader() {

        List<Cell> listInputCars = new ArrayList<>();

        try {
            InputStream fileIn = new FileInputStream("carsIn.xlsx");
            Workbook wb = WorkbookFactory.create(fileIn);

            Sheet sheet = null;
            Row row = null;
            Cell cell = null;


            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                sheet = wb.getSheetAt(i);
                for (int j = 1; j < sheet.getLastRowNum(); j++) {
                    row = sheet.getRow(j);
                    for (Cell cell1: row) {
                        listInputCars.add(cell1);

                    }

                }
            }


            LOGGER.log(Level.INFO, "\nCars Reading DONE." );
        }catch (Exception e) {
            LOGGER.log(Level.WARNING, "Warning: Found IO exception!" + e );
        }
        return listInputCars;
    }


}
