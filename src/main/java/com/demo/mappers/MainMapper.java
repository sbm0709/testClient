package com.demo.mappers;


import com.demo.dto.ShopDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

    void insert_shop(ShopDTO shopDTO);

    void update_shop(ShopDTO shopDTO);

    ShopDTO select_shop(ShopDTO shopDTO);
}
