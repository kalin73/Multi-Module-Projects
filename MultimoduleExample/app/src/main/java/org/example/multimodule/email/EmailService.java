package org.example.multimodule.email;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendEmail(){
        System.out.println("Email service is working!!!");
    }
}
