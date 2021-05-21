package com.godv.lgd.controller;

import com.godv.lgd.dao.Good;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @PostMapping("/test01post")
    @ResponseBody
    @ApiOperation(value = "测试文档展示")
    public List<Good> postTest(@RequestBody @ApiParam Good good) {
        Good good1 = new Good();
        Good good2 = new Good();

        System.out.println(sName);
        return Arrays.asList(good1,good2);
    }



}

