package ro.sci.carrental.domain;

/**
 * Customer Class contains customers blueprint.
 *
 * @author Flaviu Lupoian
 * @version 1.0
 * @since 1.8
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;

    /**
     *
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     */

    // constructor
    public Customer(String firstName, String lastName, String streetAddress, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
