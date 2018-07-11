package com.mtty.igood.model;

import java.util.Date;

public class ProdEssay {
    private Integer id;

    private String cover;

    private String title;

    private String content;

    private Date inTime;

    private Date updateTime;

    private Integer browserNum;

    private Integer sendNum;

    private Integer collectNum;

    private String prodIds;

    private String descp;

    private String author;

    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBrowserNum() {
        return browserNum;
    }

    public void setBrowserNum(Integer browserNum) {
        this.browserNum = browserNum;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getProdIds() {
        return prodIds;
    }

    public void setProdIds(String prodIds) {
        this.prodIds = prodIds == null ? null : prodIds.trim();
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp == null ? null : descp.trim();
    }

    public String getAuthor() {
        return author;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}