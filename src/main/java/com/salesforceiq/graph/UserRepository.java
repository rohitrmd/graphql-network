package com.salesforceiq.graph;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class UserRepository {
    private final MongoCollection<Document> users;

    public UserRepository(MongoCollection<Document> users) {
        this.users = users;
    }

    public User findUserById(String id) {
        Document doc = users.find(eq("_id", new ObjectId(id))).first();
        return user(doc);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        for (Document doc : users.find()) {
            allUsers.add(user(doc));
        }
        return allUsers;
    }

    public void saveUser(User user) {
        Document doc = new Document();
        doc.append("name", user.getName());
        doc.append("age", user.getAge());
        users.insertOne(doc);
    }

    private User user(Document doc) {
        return new User(
                doc.get("_id").toString(),
                doc.getString("name"),
                doc.getInteger("age"));
    }
}
