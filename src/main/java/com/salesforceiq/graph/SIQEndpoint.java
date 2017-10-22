package com.salesforceiq.graph;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class SIQEndpoint extends SimpleGraphQLServlet {
    private static final UserRepository userRepository;
    private static final PostRepository postRepository;

    static {
        MongoDatabase mongo = new MongoClient().getDatabase("graphql");
        userRepository = new UserRepository(mongo.getCollection("users"));
        postRepository = new PostRepository(mongo.getCollection("posts"));
    }

    public SIQEndpoint() {
        super(buildSchema());
    }


    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(userRepository, postRepository), new Mutation(userRepository, postRepository))
                .build()
                .makeExecutableSchema();
    }
}
