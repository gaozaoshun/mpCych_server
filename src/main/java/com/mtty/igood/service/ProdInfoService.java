package com.mtty.igood.service;

import com.mtty.igood.dao.ProdBuyRecordMapper;
import com.mtty.igood.dao.ProdInfoMapper;
import com.mtty.igood.dto.ProductDetail;
import com.mtty.igood.model.ProdBuyRecord;
import com.mtty.igood.model.ProdInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@Service
public class ProdInfoService {
    @Autowired
    private ProdInfoMapper prodInfoDao;
    @Autowired
    private ProdBuyRecordMapper prodBuyRecordDao;

    public List<ProdInfo> queryByIds(String ids){
        return prodInfoDao.queryByIds(ids);
    }

    public List<ProdInfo> queryByQueryField(String queryField, Integer start, Integer offset) {
        return prodInfoDao.queryField(queryField,start,offset);
    }

    public List<ProdInfo> queryByPulishTime(Integer order, Integer start, Integer offset) {
        String orderBy = "desc";
        if (order==1){
            orderBy = "asc";
        }
        return prodInfoDao.queryByInTime(orderBy,start,offset);
    }

    public List<ProdInfo> queryRecommendList(Integer start, Integer offset) {
        return prodInfoDao.queryRecommends(null,start,offset);
    }

    public List<ProdInfo> queryRecommendTypeList(Integer typeId, Integer start, Integer offset) {
        return prodInfoDao.queryRecommends(typeId,start,offset);
    }

    public List<ProdInfo> queryByBrowerNum(Integer orderBy, Integer start, Integer offset) {
        String order = "desc";
        if (orderBy==1){
            order = "asc";
        }
        return prodInfoDao.queryByBrowerNum(order,start,offset);
    }

    public List<ProdInfo> queryProdTypeList(Integer typeId, Integer orderBy, Integer start, Integer offset) {
        String order = "desc";
        if (orderBy==1){
            order = "asc";
        }
        return prodInfoDao.queryTypeByBrowerNum(typeId,order,start,offset);
    }

    public ProductDetail queryById(Integer id) {
        return prodInfoDao.queryById(id);
    }

    public List<ProdBuyRecord> queryBuyRecord(Integer id,Integer start,Integer offset) {
        return prodBuyRecordDao.queryByPid(id,start,offset);
    }


    public List<ProdInfo> queryByBuyNum(int orderBy, int start, int offset) {
        String order = "desc";
        if (orderBy==1){
            order = "asc";
        }
        return prodInfoDao.queryByBuyNum(order,start,offset);
    }
}
