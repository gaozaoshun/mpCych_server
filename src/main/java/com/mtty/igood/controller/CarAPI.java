package com.mtty.igood.controller;

import com.mtty.igood.dto.ResponseData;
import com.mtty.igood.model.ProdCar;
import com.mtty.igood.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/27
 * @Author mtty
 */
@RestController
@RequestMapping("api/v1")
public class CarAPI {
    @Autowired
    private CarService carService;

    @GetMapping("carList/{uid}")
    public ResponseData getCarList(@PathVariable("uid") Integer uid){
        List<ProdCar> carList = carService.getCarList(uid);
        return ResponseData.success(carList);
    }

    @PostMapping("carList")
    public ResponseData saveCarList(@RequestBody List<ProdCar> prodCarList){
        try {
            carService.saveCarList(prodCarList);
            return ResponseData.success("success");
        } catch (Exception e) {
            return ResponseData.exception(e.getMessage());
        }

    }
}
