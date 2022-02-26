package ff.CC2flaceliere.query;

import com.google.gson.Gson;
import ff.CC2flaceliere.Data.tradesmanData;
import ff.CC2flaceliere.model.*;
import org.json.JSONArray;
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

        final User tradesMan = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("fred@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_TRADESMAN)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .build();//new User(1, "Fred", "Fla", "fred@gmail.com", "toto", TypeUser.USER_NEW_TRADESMAN, new Address(1, "Paris", 10, "Tourcoin street","France"));

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
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .build();

        final User contractor = new UserBuilder()
                .withId(1)
                .withFirstName("Fred")
                .withLastName("Fla")
                .withMail("frederic.flaceliere@gmail.com")
                .withPassword("toto")
                .withTypeUser(TypeUser.USER_NEW_CONTRACTOR)
                .withAddress(AddressFactory.GetAddress(1, "Paris", 10, "Tourcoin","France"))
                .build();


        ArrayList<JSONObject> result = new ArrayList<>();

        result.add(new JSONObject(new Gson().toJson(tradesMan)));
        result.add(new JSONObject(new Gson().toJson(contractor)));
        return result;
    }

    public static JSONObject selectTradesman(Skills skill) throws JSONException {
        final User tradesMan = tradesmanData.getBestTradesman(skill);

        return new JSONObject(new Gson().toJson(tradesMan));
    }

    public static JSONArray getAllTradesman() throws JSONException {
        return new JSONArray(new Gson().toJson(tradesmanData.getListTradesman()));
    }
}
