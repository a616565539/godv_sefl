package com.godv.lgd.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @program: qt-core
 * @description: 等级映射 VO
 * @author: GodV
 * @create: 2021-05-11 09:40
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelMappingVO {

    private double price;

    //加密主键ID  新增/修改标识
    private long id;

    //平台name
    private String platformName;

    //商家name
    private String shopName;

    
    //平台id
    private long platformId;

    
    //商家id
    private long shopId;

    
    //外部值
    private String extValue;

    
    //内部值
    private String innerValue;

    
    //状态  启用1  停用0
    private int status;

    
    //key文本框
    private String setKey;


}
