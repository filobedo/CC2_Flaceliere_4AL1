package ff.CC2flaceliere.controller;

import ff.CC2flaceliere.model.Skills;
import ff.CC2flaceliere.query.ProjectQuery;
import ff.CC2flaceliere.query.UserQuery;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.InvalidPropertiesFormatException;

@RestController
public class Get {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path = "/user", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUser() throws JSONException, InvalidPropertiesFormatException {
//            return "Greetings from Spring Boot!";
        return new ResponseEntity(UserQuery.getAllTradesman().toString(), HttpStatus.OK);
    }

    @GetMapping(path = "/projects", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPorjects() throws JSONException, InvalidPropertiesFormatException {
//            return "Greetings from Spring Boot!";
        return new ResponseEntity(ProjectQuery.getAllProjects().toString(), HttpStatus.OK);
    }

    @GetMapping(path = "/besttradesman", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBestTradesman(@RequestBody String skill) throws JSONException, InvalidPropertiesFormatException {
//            return "Greetings from Spring Boot!";
        JSONObject JSONSkill = new JSONObject(skill);
        return new ResponseEntity(UserQuery.selectTradesman(new Skills(JSONSkill.getInt("experienceyear"),JSONSkill.getString("country"))).toString(), HttpStatus.OK);
    }
    @GetMapping(path = "/user/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getStudent(@PathVariable("id") int studentId) throws JSONException, InvalidPropertiesFormatException {
        try {
            JSONObject user = UserQuery.getUserWithId(studentId);
            return new ResponseEntity(UserQuery.getUserWithId(studentId).toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("{\"message\":\"Bad id\"}", HttpStatus.BAD_REQUEST);

        }

    }
}


