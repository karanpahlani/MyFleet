package com.fleet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class HelloWorld {
    public void say(){
        System.out.println("Karan is the best");
    }
}


//property based DI @Autowired         constructor based DI no need for @Autowired

//@Qualifier("selectService name")

// ServiceLocatorFactoryBean

// when you create a component.