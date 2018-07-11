package com.mtty.igood.service;

import com.mtty.igood.dao.ProdTypeMapper;
import com.mtty.igood.model.ProdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@Service
public class ProdTypeService {
    @Autowired
    private ProdTypeMapper prodTypeDao;

    public List<ProdType> getAll(){
        return prodTypeDao.queryAll();
    }
}
