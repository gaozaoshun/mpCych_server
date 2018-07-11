package com.mtty.igood.dao;

import com.mtty.igood.model.WxUser;
import org.apache.ibatis.annotations.Param;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);

    WxUser queryByOpenId(@Param("openid") String openid);
}