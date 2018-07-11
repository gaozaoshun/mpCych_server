package com.mtty.igood.dao;

import com.mtty.igood.model.ProdCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProdCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdCar record);

    int insertSelective(ProdCar record);

    ProdCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdCar record);

    int updateByPrimaryKey(ProdCar record);

    List<ProdCar> queryByUid(@Param("uid") Integer uid);

    void delByUid(@Param("uid") Integer uid);
}