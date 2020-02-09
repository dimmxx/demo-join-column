package com.example.demo;

import com.example.demo.model.Mail;
import com.example.demo.model.User;
import com.example.demo.repository.MailRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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

        Mail mailD = new Mail();
        mailD.setAddres("dima@mail.com");
        mailRepository.save(mailD);

        Mail mailO = new Mail();
        mailO.setAddres("olha@mail.com");
        mailRepository.save(mailO);



        User user1 = new User();
        user1.setName("Dima");
        user1.setMail(mailD);
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Olha");
        user2.setMail(mailO);
        userRepository.save(user2);





    }







}
