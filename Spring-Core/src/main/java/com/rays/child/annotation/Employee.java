package com.rays.child.annotation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("employee")
public class Employee extends Person {

    @PostConstruct
    public void initialize() {
        System.out.println("Initializing Employee..!!");
    }

    // override parent properties (like XML parent/child)
    @Value("child")
    public void setName(String name) {
        super.setName(name);
    }

    @Value("10")
    public void setAge(int age) {
        super.setAge(age);
    }
}
