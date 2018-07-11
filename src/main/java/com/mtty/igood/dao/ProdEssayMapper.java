package com.mtty.igood.dao;

import com.mtty.igood.model.ProdEssay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdEssayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdEssay record);

    int insertSelective(ProdEssay record);

    ProdEssay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdEssay record);

    int updateByPrimaryKey(ProdEssay record);

    List<ProdEssay> queryByIds(@Param("ids") String ids);

    List<ProdEssay> queryHot(@Param("start") Integer start, @Param("offset") Integer offset);

    List<ProdEssay> queryField(@Param("field") String queryField,  @Param("start")Integer start,  @Param("offset")Integer offset);
}