package com.mtty.igood.dao;

import com.mtty.igood.model.ProdBuyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdBuyRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdBuyRecord record);

    int insertSelective(ProdBuyRecord record);

    ProdBuyRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdBuyRecord record);

    int updateByPrimaryKey(ProdBuyRecord record);

    List<ProdBuyRecord> queryByPid(@Param("pid") Integer id, @Param("start") Integer start, @Param("offset") Integer offset);
}