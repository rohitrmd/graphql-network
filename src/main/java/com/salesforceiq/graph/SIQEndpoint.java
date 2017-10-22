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

    static {
        MongoDatabase mongo = new MongoClient().getDatabase("graphql");
        userRepository = new UserRepository(mongo.getCollection("network"));
    }

    public SIQEndpoint() {
        super(buildSchema());
    }


    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(userRepository), new Mutation(userRepository))
                .build()
                .makeExecutableSchema();
    }
}
