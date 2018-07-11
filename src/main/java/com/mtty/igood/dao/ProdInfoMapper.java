package com.mtty.igood.dao;

import com.mtty.igood.dto.ProductDetail;
import com.mtty.igood.model.ProdInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdInfo record);

    int insertSelective(ProdInfo record);

    ProdInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdInfo record);

    int updateByPrimaryKey(ProdInfo record);

    List<ProdInfo> queryByIds(@Param("ids") String ids);

    List<ProdInfo> queryField(@Param("field") String queryField, @Param("start") Integer start, @Param("offset") Integer offset);

    List<ProdInfo> queryByInTime(@Param("orderBy") String orderBy, @Param("start") Integer start, @Param("offset") Integer offset);

    List<ProdInfo> queryRecommends(@Param("typeId") Integer typeId, @Param("start") Integer start, @Param("offset") Integer offset);

    List<ProdInfo> queryByBrowerNum(@Param("orderBy") String orderBy, @Param("start")Integer start, @Param("offset")Integer offset);

    List<ProdInfo> queryTypeByBrowerNum(@Param("typeId") Integer typeId, @Param("orderBy") String orderBy, @Param("start") Integer start, @Param("offset") Integer offset);

    ProductDetail queryById(@Param("id") Integer id);

    List<ProdInfo> queryByBuyNum(@Param("orderBy") String orderBy, @Param("start") int start, @Param("offset") int offset);
}