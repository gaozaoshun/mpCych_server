package com.mtty.igood.model;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class ProdType {
    private Integer id;

    private String icon;

    private String name;

    private Date inTime;

    private String essayIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInTime() {
        return DateFormatUtils.format(inTime,"yyyy-MM-dd HH:mm:ss");
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getEssayIds() {
        return essayIds;
    }

    public void setEssayIds(String essayIds) {
        this.essayIds = essayIds == null ? null : essayIds.trim();
    }
}