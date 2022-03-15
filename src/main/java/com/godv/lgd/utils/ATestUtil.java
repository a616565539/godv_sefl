package com.godv.lgd.utils;

import com.godv.lgd.service.ActionService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-01-26 14:28
 **/

public class ATestUtil {
    private static ActionService actionService;

    @PostConstruct
    public void init(){
        actionService= (ActionService) BeanUtil.getBean("actionService");
    }

    public static void utilPrint(){
        actionService.printTest();
    }
}
