package ff.CC2flaceliere.query;

import com.google.gson.Gson;
import ff.CC2flaceliere.Data.ProjectsData;
import ff.CC2flaceliere.Data.tradesmanData;
import org.json.JSONArray;
import org.json.JSONException;

public class ProjectQuery {
    public static JSONArray getAllProjects() throws JSONException {
        return new JSONArray(new Gson().toJson(ProjectsData.getListProjects()));
    }
}
