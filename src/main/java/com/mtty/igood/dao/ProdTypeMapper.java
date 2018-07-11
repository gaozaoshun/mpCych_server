package com.mtty.igood.dao;

import com.mtty.igood.model.ProdType;

import java.util.List;

public interface ProdTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdType record);

    int insertSelective(ProdType record);

    ProdType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdType record);

    int updateByPrimaryKey(ProdType record);

    List<ProdType> queryAll();
}