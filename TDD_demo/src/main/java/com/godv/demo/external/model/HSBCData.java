package com.godv.demo.external.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-07-26 18:39
 **/

@Data
@Builder
public class HSBCData {

    String productName;

    BigDecimal productPrice;

}
