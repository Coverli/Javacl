package com.Advance.Reflection.CreateObject;

public class Worker extends Person {

    private String factory;

    public Worker(String name, int age, String factory) {
        super(name, age);
        this.factory = factory;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
