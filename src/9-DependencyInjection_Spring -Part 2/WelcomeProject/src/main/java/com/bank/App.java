package com.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        WelcomeService service =
                (WelcomeService) context.getBean("welcomeService");

        service.displayMessage();
    }
}