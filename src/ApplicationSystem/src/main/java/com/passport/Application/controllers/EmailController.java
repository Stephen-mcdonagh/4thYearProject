package com.passport.Application.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    //Sends email if endpoint is hit
    //this happens when application is complete
    @RequestMapping("api/v1/email")
    @ResponseBody
    String home() {
        try{
            sendEmail();
            return "Email Sent!";
        }
        catch(Exception e){
            return "Error in sending email: "+e;
        }
    }

    //Using Google SMTP server we are able to send emails
    //Mime Message helps with
    public void sendEmail() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mailHelper = new MimeMessageHelper(message);

        int usersOrderNumber = generateRandomOrderNumber();

        mailHelper.setTo("mcdonagh1996@gmail.com");
        mailHelper.setText("Thank you for your passport order. The order has been received. Your order Number is " + usersOrderNumber);
        mailHelper.setSubject("Passport Order Confirmation");
        mailSender.send(message);

    }

    //Used for 'order number'
    public static int generateRandomOrderNumber(){
        Random rand = new Random();

        int randomOrderNumber = rand.nextInt(100000);

        return randomOrderNumber;

    }
}
