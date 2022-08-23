package com.godv.lgd.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-07-26 18:43
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitiData {

    Long productId;

    String productName;

    BigDecimal productPrice;

}
