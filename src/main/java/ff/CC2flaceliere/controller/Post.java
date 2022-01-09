package ff.CC2flaceliere.controller;

import ff.CC2flaceliere.command.UserCommand;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.InvalidPropertiesFormatException;

@RestController
public class Post {

    @PostMapping(path = "/user", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity index() throws InvalidPropertiesFormatException, JSONException {

        return new ResponseEntity(UserCommand.addUser().toString(), HttpStatus.CREATED);
    }

}
