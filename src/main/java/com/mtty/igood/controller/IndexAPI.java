package com.mtty.igood.controller;

import com.alibaba.fastjson.JSONObject;
import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.ProdEssay;
import com.mtty.igood.model.ProdInfo;
import com.mtty.igood.service.EssayService;
import com.mtty.igood.service.ProdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/14
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class IndexAPI {
    @Autowired
    private EssayService essayService;
    @Autowired
    private ProdInfoService prodInfoService;

    // 首页ListCard信息
    @GetMapping("listCard/{start}/{offset}")
    public ResponseData listCard(@PathVariable("start") Integer start, @PathVariable("offset") Integer offset) {
        List<ProdEssay> prodEssayList = essayService.queryHotBrowser(start, offset);
        if (prodEssayList == null || prodEssayList.size() == 0) {
            return ResponseData.empty("没有更多数据了");
        }
        StringBuffer ids = new StringBuffer();
        for (ProdEssay essay : prodEssayList) {
            ids.append(essay.getProdIds() + ",");
        }
        List<ProdInfo> prodInfoList = prodInfoService.queryByIds(ids.deleteCharAt(ids.lastIndexOf(",")).toString());
        JSONObject data = new JSONObject();
        data.put("newsList", prodEssayList);
        data.put("prodList", prodInfoList);
        // todo 产品图
        data.put("hotTypeImg", "https://img.alicdn.com/tfscom/i4/384561703/TB2YE0tapHM8KJjSZFwXXcibXXa_!!384561703.jpg");
        return ResponseData.success(data);
    }
}
