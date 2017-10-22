package com.salesforceiq.graph;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver{
    private final UserRepository userRepository;

    public Query(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }

}
