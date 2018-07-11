package com.mtty.igood.model;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class ProdBuyRecord {
    private Integer id;

    private Integer uid;

    private Integer pid;

    private Integer buyNum;

    private Date inTime;

    private String nickname;

    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getInTime() {
        return DateFormatUtils.format(inTime,"yyyy-MM-dd HH:mm:ss");
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}