package engine.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody User user) {
        UserDetails dbUser = userService.loadUserByUsername(user.getEmail());
        if (dbUser != null) {
            return ResponseEntity.badRequest().body("The email [" + user.getEmail() + "] is already used! Please provide another email.");
        } else {
            userService.saveNewUser(user);
            dbUser = userService.loadUserByUsername(user.getEmail());
            return ResponseEntity.ok("User with ID [" + dbUser.getUsername() + "] has been created.");
        }
    }

}
