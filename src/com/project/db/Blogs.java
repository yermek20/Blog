package com.project.db;

import java.util.Date;

public class Blogs {
    private Long id;
    private Users author;
    private String title;
    private String shortContent;
    private String content;
    private Date postDate;
    private int active;

    private String fullName;

    public Blogs() {
    }

    public Blogs(Users author, String title, String shortContent, String content) {
        this.author = author;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
    }

    public Blogs(Long id, Users author, String title, String shortContent, String content, Date postDate, int active, String fullName) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.postDate = postDate;
        this.active = active;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
