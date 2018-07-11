package com.mtty.igood.service;

import com.alibaba.fastjson.JSON;
import com.mtty.igood.dao.ProdCarMapper;
import com.mtty.igood.model.ProdCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Desp
 * @Date 2018/4/27
 * @Author mtty
 */
@Service
public class CarService {
    @Autowired
    private ProdCarMapper carDao;
    public List<ProdCar> getCarList(Integer uid) {
        return carDao.queryByUid(uid);
    }

    public void saveCarList(List<ProdCar> prodCarList) throws Exception {
        if (prodCarList!=null&&prodCarList.size()>0){
            Integer uid = prodCarList.get(0).getUid();
            carDao.delByUid(uid);
            for (ProdCar car : prodCarList){
                // 插入
                car.setInTime(new Date());
                int flag = carDao.insertSelective(car);
                if (flag==0){
                    throw new Exception("insert购物车数据库失败:"+ JSON.toJSONString(car));
                }
            }
        }
    }
}
