package com.mtty.igood.service;

import com.mtty.igood.dao.ProdEssayMapper;
import com.mtty.igood.dao.ProdMajorMapper;
import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.ProdEssay;
import com.mtty.igood.model.ProdMajor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@Service
public class MajorService {
    @Autowired
    private ProdMajorMapper prodMajorDao;

    public List<ProdMajor> queryAll(Integer orderBy, Integer start, Integer offset) {
        String order = "desc";
        if (orderBy==1){
            order = "asc";
        }
        return prodMajorDao.queryByOrder(order,start, offset);
    }
}
