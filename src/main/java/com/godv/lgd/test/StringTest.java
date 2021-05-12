package com.godv.lgd.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: lgd
 * @description: 字符串测试
 * @author: GodV
 * @create: 2021-05-12 10:01
 **/
@Slf4j
public class StringTest {

    public static void main(String[] args) {
        String format = String.format("等级映射分页查询数据异常----查询参数:{%s}", 11);
        System.out.println(format);
        try {
            int i =1/0;
        } catch (Exception e) {
            log.error("ssss",e);
        }
    }
}
