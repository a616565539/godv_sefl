package com.godv.lgd.controller;

import com.godv.lgd.dao.Good;
import com.godv.lgd.dao.huaqi.HqPoint;
import com.godv.lgd.utils.ATestUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/godv")
public class GodVController {

    @Value("${dao.test.name}")
    private String sName;

    @GetMapping("/test01")
    public void test01(){
        System.out.println(sName);
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

        System.out.println(sName);
        return Arrays.asList(good1,good2);
    }


    @GetMapping("/hqTest")
    @ResponseBody
    @ApiOperation(value = "测试文档展示")
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
}

