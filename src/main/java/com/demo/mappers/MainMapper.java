package com.demo.mappers;


import com.demo.dto.ShopDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

    void insert_shop(ShopDTO shopDTO);

}
