package com.salesforceiq.graph;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
    private final UserRepository userRepository;

    public Mutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, int age) {
        User newUser = new User(name, age);
        userRepository.saveUser(newUser);
        return newUser;
    }
}
