package com.example.demo.repository;

import com.example.demo.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {

    List<Mail> findByUserId(Long UserId);

}
