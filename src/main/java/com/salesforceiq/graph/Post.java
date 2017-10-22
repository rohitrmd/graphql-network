package com.salesforceiq.graph;

public class Post {
    private final String id;
    private final String title;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }

    private final String authorId;

    public Post(String id, String title, String authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
    }

    public Post(String title, String authorId) {
        this(null, title, authorId);
    }


}
