package com.mtty.igood.service;

import com.mtty.igood.dao.ProdEssayMapper;
import com.mtty.igood.dao.ProdTypeMapper;
import com.mtty.igood.model.ProdEssay;
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
public class EssayService {
    @Autowired
    private ProdEssayMapper prodEssayDao;

    public ProdEssay queryById(Integer id){
        return prodEssayDao.selectByPrimaryKey(id);
    }

    public List<ProdEssay> queryByIds(String ids) {
        return prodEssayDao.queryByIds(ids);
    }

    public List<ProdEssay> queryHotBrowser(Integer start, Integer offset) {
        return prodEssayDao.queryHot(start,offset);
    }

    public List<ProdEssay> queryByQueryField(String queryField, Integer start, Integer offset) {
        return prodEssayDao.queryField(queryField,start,offset);
    }
}
