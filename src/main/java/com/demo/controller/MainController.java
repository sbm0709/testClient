package com.demo.controller;



import com.demo.dto.ShopDTO;
import com.demo.service.MainService;
import com.demo.service.RestTemplateService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Log4j2
@Controller
public class MainController {

    @Autowired
    RestTemplateService restTemplateService;

    @Autowired
    MainService mainService;


    @GetMapping("/client")
    public void home(){}


    @PostMapping("/getinfo")
    @ResponseBody
    public String getinfo(
            @RequestParam String perPage,
            @RequestParam String page
            ){
//        log.warn("getinfo_perPage : " + perPage);
//        log.warn("getinfo_shopDTO : " + shopDTO);
        return restTemplateService.getShoplist(perPage, page);
    }

    @PostMapping("/update")
    @ResponseBody
    public ShopDTO info(@RequestBody ShopDTO shopDTO){
//        log.error(shopDTO);
        ShopDTO select_shop = mainService.select_shop(shopDTO);
//        log.error("select_shop : "+select_shop);
        if(Objects.isNull(select_shop)){
            mainService.insert_shop(shopDTO);
            return shopDTO;
        }
        else {
            select_shop.setViewCount(select_shop.getViewCount()+1);
            mainService.update_shop(select_shop);
            return select_shop;
        }
    }




}
