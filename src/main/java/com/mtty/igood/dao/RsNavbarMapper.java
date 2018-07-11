package com.mtty.igood.dao;

import com.mtty.igood.model.RsNavbar;

import java.util.List;

public interface RsNavbarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RsNavbar record);

    int insertSelective(RsNavbar record);

    RsNavbar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RsNavbar record);

    int updateByPrimaryKey(RsNavbar record);

    List<RsNavbar> queryAll();
}