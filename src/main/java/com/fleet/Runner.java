package com.fleet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        HelloWorld hello1 = context.getBean(HelloWorld.class);
        HelloWorld hello2 = context.getBean(HelloWorld.class);
        hello1.say();
        System.out.println(hello1 == hello2);

        context.close();
    }
}
