package ff.CC2flaceliere.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ff.CC2flaceliere.*;
import ff.CC2flaceliere.Data.tradesmanData;
import ff.CC2flaceliere.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.InvalidPropertiesFormatException;

public final class UserCommand {

    private static final UserCommand INSTANCE = new UserCommand();

    private UserCommand() {
    }

    public static JsonObject addUser() throws InvalidPropertiesFormatException {
        JsonObject result = new JsonObject();
        result.addProperty("message", "insert ok");
        final User tradesMan = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_TRADESMAN)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .withSkill(new Skills(9,"France"))
                .build();

        tradesmanData.addtoListTradesman(tradesMan);
        return result;
    }


}
