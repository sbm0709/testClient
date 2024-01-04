package com.demo.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ShopDTO {
    private String shopName;
    private String districtName;
    private int viewCount;
}
