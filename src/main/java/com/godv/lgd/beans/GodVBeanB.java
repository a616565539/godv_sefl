package com.godv.lgd.beans;

import io.swagger.annotations.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 **/
@Order(2)
@Service
@Controller
@Configuration
@Component
public class GodVBeanB {

    @Autowired
    GodVBeanA godVBeanA;

    @Autowired
    ScopeGodVBean scopeGodVBean;
}
