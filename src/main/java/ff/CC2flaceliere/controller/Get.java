package ff.CC2flaceliere.controller;

import ff.CC2flaceliere.command.UserCommand;
import ff.CC2flaceliere.query.UserQuery;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity(UserQuery.getUsers().toString(), HttpStatus.OK);
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


