package com.mtty.igood.controller;

import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.WxContactMsg;
import com.mtty.igood.service.WxContactService;
import com.mtty.igood.util.SortUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Desp
 * @Date 2018/4/24
 * @Author mtty
 */
@RestController
@RequestMapping("wechat")
public class WeChatServiceAPI {

    @Value("${wechat.contact.token}")
    private String token;

    @Autowired
    private WxContactService wxContactService;

    /**
     * 微信客服服务验证接口
     *
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     */
    @GetMapping("talk")
    public String talk(String signature, String timestamp, String nonce, String echostr) {
        System.out.println("token=" + token);
        System.out.println("signature=" + signature);
        System.out.println("timestamp=" + timestamp);
        System.out.println("nonce=" + nonce);
        System.out.println("echostr=" + echostr);
        // 字典排序返回字符串
        String sortStr = SortUtil.dirtSort(token, timestamp, nonce);
        String sha1Str = DigestUtils.sha1Hex(sortStr);
        System.out.println("sha1Str=" + sha1Str);
        if (sha1Str.equals(signature)) {
            return echostr;
        }
        return "error";
    }

    @PostMapping("talk")
    public String receiveMsg(@RequestBody WxContactMsg msg) {
        System.out.println(msg);
        String msgType = msg.getMsgType();
        // 文本消息
        if ("text".equals(msgType)) {
        //图片消息
        } else if ("image".equals(msgType)) {

        // 小程序卡片消息
        } else if ("miniprogrampage".equals(msgType)){

        // 会话事件
        }else {

        }

        return "success";
    }

}
