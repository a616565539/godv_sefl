package com.godv.lgd.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 **/
@Configuration
public class GodVConfigurationBean {

    @Autowired
    GodVBeanA godVBeanA;

    @Autowired
    ScopeGodVBean scopeGodVBean;
}
