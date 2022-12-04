package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.Date;

public class Post {
    private Integer id;
    private Integer userId;
    private Date postDate;
    private String title;
    private String description;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Date getPostDate() {
        return postDate;
    }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Post(Integer id, Integer userId, Date postDate, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.postDate = postDate;
        this.title = title;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Post [id=" + id + ", userId=" + userId + ", postDate=" + postDate + ", title=" + title
                + ", description=" + description + "]";
    }
}
