package ff.CC2flaceliere.model;

import java.util.InvalidPropertiesFormatException;

public final class AddressBuilder {
    private int id;
    private String city;
    private int number;
    private String street;
    private String country;

    public AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public Address build() throws InvalidPropertiesFormatException {
        return new Address(id, city, number, street,country);
    }
}
