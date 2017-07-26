package ro.sci.carrental.io.car;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarWriter {

    private static final Logger LOGGER = Logger.getLogger("CarWriter");

    /**
     * Write in the cars file.
     * Create a row and put some cells in it.
     * Rows are 0 based.On row 0 the data types are described - DO NOT MODIFY
     * Create cells and set values. Give it a column number 0 based and a value
     * Data types based in columns is:
     * Column 0 - String carMaker;
     * Column 1 - String carModel;
     * Column 2 - String carType;
     * Column 3 - int carDoorsNumber;
     * Column 4 - int carMaxPassengers;
     * Column 5 - String carColor;
     * Column 6 - boolean carGps;
     * Column 7 - boolean carAutomaticGearbox;
     * Column 8 - FuelType fuelType; -----Enum type ---- you can set it to Upper Case
     * Column 9 - int carModelYear;
     * Column 10 - int carFuelTankCapacity;
     * Column 11 - int carPower;
     * Column 12 - double carFuelConsumption;
     * Column 13 - PriceCategory priceCategory; -----Enum type ---- you can set it to Upper Case
     * Column 14 - CarStatus carStatus; -----Enum type ---- you can set it to Upper Case
     */
    public void carWriter() {
        //new Workbook(file?)


        FileOutputStream fileOut = null;

        try (Workbook wb = new XSSFWorkbook()) {

            fileOut = new FileOutputStream("carsOut.xlsx");
            CreationHelper createHelper = wb.getCreationHelper();

            //new Sheet
            //ToDo Explore with sheet, row and cell styling(format, border, backgound, etc.) + other options
            Sheet sheet1 = wb.createSheet("cars");

            // Create a row and put some cells in it. Rows are 0 based.
            //Top row
            Row row0 = sheet1.createRow(0); // DO NOT MODIFY


            row0.createCell(0).setCellValue("Car Maker");
            row0.createCell(1).setCellValue("Car Model");
            row0.createCell(2).setCellValue("Car Type");
            row0.createCell(3).setCellValue("Car Doors Number");
            row0.createCell(4).setCellValue("Car Max Passengers");
            row0.createCell(5).setCellValue("Car Color");
            row0.createCell(6).setCellValue("Car has GPS - boolean");
            row0.createCell(7).setCellValue("Car has Automatic Gearbox - boolean");
            row0.createCell(8).setCellValue("Car fuel Type");
            row0.createCell(9).setCellValue("Car model year");
            row0.createCell(10).setCellValue("Car Fuel tank capacity");
            row0.createCell(11).setCellValue("Car Horse Power");
            row0.createCell(12).setCellValue("Car fuel consumption");
            row0.createCell(13).setCellValue("Car Price Category");
            row0.createCell(14).setCellValue("Car Status");


            // Create a row and put some cells in it. Rows are 0 based.
            // On row 0 the data types are described - DO NOT MODIFY
            // Test - New row
            Row row1 = sheet1.createRow(1);

            row1.createCell(0).setCellValue(createHelper.createRichTextString("Toyota"));//test
            row1.createCell(1).setCellValue(createHelper.createRichTextString("Prius"));
            row1.createCell(2).setCellValue("Family");
            row1.createCell(3).setCellValue(4);
            row1.createCell(4).setCellValue(5);
            row1.createCell(5).setCellValue("White");
            row1.createCell(6).setCellValue(true);
            row1.createCell(7).setCellValue(true);
            row1.createCell(8).setCellValue("Petrol".toUpperCase());
            row1.createCell(9).setCellValue(2014);
            row1.createCell(10).setCellValue(50);
            row1.createCell(11).setCellValue(120);
            row1.createCell(12).setCellValue(4.7);
            row1.createCell(13).setCellValue("Economy".toUpperCase());
            row1.createCell(14).setCellValue("Available".toUpperCase());

            // Write the output to a file
            wb.write(fileOut);
            LOGGER.log(Level.INFO, "\nCars Writing DONE.");
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Warning: Found IO exception!" + e);
        } finally {
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
