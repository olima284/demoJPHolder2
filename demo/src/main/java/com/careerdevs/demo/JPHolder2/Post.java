package com.careerdevs.demo.JPHolder2;

public class Post {
    private int id;
    private String title;

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Post() {}



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
