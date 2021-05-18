package com.godv.lgd.bigdecimal;

import java.math.BigDecimal;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2021-05-14 09:33
 **/

public class BigDecimalTest {

    public static void main(String[] args) {
        System.out.println(new BigDecimal("-1").compareTo(BigDecimal.ZERO) < 0);
    }
}
