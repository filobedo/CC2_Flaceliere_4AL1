package ff.CC2flaceliere.model;

import java.util.InvalidPropertiesFormatException;

public final class UserBuilder {
    private StatePaiementUser statePaiementUser;
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private TypeUser typeUser;
    private Address address;
    private Skills skill;

    public UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withStatePaiementUser(StatePaiementUser statePaiementUser) {
        this.statePaiementUser = statePaiementUser;
        return this;
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
        return this;
    }

    public UserBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }
    public UserBuilder withSkill(Skills skill) {
        this.skill = skill;
        return this;
    }

    public User build() throws InvalidPropertiesFormatException {
        User user = new User(id, firstName, lastName, mail, password, typeUser, address,skill);
        user.setStatePaiementUser(statePaiementUser);
        return user;
    }
}
