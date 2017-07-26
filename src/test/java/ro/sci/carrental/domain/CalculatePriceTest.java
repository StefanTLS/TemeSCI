package ro.sci.carrental.domain;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import ro.sci.carrental.domain.car.Car;

import static org.junit.Assert.assertEquals;
import static ro.sci.carrental.domain.car.PriceCategory.*;


/**
 * Created by Stefan on 05.07.2017.
 */
public class CalculatePriceTest {

    CalculatePrice calculatePrice2 = null;
    RentalCalendar rentalDates2 = null;
    Car testCar2 = null;

    @Before
    public void beforeTest() throws Exception {
        calculatePrice2 = new CalculatePrice();
        rentalDates2 = new RentalCalendar(new LocalDate(2017,3,29), new LocalDate(2017,3,30));
        testCar2 = new Car("test", "test", ECONOMY);

        calculatePrice2.setCalendar(rentalDates2);
    }
    @Test
    public void testTest(){

        assertEquals(15, calculatePrice2.calculatePrice(testCar2), 0);
    }


    @Test
    public void testEconomy1Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,30));
        Car testCar = new Car("test", "test", ECONOMY);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 15;
        assertEquals(expected, result, 0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testEconomy0Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,29));
        Car testCar = new Car("test", "test", ECONOMY);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 0.0;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testEconomy1NormalYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2018,3,29));
        Car testCar = new Car("test", "test", ECONOMY);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 5475;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testEconomyLeapYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2015,3,29),
                new LocalDate(2016,3,29));
        Car testCar = new Car("test", "test", ECONOMY);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 5490;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testMedium1Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,30));
        Car testCar = new Car("test", "test", MEDIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 25;
        assertEquals(expected, result, 0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testMedium0Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,29));
        Car testCar = new Car("test", "test", MEDIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 0;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testMedium1NormalYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2018,3,29));
        Car testCar = new Car("test", "test", MEDIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 9125;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testMediumLeapYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2015,3,29),
                new LocalDate(2016,3,29));
        Car testCar = new Car("test", "test", MEDIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 9150;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testPremium1Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,30));
        Car testCar = new Car("test", "test", PREMIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 45;
        assertEquals(expected, result, 0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testPremium0Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,29));
        Car testCar = new Car("test", "test", PREMIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 0;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testPremium1NormalYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2018,3,29));
        Car testCar = new Car("test", "test", PREMIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 16425;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testPremiumLeapYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2015,3,29),
                new LocalDate(2016,3,29));
        Car testCar = new Car("test", "test", PREMIUM);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 16470;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testSuper1Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,30));
        Car testCar = new Car("test", "test", SUPER);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 200;
        assertEquals(expected, result, 0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSuper0Days() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2017,3,29));
        Car testCar = new Car("test", "test", SUPER);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 0;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testSuper1NormalYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2017,3,29),
                new LocalDate(2018,3,29));
        Car testCar = new Car("test", "test", SUPER);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 73000;
        assertEquals(expected, result, 0);

    }
    @Test
    public void testSuperLeapYear() throws Exception {
        //given
        CalculatePrice calculatePrice = new CalculatePrice();
        RentalCalendar rentalDates = new RentalCalendar(new LocalDate(2015,3,29),
                new LocalDate(2016,3,29));
        Car testCar = new Car("test", "test", SUPER);
        calculatePrice.setCalendar(rentalDates);
        calculatePrice.calculatePrice(testCar);

        //then
        double result = calculatePrice.calculatePrice(testCar);

        //evaluate
        double expected = 73200;
        assertEquals(expected, result, 0);

    }



}