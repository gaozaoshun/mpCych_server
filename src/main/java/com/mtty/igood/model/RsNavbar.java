package com.mtty.igood.model;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class RsNavbar {
    private Integer id;

    private String img;

    private Date inTime;

    private Integer essayId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getInTime() {
        return DateFormatUtils.format(inTime,"yyyy-MM-dd HH:mm:ss");
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }
}