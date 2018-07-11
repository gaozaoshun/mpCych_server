package com.mtty.igood.controller;

import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.ProdEssay;
import com.mtty.igood.service.EssayService;
import com.mtty.igood.service.ProdTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class EssayAPI {
    @Autowired
    private EssayService essayService;
    // 根据ID获取文章
    @GetMapping("essay/{id}")
    public ResponseData getOne(@PathVariable("id") Integer id){
        return ResponseData.success(essayService.queryById(id));
    }

    // 根据IDS获取文章列表
    @GetMapping("essays/id/{ids}")
    public ResponseData getMore(@PathVariable("ids") String ids){
        return ResponseData.success(essayService.queryByIds(ids));
    }

    // 根据IDS获取文章列表
    @GetMapping("essays/query/{queryField}/{start}/{offset}")
    public ResponseData getEssayList(@PathVariable("queryField") String queryField,@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdEssay> prodEssayList = essayService.queryByQueryField(queryField,start,offset);
        if (prodEssayList == null || prodEssayList.size()==0){
            return ResponseData.empty("没有查询到对应数据");
        }
        return ResponseData.success(prodEssayList);
    }
}
