package com.godv.lgd.controller;

import com.godv.lgd.dao.Good;
import com.godv.lgd.dao.huaqi.HqPoint;
import com.godv.lgd.utils.ATestUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


public class GodVController{


    @GetMapping("/test01")
    public void test01(){
    }

    @GetMapping("/testBean")
    public void testBean(){
//        ActionService actionService = (ActionService)BeanUtil.getBean("actionService");
//        actionService.printTest();
        ATestUtil.utilPrint();
    }

    @PostMapping("/test01post")
    @ResponseBody
    @ApiOperation(value = "测试文档展示")
    public List<Good> postTest(@RequestBody @ApiParam Good good) {
        Good good1 = new Good();
        Good good2 = new Good();

        return Arrays.asList(good1,good2);
    }


    @GetMapping("/hqTest")
    @ResponseBody
    @ApiOperation(value = "测试文档展示")
    @GodV
    public List<HqPoint> hqTest() {


        HqPoint hqPoint1 = new HqPoint();
        HqPoint hqPoint2 = new HqPoint();
        hqPoint1.setX(111);
        hqPoint1.setY(222);
        hqPoint2.setY(111);
        hqPoint2.setY(222);
        hqPoint2.setStartTime(new Date());

        return Arrays.asList(hqPoint1,hqPoint2);
    }

    @GetMapping("/utTest")
    public void utTest() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> godVController = Class.forName("com.godv.lgd.controller.GodVController");
        Method[] methods = godVController.getMethods();
        Arrays.stream(methods).forEach(e->{
            System.out.println(e.toString());
            Annotation[] annotations = e.getDeclaredAnnotations();
            Arrays.stream(annotations).forEach(a->{
                if(a instanceof GodV) System.out.println("666666666");
            });
        });
    }


}

