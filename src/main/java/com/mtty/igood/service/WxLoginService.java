package com.mtty.igood.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mtty.igood.dao.WxUserMapper;
import com.mtty.igood.model.WxUser;
import com.mtty.igood.util.MpDecryptUtil;
import com.mtty.igood.util.OkhttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Desp
 * @Date 2018/4/27
 * @Author mtty
 */
@Service
public class WxLoginService {

    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.secret}")
    private String secret;
    @Value("${wechat.api.jscode2session}")
    private String jscode2sessionAPI;

    @Autowired
    private WxUserMapper wxUserDao;


    public WxUser wxLogin(JSONObject params) throws Exception{
        params.put("appid",appid);
        params.put("secret",secret);
        try {
            // 获取微信用户完整信息
            String resultStr = OkhttpUtil.execute(jscode2sessionAPI,"get",params);
            JSONObject resultJSON = JSON.parseObject(resultStr);
            if (resultJSON.containsKey("errcode")){
                throw new Exception("[用户登录code换取session_key、openid] : "+resultJSON.toJSONString());
            }
            String openid = resultJSON.get("openid").toString();
            String session_key = resultJSON.get("session_key").toString();
            String encryptedData = params.get("encryptedData").toString();
            String iv = params.get("iv").toString();
            String wxUserInfo = MpDecryptUtil.getWxUserInfo(encryptedData,session_key,iv);
            WxUser wxUser = JSON.parseObject(wxUserInfo,WxUser.class);

            WxUser queryWxUser = wxUserDao.queryByOpenId(wxUser.getOpenid());
            // 数据库存在该微信用户，则更新登录时间
            if (queryWxUser!=null){
                WxUser updateWxUser = new WxUser();
                updateWxUser.setId(queryWxUser.getId());
                updateWxUser.setLastLoginTime(new Date());
                int flag = wxUserDao.updateByPrimaryKeySelective(updateWxUser);
                if (flag==0){
                    throw new Exception("[用户登录，更新最后一次登录时间失败]");
                }
            // 不存在则添加此微信用户
            }else{
                wxUser.setFirstLoginTime(new Date());
                wxUser.setLastLoginTime(new Date());
                int flag = wxUserDao.insertSelective(wxUser);
                if (flag==0){
                    throw new Exception("[用户登录，保存微信用户信息失败]");
                }
            }

            // 获取最新的微信用户信息
            return wxUserDao.queryByOpenId(wxUser.getOpenid());
        } catch (Exception e) {
            throw new Exception("[用户登录code换取session_key、openid] : "+e.getMessage());
        }
    }

    //
}
