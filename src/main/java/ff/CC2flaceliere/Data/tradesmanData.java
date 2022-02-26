package ff.CC2flaceliere.Data;

import com.google.gson.Gson;
import ff.CC2flaceliere.model.Skills;
import ff.CC2flaceliere.model.User;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class tradesmanData {

    private static ArrayList<User> listTradesman = new ArrayList<>();

    public static User getBestTradesman(Skills skill){
        List<User> availableTradesman = listTradesman.stream().filter(c -> c.isAvailable() == true && c.getSkill().getExperienceYears() >= skill.getExperienceYears() && c.getSkill().getCountry().toLowerCase().equals(skill.getCountry().toLowerCase())).collect(Collectors.toList());
        return availableTradesman.get(0);
    }

    public static User getTradesmanById(int tradesmanID){
        return listTradesman.stream().filter(c -> c.getId() == tradesmanID).collect(Collectors.toList()).get(0);

    }

    public static void setTradesmanNotAvailable(int tradesmanID){
        getTradesmanById(tradesmanID).setAvailable(false);
    }

    public static void setTradesmanAvailable(int tradesmanID){
        getTradesmanById(tradesmanID).setAvailable(true);
    }

    public static void setListTradesman(ArrayList<User> listTradesman) {
        tradesmanData.listTradesman = listTradesman;
    }

    public static void addtoListTradesman(User tradesman){
        tradesmanData.listTradesman.add(tradesman);
    }

    public static ArrayList<User> getListTradesman() {
        return listTradesman;
    }
}
