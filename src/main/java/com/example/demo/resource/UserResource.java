package com.example.demo.resource;

import com.example.demo.model.User;
import com.example.demo.repository.MailRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {


    private UserRepository userRepository;
    private MailRepository mailRepository;

    public UserResource(UserRepository userRepository,
                         MailRepository mailRepository) {
        this.userRepository = userRepository;
        this.mailRepository = mailRepository;
    }




@GetMapping("/user/{userId}")

    public User getUserById(@PathVariable("userId") Long userId) {

        return userRepository.findById(userId).get();
    }




}
