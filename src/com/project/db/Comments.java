package com.project.db;

import java.util.Date;

public class Comments {
    private Long id;
    private Users user;
    private Blogs blog;
    private String content;
    private Date postdate;
    private int active;

    public Comments() {
    }

    public Comments(Long id, Users user, Blogs blog, String content, Date postdate, int active) {
        this.id = id;
        this.user = user;
        this.blog = blog;
        this.content = content;
        this.postdate = postdate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
