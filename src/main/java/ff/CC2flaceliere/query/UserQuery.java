package ff.CC2flaceliere.query;

import com.google.gson.Gson;
import ff.CC2flaceliere.model.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

public final class UserQuery {
    private static final UserQuery INSTANCE = new UserQuery();

    public static JSONObject getUserWithId(int id) throws JSONException, InvalidPropertiesFormatException, InvalidParameterException {
        if (id != 1)
            throw new InvalidParameterException("bad id");

        final User tradesMan = new User(1, "Fred", "Fla", "fred@gmail.com", "toto", TypeUser.USER_NEW_TRADESMAN, new Address(1, "Paris", 10, "Tourcoin street"));

        String bonhomme = new Gson().toJson(tradesMan);
        JSONObject result = new JSONObject(bonhomme);
        return result;
    }

    public static ArrayList<JSONObject> getUsers() throws JSONException, InvalidPropertiesFormatException {

        final User tradesMan = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_TRADESMAN)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin"))
                .build();

        final User contractor = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_CONTRACTOR)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin"))
                .build();


        ArrayList<JSONObject> result = new ArrayList<>();

        result.add(new JSONObject(new Gson().toJson(tradesMan)));
        result.add(new JSONObject(new Gson().toJson(contractor)));
        return result;
    }
}
