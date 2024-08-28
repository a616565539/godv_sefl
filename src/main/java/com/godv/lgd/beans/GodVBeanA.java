package com.godv.lgd.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: lgd
 * @description: BeanA
 * @author: GodV
 **/
@Component
@Order(1)
public class GodVBeanA {

    @Autowired
    GodVBeanB godVBeanB;
}
