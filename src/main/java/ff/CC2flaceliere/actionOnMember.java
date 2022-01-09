package ff.CC2flaceliere;

import ff.CC2flaceliere.model.StatePaiementUser;
import ff.CC2flaceliere.model.TypeUser;
import ff.CC2flaceliere.model.User;

public final class actionOnMember {


    public static UpdatedCustomer updateStateOfCustomer(User admin, User customer, TypeUser typeUser) {
    if(isAdmin(admin)) {
        customer.setTypeUser(typeUser);
        return UpdatedCustomer.USER_UPDATED;
    }

    return UpdatedCustomer.USER_NOT_UPDATED;
    }

    public static UpdatedCustomer updatePaiementOfCustomer(User customer) {
        if(ValidationAddressEngine.getInstance().isValidateAddress(customer.getAddress())) {
            customer.setStatePaiementUser(StatePaiementUser.CAN_PAY);
            return UpdatedCustomer.USER_UPDATED;
        }

        return UpdatedCustomer.USER_NOT_UPDATED;
    }

    static Boolean isAdmin(User user) {
        return user.getTypeUser() == TypeUser.USER_ADMIN;
    }
}
