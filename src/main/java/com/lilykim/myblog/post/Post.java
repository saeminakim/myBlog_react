package com.lilykim.myblog.post;

import com.google.cloud.Timestamp;

import java.util.Date;

public class Post {

    private long id;
    private String author;
    private String title;
    private String[] category;
    private String content;
    private Timestamp createdTime;
    private Timestamp modifiedTime;
    private Date createdTimeC;
    private Date modifiedTimeC;
    private int delFlag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getCreatedTimeC() {
        return createdTimeC;
    }

    public void setCreatedTimeC(Date createTimeC) {
        this.createdTimeC = createTimeC;
    }

    public Date getModifiedTimeC() {
        return modifiedTimeC;
    }

    public void setModifiedTimeC(Date modifiedTimeC) {
        this.modifiedTimeC = modifiedTimeC;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
