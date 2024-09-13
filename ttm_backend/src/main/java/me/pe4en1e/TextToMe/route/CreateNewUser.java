package me.pe4en1e.TextToMe.route;

import me.pe4en1e.TextToMe.entity.User;
import me.pe4en1e.TextToMe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateNewUser {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    public boolean createUser(@RequestParam(name = "username") String username) {

        User user = User.builder()
                .username(username)
                .build();

        if (userRepository.existsByUsername(username)) return false;

        userRepository.save(user);
        return true;

    }

}
