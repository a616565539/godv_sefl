package com.godv.lgd.controller;

import com.godv.lgd.dao.Good;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


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
    public void postTest(@RequestBody Good good) {
        System.out.println(sName);
    }

}

