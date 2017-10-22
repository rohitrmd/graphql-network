package com.salesforceiq.graph;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final static DbController conroller = new DbController();

    public Mutation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public User createUser(String name, int age) {
        return conroller.createUser(name, age, userRepository);
    }

    public Post createPost(String title, String authorId){
       return conroller.createPost(title, authorId, postRepository);
    }
}
