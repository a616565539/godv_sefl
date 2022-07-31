package com.godv.demo.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-07-26 18:43
 **/

@Data
@Builder
public class CitiData {

    Long productId;

    String productName;

    BigDecimal productPrice;

}
