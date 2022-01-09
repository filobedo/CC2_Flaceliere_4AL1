package ff.CC2flaceliere.model;

import java.util.InvalidPropertiesFormatException;

public final class Address {

    private final int id;
    private final String city;
    private final int number;
    private final String street;


    public Address(int id, String city, int number, String street) throws InvalidPropertiesFormatException {

        if (!checkStreetNumber(number)) {
            throw new InvalidPropertiesFormatException("Invalid street number");
        }

        this.id = id;
        this.city = city;
        this.number = number;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    private Boolean checkStreetNumber(int streetNumber) {
        return streetNumber > 0;
    }
}
