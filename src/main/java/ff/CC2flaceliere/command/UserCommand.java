package ff.CC2flaceliere.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ff.CC2flaceliere.*;
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
        return result;
    }
}
