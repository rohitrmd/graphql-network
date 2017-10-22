package com.salesforceiq.graph;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver{
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private static final DbController controller = new DbController();

    public Query(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<User> allUsers() {
        return controller.getAllUsers(userRepository, postRepository);
    }

    public User findUserById(String id) {
        return controller.findUserById(id, userRepository, postRepository);
    }

    public List<Post> allPosts(){
        return controller.findAllPosts(postRepository);
    }

    public Post findPostById(String id){
        return controller.findPostById(id, postRepository);
    }

}
