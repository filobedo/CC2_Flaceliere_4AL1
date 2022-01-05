package ff.CC2flaceliere;

public final class actionOnMember {


    static UpdatedCustomer updateStateOfCustomer(User admin, User customer, TypeUser typeUser) {
    if(isAdmin(admin)) {
        customer.setTypeUser(typeUser);
        return UpdatedCustomer.USER_UPDATED;
    }

    return UpdatedCustomer.USER_NOT_UPDATED;
    }

    static UpdatedCustomer updatePaiementOfCustomer(User customer) {
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
