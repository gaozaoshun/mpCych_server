package com.mtty.igood.controller;

import com.mtty.igood.dto.ProductDetail;
import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.ProdBuyRecord;
import com.mtty.igood.model.ProdInfo;
import com.mtty.igood.service.ProdInfoService;
import com.mtty.igood.service.ProdTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class ProductAPI {
    @Autowired
    private ProdTypeService prodTypeService;
    @Autowired
    private ProdInfoService prodInfoService;

    // 获取所有商品类型
    @GetMapping("prodTypes")
    public ResponseData getAll(){
        return ResponseData.success(prodTypeService.getAll());
    }

    // 根据ids获取商品详情
    @GetMapping("products/id/{ids}")
    public ResponseData getProducts(@PathVariable("ids") String ids){
        return ResponseData.success(prodInfoService.queryByIds(ids));
    }

    // 根据id获取商品详情
    @GetMapping("product/id/{id}")
    public ResponseData getProduct(@PathVariable("id") Integer id){
        // 商品信息
        ProductDetail detail = prodInfoService.queryById(id);
        // 购买记录
        List<ProdBuyRecord> recordList = prodInfoService.queryBuyRecord(id,0,10);
        // 热销推荐
        List<ProdInfo> prodInfoList = prodInfoService.queryByBuyNum(0,0,10);
        // 商品尺寸详情
        detail.setRecordList(recordList);
        detail.setHotProdList(prodInfoList);
        return ResponseData.success(detail);
    }

    // 根据搜索字段查询商品列表
    @GetMapping("products/query/{queryField}/{start}/{offset}")
    public ResponseData getQueryField(@PathVariable("queryField") String queryField,@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdInfo> prodInfoList = prodInfoService.queryByQueryField(queryField,start,offset);
        if (prodInfoList==null||prodInfoList.size()==0){
            return ResponseData.empty("没有查询数据");
        }
        return ResponseData.success(prodInfoList);
    }

    // 新发布商品列表：按时间排序 0-desc 1-asc
    @GetMapping("products/publishTime/{order}/{start}/{offset}")
    public ResponseData getNoes(@PathVariable("order") Integer order,@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdInfo> prodInfoList = prodInfoService.queryByPulishTime(order,start,offset);
        if (prodInfoList==null||prodInfoList.size()==0){
            return ResponseData.empty("没有查询数据");
        }
        return ResponseData.success(prodInfoList);
    }

    // 大家推荐，都在买
    @GetMapping("products/recommend/{start}/{offset}")
    public ResponseData getRecommend(@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdInfo> prodInfoList = prodInfoService.queryRecommendList(start,offset);
        if (prodInfoList==null||prodInfoList.size()==0){
            return ResponseData.empty("没有查询数据");
        }
        return ResponseData.success(prodInfoList);
    }

    // 单菜单推荐产品列表
    @GetMapping("products/recommend/{typeId}/{start}/{offset}")
    public ResponseData getRecommendType(@PathVariable("typeId")Integer typeId,@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdInfo> prodInfoList = prodInfoService.queryRecommendTypeList(typeId,start,offset);
        if (prodInfoList==null||prodInfoList.size()==0){
            return ResponseData.empty("没有查询数据");
        }
        return ResponseData.success(prodInfoList);
    }



    // 获取浏览量最高的产品列表
    // 0-desc 1-asc
    @GetMapping("products/browerNum/{orderBy}/{start}/{offset}")
    public ResponseData getBrowerNum(@PathVariable("orderBy")Integer orderBy,@PathVariable("start")Integer start,@PathVariable("offset")Integer offset){
        List<ProdInfo> prodInfoList = prodInfoService.queryByBrowerNum(orderBy,start,offset);
        if (prodInfoList==null||prodInfoList.size()==0){
            return ResponseData.empty("没有查询数据");
        }
        return ResponseData.success(prodInfoList);
    }

    // 单菜单推荐产品列表
    @GetMapping("products/type/{typeId}/browerNum/{orderBy}/{start}/{offset}")
    public ResponseData getBrowerNumer(@PathVariable("typeId")Integer typeId, @PathVariable("orderBy")Integer orderBy,@PathVariable("start")Integer start, @PathVariable("offset")Integer offset){
        List<ProdInfo> prodInfoList = prodInfoService.queryProdTypeList(typeId,orderBy,start,offset);
        if (prodInfoList==null||prodInfoList.size()==0){
            return ResponseData.empty("没有查询数据");
        }
        return ResponseData.success(prodInfoList);
    }
}