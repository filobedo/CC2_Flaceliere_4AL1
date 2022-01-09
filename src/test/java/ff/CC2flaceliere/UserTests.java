package ff.CC2flaceliere;

import ff.CC2flaceliere.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    @Test
    void test_user_bean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = context.getBean("user", User.class);
        assertEquals("Tourcoin street", user.getAddress().getStreet());
        assertEquals(10, user.getAddress().getNumber());
    }

    @Test
    void test_update_paiement_customer() throws InvalidPropertiesFormatException {
        final User contractor = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_CONTRACTOR)//1, "Paris", 10, "Tourcoin street"
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin"))
                .build();

        final User tradesMan = new UserBuilder()
                .withId(2)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_TRADESMAN)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin"))
                .build();

        final User userAdmin = new UserBuilder()
                .withId(3)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_ADMIN)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin"))
                .build();

        System.out.println(tradesMan.getTypeUser());
        System.out.println(tradesMan.getStatePaiementUser());
        System.out.println("-----------");

        actionOnMember.updateStateOfCustomer(userAdmin, tradesMan, TypeUser.USER_TRADESMAN);
        actionOnMember.updatePaiementOfCustomer(tradesMan);

        System.out.println(tradesMan.getTypeUser());
        System.out.println(tradesMan.getStatePaiementUser());
    }
}
