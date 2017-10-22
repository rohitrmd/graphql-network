package com.salesforceiq.graph;


import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private final String name;
    private final int age;
    private List<Post> posts = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public User(String id, String name, int age, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.posts = posts;
    }

    public User(String id, String name, int age) {
        this(id, name, age, null);
    }

    public User(String name, int age) {
        this(null, name, age);
    }

    public void addPosts(List<Post> posts){
        this.posts = posts;
    }

}
