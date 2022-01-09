package ff.CC2flaceliere;

import ff.CC2flaceliere.model.Address;
import ff.CC2flaceliere.model.TypeUser;
import ff.CC2flaceliere.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;

//public class main {
//    public static void main(String[] args) throws InvalidPropertiesFormatException {
//


//    }
//}
//
@SpringBootApplication
public class main {

    public static void main(String[] args) throws InvalidPropertiesFormatException {

        final User tradesMan = new User(1, "Fred", "Fla", "fred@gmail.com", "toto", TypeUser.USER_NEW_TRADESMAN, new Address(1, "Paris", 10, "Tourcoin street"));
        final User contractor = new User(2, "Fred", "Fla", "fred@gmail.com", "toto", TypeUser.USER_NEW_CONTRACTOR, new Address(1, "Paris", 10, "Tourcoin street"));

        final User userAdmin = new User(3, "Fred", "Fla", "fred@gmail.com", "toto", TypeUser.USER_ADMIN, new Address(1, "Paris", 10, "Tourcoin street"));


        System.out.println(tradesMan.getTypeUser());
        System.out.println(tradesMan.getStatePaiementUser());
        System.out.println("-----------");

        actionOnMember.updateStateOfCustomer(userAdmin, tradesMan, TypeUser.USER_TRADESMAN);
        actionOnMember.updatePaiementOfCustomer(tradesMan);

        System.out.println(tradesMan.getTypeUser());
        System.out.println(tradesMan.getStatePaiementUser());



        SpringApplication.run(main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}