package ff.CC2flaceliere.controller;

import ff.CC2flaceliere.Data.ProjectsData;
import ff.CC2flaceliere.query.UserQuery;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.InvalidPropertiesFormatException;

@RestController
public class Put {
    @PutMapping(path = "/closeproject", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity closeProject(@RequestBody String body) throws JSONException, InvalidPropertiesFormatException {
//            return "Greetings from Spring Boot!";
        JSONObject paramsID = new JSONObject(body);
        ProjectsData.endProject(paramsID.getInt("projectid"));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
