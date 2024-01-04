package com.demo.service;


import com.demo.dto.ShopDTO;
import com.demo.mappers.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    MainMapper mainMapper;

    public void insert_shop(ShopDTO shopDTO){mainMapper.insert_shop(shopDTO);}

    public void update_shop(ShopDTO shopDTO){mainMapper.update_shop(shopDTO);}

    public ShopDTO select_shop(ShopDTO shopDTO){return mainMapper.select_shop(shopDTO);}
}
