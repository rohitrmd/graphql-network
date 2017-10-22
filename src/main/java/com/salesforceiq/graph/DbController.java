package com.salesforceiq.graph;

import java.util.List;

public class DbController {

    // Query methods
    public List<User> getAllUsers(UserRepository userRepository, PostRepository postRepository) {
        List<User> allUsers = userRepository.getAllUsers();
        for (User user : allUsers){
            List<Post> posts = postRepository.findPostsByUserId(user);
            if(posts != null && posts.size() >0){
                user.addPosts(posts);
            }
        }
        return allUsers;
    }

    public User findUserById(String userId, UserRepository userRepository, PostRepository postRepository){
        User user = userRepository.findUserById(userId);
        List<Post> posts = postRepository.findPostsByUserId(user);
        user.addPosts(posts);
        return user;
    }

    public List<Post> findAllPosts(PostRepository postRepository){
        return postRepository.getAllPosts();
    }

    public Post findPostById(String id, PostRepository postRepository){
        return postRepository.findPostById(id);
    }

    // Mutation methods
    public User createUser(String name, int age, UserRepository userRepository) {
        User newUser = new User(name, age);
        userRepository.saveUser(newUser);
        return newUser;
    }

    public Post createPost(String title, String authorId, PostRepository postRepository){
        Post post = new Post(title ,authorId);
        postRepository.savePost(post);
        return post;
    }
}
