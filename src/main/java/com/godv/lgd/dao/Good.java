package com.godv.lgd.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="user对象",description="用户对象user")
public class Good {
    @ApiModelProperty(value="价格",name="price")
    private Double price;


    private Boolean islist;
    private String name;

    public Good(Double price, String name) {
        this.price = price;
        this.name = name;
    }
}
