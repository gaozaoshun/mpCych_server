package com.mtty.igood.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mtty.igood.model.ProdBuyRecord;
import com.mtty.igood.model.ProdInfo;

import java.util.List;

/**
 * @Desp 产品信息，购买记录，热销推荐，正在热卖
 * @Date 2018/4/24
 * @Author mtty
 */
public class ProductDetail extends ProdInfo {
    // 已售数量
    private Integer sellNum;
    // 浏览量
    private Integer browserNum;
    // 商品尺寸json
    private String sizeJson;
    // 购买记录
    private List<ProdBuyRecord> recordList;
    // 热销推荐
    private List<ProdInfo> hotProdList;
    // 正在热卖
    private List<ProdInfo> sellProdList;

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public List<ProdBuyRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<ProdBuyRecord> recordList) {
        this.recordList = recordList;
    }

    public List<ProdInfo> getHotProdList() {
        return hotProdList;
    }

    public void setHotProdList(List<ProdInfo> hotProdList) {
        this.hotProdList = hotProdList;
    }

    public List<ProdInfo> getSellProdList() {
        return sellProdList;
    }

    public void setSellProdList(List<ProdInfo> sellProdList) {
        this.sellProdList = sellProdList;
    }

    public Integer getBrowserNum() {
        return browserNum;
    }

    public void setBrowserNum(Integer browserNum) {
        this.browserNum = browserNum;
    }

    public JSONArray getSizeJson() {
        return JSONObject.parseArray(sizeJson);
    }

    public void setSizeJson(String sizeJson) {
        this.sizeJson = sizeJson;
    }
}
