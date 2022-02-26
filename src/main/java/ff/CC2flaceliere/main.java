package ff.CC2flaceliere;

import ff.CC2flaceliere.Data.ProjectsData;
import ff.CC2flaceliere.model.*;
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

        final Project project1 = new Project(1,new Skills(6,"France"),"projet 1");
        ProjectsData.addProject(project1);
        final User tradesMan = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_CONTRACTOR)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .build();
        final User contractor = new UserBuilder()
                .withId(2)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_CONTRACTOR)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .build();

        final User userAdmin = new UserBuilder()
                .withId(3)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_ADMIN)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .build();


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