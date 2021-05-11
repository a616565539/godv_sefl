package com.godv.lgd.dao;

import lombok.*;

/**
 * @program: lgd
 * @description: 商品
 * @author: GodV
 * @create: 2021-05-09 19:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private Double price;
    private Boolean islist;

    private String name;

    public Good(Double price, String name) {
        this.price = price;
        this.name = name;
    }
}
