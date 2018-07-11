package com.mtty.igood.controller;

import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.ProdMajor;
import com.mtty.igood.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/20
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class MajorAPI {
    @Autowired
    private MajorService majorService;

    // 0-desc 1-asc
    @GetMapping("majors/order/{orderBy}/{start}/{offset}")
    public ResponseData getMajor(@PathVariable("orderBy")Integer orderBy,@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdMajor> majorList = majorService.queryAll(orderBy,start,offset);
        if (majorList==null||majorList.size()==0){
            return ResponseData.empty("没有查询到数据");
        }
        return ResponseData.success(majorList);
    }
}
