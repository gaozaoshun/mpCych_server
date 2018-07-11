package com.mtty.igood.controller;

import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.service.NavBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class NavBarAPI {
    @Autowired
    private NavBarService navBarService;
    // 获取所有navbar
    @GetMapping("navbars")
    public ResponseData getAll(){
        return ResponseData.success(navBarService.getAll());
    }

}
