package com.salesforceiq.graph;


public class User {
    private final String id;
    private final String name;
    private final int age;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(String name, int age) {
        this(null, name, age);
    }


}
