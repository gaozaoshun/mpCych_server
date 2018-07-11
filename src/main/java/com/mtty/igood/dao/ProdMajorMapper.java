package com.mtty.igood.dao;

import com.mtty.igood.model.ProdMajor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdMajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdMajor record);

    int insertSelective(ProdMajor record);

    ProdMajor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdMajor record);

    int updateByPrimaryKey(ProdMajor record);

    List<ProdMajor> queryByOrder(@Param("orderBy") String order, @Param("start") Integer start, @Param("offset") Integer offset);
}