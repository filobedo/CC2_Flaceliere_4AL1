package ff.CC2flaceliere.model;

import java.util.InvalidPropertiesFormatException;

public class AddressFactory {
    public static Address GetAddress(int id, String city, int number, String street, String country) throws InvalidPropertiesFormatException {
        return new AddressBuilder()
                .withId(id)
                .withCity(city)
                .withNumber(number)
                .withStreet(street)
                .withCountry(country)
                .build();
    }
}
