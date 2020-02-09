package com.example.demo;

import com.example.demo.model.Mail;
import com.example.demo.model.User;
import com.example.demo.repository.MailRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInjection {

    private UserRepository userRepository;
    private MailRepository mailRepository;

    public DataInjection(UserRepository userRepository,
                         MailRepository mailRepository) {
        this.userRepository = userRepository;
        this.mailRepository = mailRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void injectData(){

        User user1 = new User();
        user1.setName("Dima");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Olha");
        userRepository.save(user2);


        Mail mailD = new Mail();
        mailD.setAddress("dima@mail.com");
        mailD.setUser(user1);
        mailRepository.save(mailD);

        Mail mailD1 = new Mail();
        mailD1.setAddress("dima-another@mail.com");
        mailD1.setUser(user1);
        mailRepository.save(mailD1);

        Mail mailO = new Mail();
        mailO.setAddress("olha@mail.com");
        mailO.setUser(user2);
        mailRepository.save(mailO);









    }







}
