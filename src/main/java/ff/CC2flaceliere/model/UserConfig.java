package ff.CC2flaceliere.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.InvalidPropertiesFormatException;

//Not used for now
@Configuration
@ComponentScan(basePackageClasses = User.class)
public class UserConfig {

    @Bean
    public Address getAddress() throws InvalidPropertiesFormatException {
        return new Address(1, "Paris", 10, "Tourcoin street","France");
    }

    @Bean
    public int getId() {
        return 1;
    }

    @Bean
    public String getFirstName() {
        return "fred@toto";
    }

    @Bean
    public TypeUser getTypeUser() {
        return TypeUser.USER_NEW_CONTRACTOR;
    }
    @Bean
    public StatePaiementUser getStatePaiementUser() {
        return StatePaiementUser.CAN_NOT_PAY;
    }

    @Bean
    public Skills getSkills() {return new Skills(4,"France");}
}
