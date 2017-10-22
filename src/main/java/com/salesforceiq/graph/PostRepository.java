package com.salesforceiq.graph;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PostRepository {
    private final MongoCollection<Document> posts;

    public PostRepository(MongoCollection<Document> posts) {
        this.posts = posts;
    }

    public Post findPostById(String id) {
        Document doc = posts.find(eq("_id", new ObjectId(id))).first();
        return post(doc);
    }

    public List<Post> findPostsByUserId(User user) {
        List<Post> allPosts = new ArrayList<>();
        for(Document doc :posts.find(eq("authorId", user.getId()))){
            if(doc != null) {
                allPosts.add(post(doc));
            }
        }
        return allPosts;
    }

    public List<Post> getAllPosts() {
        List<Post> allPosts = new ArrayList<>();
        for (Document doc : posts.find()) {
            allPosts.add(post(doc));
        }
        return allPosts;
    }

    public void savePost(Post post) {
        Document doc = new Document();
        doc.append("title", post.getTitle());
        doc.append("authorId", post.getAuthorId());
        posts.insertOne(doc);
    }

    private Post post(Document doc) {
        return new Post(
                doc.get("_id").toString(),
                doc.getString("title"),
                doc.getString("authorId"));
    }
}
