package ff.CC2flaceliere;

import java.util.function.Predicate;
import ff.CC2flaceliere.kernel.Engine;
import ff.CC2flaceliere.model.Address;

@Engine
public class ValidationAddressEngine implements Predicate<Address> {

    private static final ValidationAddressEngine INSTANCE = new ValidationAddressEngine();

    private ValidationAddressEngine() {
    }

    public static ValidationAddressEngine getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean test(Address address) {
        return true;
    }

    public boolean isValidateAddress(Address address) {
        return address.getNumber() > 0;
    }
}
