package com.mtty.igood.controller;

import com.alibaba.fastjson.JSONObject;
import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.WxUser;
import com.mtty.igood.service.WxLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desp
 * @Date 2018/4/27
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class LoginAPI {

    @Autowired
    private WxLoginService loginService;

    // 微信登录
    @PostMapping("wxLogin")
    public ResponseData login(@RequestBody JSONObject params){
        try {
            WxUser user = loginService.wxLogin(params);
            return ResponseData.success(user);
        } catch (Exception e) {
            return ResponseData.exception(e.getMessage());
        }

    }
}
